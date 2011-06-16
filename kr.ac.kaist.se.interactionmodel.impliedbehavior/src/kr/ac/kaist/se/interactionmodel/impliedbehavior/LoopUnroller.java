package kr.ac.kaist.se.interactionmodel.impliedbehavior;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import kr.ac.kaist.se.interaction.idl.Branch;
import kr.ac.kaist.se.interaction.idl.Choreography;
import kr.ac.kaist.se.interaction.idl.Edge;
import kr.ac.kaist.se.interaction.idl.Final;
import kr.ac.kaist.se.interaction.idl.Gateway;
import kr.ac.kaist.se.interaction.idl.GatewayType;
import kr.ac.kaist.se.interaction.idl.IdlFactory;
import kr.ac.kaist.se.interaction.idl.Initial;
import kr.ac.kaist.se.interaction.idl.Interaction;
import kr.ac.kaist.se.interaction.idl.Join;
import kr.ac.kaist.se.interaction.idl.Node;
import kr.ac.kaist.se.interaction.idl.Participant;
import kr.ac.kaist.se.interaction.idl.SequenceFlow;

public class LoopUnroller {
	public static LoopUnroller INSTANCE;
	static {
		INSTANCE = new LoopUnroller();
	}

	private LoopUnroller() {

	}

	private List<Node> getInitialNodes(Choreography chor) {
		List<Node> ret = new Vector<Node>();
		for (Node node : chor.getNodes()) {
			if (node instanceof Initial && node.getIncomings().size() == 0)
				ret.add(node);
		}
		return ret;
	}

	private class VisibleHistory {
		private Vector<Node> history;

		public VisibleHistory() {
			history = new Vector<Node>();
		}

		public VisibleHistory nextHistory(Node node) {
			VisibleHistory ret = new VisibleHistory();
			ret.history = (Vector<Node>) history.clone();
			ret.removeRedundant();
			ret.history.add(node);
			return ret;
		}

		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append('<');
			for (Node n : history) {
				sb.append(getNodeName(n) + ":");
			}
			sb.append('>');
			sb.append(hashCode());
			return sb.toString();
		}

		private void removeRedundant() {
			for (int i = 0; i < history.size() - 1;) {
				int j = 0;
				for (j = i + 1; j < history.size(); j++) {
					if (history.get(i).equals(history.get(j))) {
						break;
					}
				}
				if (j == history.size()) {
					i++;
				} else {
					history.remove(i);
				}
			}
		}

		public int hashCode() {
			return history.hashCode();
		}

