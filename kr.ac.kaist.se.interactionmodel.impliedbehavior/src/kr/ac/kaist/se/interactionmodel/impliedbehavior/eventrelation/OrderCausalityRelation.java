package kr.ac.kaist.se.interactionmodel.impliedbehavior.eventrelation;

import java.util.HashSet;
import java.util.Set;

import org.jgrapht.graph.SimpleDirectedGraph;


public class OrderCausalityRelation {

	public OrderCausalityRelation()
	{
		originalGraph = new SimpleDirectedGraph<Event, OrderedPair>(new OrderedPairFactory());
		minimalGraph = new SimpleDirectedGraph<Event, OrderedPair>(new OrderedPairFactory());
		maximalGraph = new SimpleDirectedGraph<Event, OrderedPair>(new OrderedPairFactory());
	}
	
	private static final long serialVersionUID = -9055955288046487660L;
	
	private SimpleDirectedGraph<Event, OrderedPair> originalGraph;
	private SimpleDirectedGraph<Event, OrderedPair> minimalGraph;
	private SimpleDirectedGraph<Event, OrderedPair> maximalGraph;
	
	
	public void addEvent(Event e)
	{
		if( !originalGraph.containsVertex(e) )
		{
			originalGraph.addVertex(e);
			minimalGraph.addVertex(e);
			maximalGraph.addVertex(e);
		}
	}
	
	public Set<Event> getEventSet()
	{
		return originalGraph.vertexSet();
	}
	
	
	public void addRelation(Event former, Event latter)
	{
		originalGraph.addEdge(former, latter);
		maximalGraph.addEdge(former, latter);
		minimalGraph.addEdge(former, latter);
	}
	
	public void updateTransitive()
	{	
		for( Event event : maximalGraph.vertexSet() )
		{
			for( OrderedPair op1 : maximalGraph.incomingEdgesOf(event) )
			{
				for( OrderedPair op2 : maximalGraph.outgoingEdgesOf(event) )
				{
					Event e1 = op1.getFormerEvent();
					Event e2 = op2.getLatterEvent();
					if( !maximalGraph.containsEdge(e1, e2) )
					{
						maximalGraph.addEdge(e1, e2);
					}
					else if( minimalGraph.containsEdge(e1, e2) )
					{
						minimalGraph.removeEdge(e1, e2);
					}
				}
			}
		}
	}
	
	public Set<OrderedPair> getDirectRelationSet()
	{
		return originalGraph.edgeSet();
	}
	
	public Set<OrderedPair> getRelationSet()
	{
		return maximalGraph.edgeSet();
	}
	
	public Set<OrderedPair> getMinimalRelationSet()
	{
		return minimalGraph.edgeSet();
	}
	
	public Set<OrderedPair> getRelationSetTo(Event latter)
	{
		return maximalGraph.incomingEdgesOf(latter);
	}
	
	public Set<OrderedPair> getRelationSetFrom(Event from)
	{
		return maximalGraph.outgoingEdgesOf(from);
	}
	
	public boolean hasRelation(Event former, Event latter)
	{
		return maximalGraph.containsEdge(former, latter);
	}
	
	public boolean hasDirectRelation(Event former, Event latter)
	{
		return originalGraph.containsEdge(former, latter);
	}
	
	public boolean hasMinimalRelation(Event former, Event latter)
	{
		return minimalGraph.containsEdge(former, latter);
	}
	
	public Set<OrderedPair> minimalMinus(OrderCausalityRelation substractor)
	{	
		Set<OrderedPair> ret = new HashSet<OrderedPair>();
		
		for(OrderedPair op : getMinimalRelationSet() )
		{
			if( !substractor.hasRelation(op.getFormerEvent(), op.getLatterEvent()) )
			{
				ret.add(new OrderedPair(op.getFormerEvent(), op.getLatterEvent()));
			}
		}
		
		return ret;
	} 
}
