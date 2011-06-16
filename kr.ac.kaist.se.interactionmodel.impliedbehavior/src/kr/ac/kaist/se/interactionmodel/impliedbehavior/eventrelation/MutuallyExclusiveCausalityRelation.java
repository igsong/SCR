package kr.ac.kaist.se.interactionmodel.impliedbehavior.eventrelation;

import org.jgrapht.graph.SimpleGraph;

public class MutuallyExclusiveCausalityRelation {

	private OrderCausalityRelation seq; 
	private SimpleGraph<Event, OrderedPair> originalGraph;
	private SimpleGraph<Event, OrderedPair> minimalGraph;
	private SimpleGraph<Event, OrderedPair> maximalGraph;
	
	public MutuallyExclusiveCausalityRelation(OrderCausalityRelation seq)
	{
		this.seq = seq;
		originalGraph = new SimpleGraph<Event, OrderedPair>(new OrderedPairFactory());
		minimalGraph = new SimpleGraph<Event, OrderedPair>(new OrderedPairFactory());
		maximalGraph = new SimpleGraph<Event, OrderedPair>(new OrderedPairFactory());
		
		for( Event evt : seq.getEventSet() )
		{
			originalGraph.addVertex(evt);
			minimalGraph.addVertex(evt);
			maximalGraph.addVertex(evt);
		}
	}
	
	public void addRelation(Event e1, Event e2) {
		originalGraph.addEdge(e1, e2);

		if( seq.hasRelation(e1, e2) )
		{
			if( hasRelation(e1, e2) )
			{
				
			}
			else
			{
				
			}
		}
		else
		{
			
			if( hasRelation(e1, e2) )
			{
				
			}
			else
			{
				OrderedPair minimal = new OrderedPair(e1, e2);
				addMaximalGraph(e1, e2, minimal);
				minimalGraph.addEdge(minimal.getFormerEvent(), minimal.getLatterEvent());
			}
		}
	}
	
	private void addMaximalGraph(Event e1, Event e2, OrderedPair minimal)
	{
		maximalGraph.addEdge(e1, e2);
		if( seq.hasRelation(e1, minimal.getFormerEvent()) || e1 == minimal.getFormerEvent() )
		{
			if( seq.hasRelation(e2, minimal.getLatterEvent()) || e2 == minimal.getLatterEvent() )
			{
				minimal.setFormerEvent(e1);
				minimal.setLatterEvent(e2);
			}
		}
		else if( seq.hasRelation(e1, minimal.getLatterEvent()) || e1 == minimal.getLatterEvent())
		{
			if( seq.hasRelation(e2, minimal.getFormerEvent()) || e2 == minimal.getFormerEvent() )
			{
				minimal.setFormerEvent(e1);
				minimal.setLatterEvent(e2);
			}
			
		}		

		for( OrderedPair op : seq.getRelationSetFrom(e1) )
		{
			if( (!seq.hasRelation(e1, op.getLatterEvent()))
					&& (!seq.hasRelation(op.getLatterEvent(), e1) )
					&& (!maximalGraph.containsEdge(e1, op.getLatterEvent())) )
			{
				addMaximalGraph(e1, op.getLatterEvent(), minimal);
			}
		}
		
		for( OrderedPair op : seq.getRelationSetFrom(e2) )
		{
			if( (!seq.hasRelation(e2, op.getLatterEvent()))
					&& (!seq.hasRelation(op.getLatterEvent(), e2) )
					&& (!maximalGraph.containsEdge(e2, op.getLatterEvent())) )
			{
				addMaximalGraph(e2, op.getLatterEvent(), minimal);
			}
		}
		
		for( OrderedPair op : seq.getRelationSetTo(e1) )
		{
			if( (!seq.hasRelation(e1, op.getFormerEvent()))
					&& (!seq.hasRelation(op.getFormerEvent(), e1) )
					&& (!maximalGraph.containsEdge(e1, op.getFormerEvent())) )
			{
				addMaximalGraph(e1, op.getFormerEvent(), minimal);
			}
		}
		
		for( OrderedPair op : seq.getRelationSetTo(e2) )
		{
			if( (!seq.hasRelation(e2, op.getFormerEvent()))
					&& (!seq.hasRelation(op.getFormerEvent(), e2) )
					&& (!maximalGraph.containsEdge(e2, op.getFormerEvent())) )
			{
				addMaximalGraph(e2, op.getFormerEvent(), minimal);
			}
		}
	}

	public boolean hasRelation(Event e1, Event e2) {
		return maximalGraph.containsEdge(e1, e2);
	}

	public boolean hasDirectRelation(Event e1, Event e2) {
		return originalGraph.containsEdge(e1, e2);
	}

	public boolean hasMinimalRelation(Event e1, Event e2) {
		return minimalGraph.containsEdge(e1, e2);
	}
}
