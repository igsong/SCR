package kr.ac.kaist.se.interactionmodel.impliedbehavior.eventrelation;

import org.jgrapht.EdgeFactory;

public class OrderedPairFactory implements
		EdgeFactory<Event, OrderedPair> {

	@Override
	public OrderedPair createEdge(Event from, Event to) {
		return new OrderedPair(from, to);
	}

}