		public boolean equals(Object obj) {
			if (obj instanceof VisibleHistory) {
				return history.equals(((VisibleHistory) obj).history);
			}
			return false;
		}
	}

	private HashMap<Participant, Participant> participantMap = new HashMap<Participant, Participant>();
	private HashMap<Node, Node> newNode2OldNode = new HashMap<Node, Node>();
	private HashMap<Node, List<Node>> oldNode2NewNode = new HashMap<Node, List<Node>>();

	private class ReachabilityTest {
		private HashMap<Node, Set<Node>> forward = new HashMap<Node, Set<Node>>();
		private HashMap<Node, Set<Node>> backward = new HashMap<Node, Set<Node>>();

		public void addNode(Node node) {
			forward.put(node, new HashSet<Node>());
			backward.put(node, new HashSet<Node>());
		}

		public void addEdge(Node edgeFrom, Node edgeTo) {
			HashSet<Node> toSet = new HashSet<Node>();
			toSet.addAll(forward.get(edgeTo));
			toSet.add(edgeTo);

			HashSet<Node> fromSet = new HashSet<Node>();
			fromSet.addAll(backward.get(edgeFrom));
			fromSet.add(edgeFrom);

			for (Node from : fromSet) {
				for (Node to : toSet) {
					forward.get(from).add(to);
					backward.get(to).add(from);
				}
			}
		}

		public boolean isReachable(Node from, Node to) {
			return forward.get(from).contains(to);
		}

		public void clear() {
			forward.clear();
			backward.clear();
		}
	}

	private ReachabilityTest reach = new ReachabilityTest();
	private HashMap<Edge, Integer> visitedNum = new HashMap<Edge, Integer>();
	
	public Choreography unroll(Choreography org) {
		participantMap.clear();
		newNode2OldNode.clear();
		oldNode2NewNode.clear();
		reach.clear();
		visitedNum.clear();	
		
		List<Node> begin = getInitialNodes(org);
		if (begin.isEmpty())
			return null;
	
	
		Choreography ret = IdlFactory.eINSTANCE.createChoreography();
		for (Participant p : org.getParticipants()) {
			Participant newP = IdlFactory.eINSTANCE.createParticipant();
			newP.setName(p.getName());
			ret.getParticipants().add(newP);
			participantMap.put(p, newP);
		}

					
		for (Node node : begin) {
			boolean contCond = true;

			
			for( int visitLimit = 1; contCond; visitLimit++ )
			{
				for( Edge n : org.getEdges())
				{
					visitedNum.put(n, 0);
				}
				
				System.err.println(visitLimit);
				VisibleHistory nullVH = new VisibleHistory();
				HashSet<VisibleHistory> entireVH = new HashSet<VisibleHistory>();
				contCond = traverse(ret, node, null, nullVH, entireVH, visitLimit);
			}
		}
		
		
		return ret;
	}

	private Node cloneNode(Node node, Choreography chor) {
		Node ret = (Node) IdlFactory.eINSTANCE.create(node.eClass());
		ret.setOwner(chor);
		if (ret instanceof Gateway) {
			Gateway gateway = (Gateway) ret;
			gateway.setType(((Gateway) node).getType());
		} else if (ret instanceof Interaction) {
			Interaction oldI = (Interaction) node;
			Interaction newI = (Interaction) ret;
			newI.setName(oldI.getName());
			newI.setSender(participantMap.get(oldI.getSender()));
			for (Participant p : oldI.getReceiver()) {
				newI.getReceiver().add(participantMap.get(p));
			}
		}
		return ret;
	}

	private Node getExistingAndConnectedNewNode(Node prevNewNode,
			Node curOriginalNode) {
		Node ret = null;
		
		if( prevNewNode == null )
		{
			if( oldNode2NewNode.get(curOriginalNode) != null &&
					oldNode2NewNode.get(curOriginalNode).size() > 0 )
			{
				ret = oldNode2NewNode.get(curOriginalNode).get(0);
			}
		}
		else
		{
			for (Edge edge : prevNewNode.getOutgoings()) {
				Node candidateNewNode = edge.getTarget();
				if (newNode2OldNode.get(candidateNewNode) == curOriginalNode) {
					ret = candidateNewNode;
				}
			}
		}
		return ret;
	}

	private Node getExistingButNotConnectedNewNode(Node prevNewNode,
			Node curOriginalNode, int visitNum) {
		
		if( curOriginalNode instanceof Join && ((Join)curOriginalNode).getType().equals(GatewayType.IOR) )
		{
			System.err.println(curOriginalNode.toString());
		}
		List<Node> existingNodes = oldNode2NewNode.get(curOriginalNode);
		if (existingNodes == null)
			return null;

		for (Node node : existingNodes) {
			if (!reach.isReachable(node, prevNewNode)) {
				return node;
			}
		}

		return null;
	}

	private static String getNodeName(Node node) {
		if (node instanceof Branch)
			return "B" + ((Branch)node).getType().getLiteral();
		if (node instanceof Join)
			return "J" + ((Join)node).getType().getLiteral();
		if (node instanceof Interaction)
			return node.getName();
		if (node instanceof Initial)
			return "I";
		if (node instanceof Final)
			return "F";
		return "Unknown";
	}
	
	private boolean isExceededAll(int visitLimit)
	{
		for( int i : visitedNum.values() )
		{
			if( i < visitLimit )
			{
				return false;
			}
		}
		return true;
	}

	private boolean traverse(Choreography chor, Node curOriginalNode,
			Node prevNewNode, VisibleHistory prevVH,
			Set<VisibleHistory> entireVH, int visitLimit) {
		VisibleHistory curVH = prevVH;
		if (curOriginalNode instanceof Interaction) {
			// System.err.println("name:" + getNodeName(curOriginalNode) +
			// "\t entireVH:"+entireVH.toString());
			curVH = prevVH.nextHistory(curOriginalNode);
			if (entireVH.contains(curVH)) {
				System.err.println(entireVH);
				return false;
			}
			entireVH.add(curVH);
		}
		
		System.err.print(getNodeName(curOriginalNode) + ":");


		Node newNode = null;
		
		newNode = getExistingAndConnectedNewNode(prevNewNode,
				curOriginalNode);
		if (prevNewNode != null) {
			if (newNode == null) {
				newNode = getExistingButNotConnectedNewNode(prevNewNode,
						curOriginalNode, visitLimit);

				if (newNode != null && prevNewNode != null) {
					SequenceFlow sf = IdlFactory.eINSTANCE.createSequenceFlow();
					sf.setSource(prevNewNode);
					sf.setTarget(newNode);
					sf.setOwner(chor);
					reach.addEdge(prevNewNode, newNode);
				}
			}
		}
	
		if (newNode == null) {
			newNode = cloneNode(curOriginalNode, chor);
			List<Node> set = oldNode2NewNode.get(curOriginalNode);
			if (set == null) {
				set = new Vector<Node>();
				oldNode2NewNode.put(curOriginalNode, set);
			}
			set.add(newNode);
			newNode2OldNode.put(newNode, curOriginalNode);
			reach.addNode(newNode);

			if (prevNewNode != null) {
				SequenceFlow sf = IdlFactory.eINSTANCE.createSequenceFlow();
				sf.setSource(prevNewNode);
				sf.setTarget(newNode);
				sf.setOwner(chor);
				reach.addEdge(prevNewNode, newNode);
			}
		}
		boolean ret = false;
		
		for (Edge edge : curOriginalNode.getOutgoings()) {
			Node nextNode = edge.getTarget();
			System.err.print("\n<" + getNodeName(curOriginalNode) + "," + getNodeName(nextNode) + ">\n");
			if( visitedNum.get(edge) >= visitLimit ) 
			{
				System.err.print("\nStopped!!!: <" + getNodeName(curOriginalNode) + "," + getNodeName(nextNode) + ">\n");
				ret = ret || true;
				continue;
			}
			visitedNum.put(edge, visitedNum.get(edge) + 1);
			ret = traverse(chor, nextNode, newNode, curVH, entireVH, visitLimit) || ret;
		}
		
		return ret;
	}
}
