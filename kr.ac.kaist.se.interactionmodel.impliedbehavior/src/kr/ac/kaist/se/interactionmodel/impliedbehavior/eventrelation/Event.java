package kr.ac.kaist.se.interactionmodel.impliedbehavior.eventrelation;

import kr.ac.kaist.se.interaction.idl.Interaction;
import kr.ac.kaist.se.interaction.idl.Participant;

public class Event {
	private Interaction node;
	private Participant participant;
	private String message;
	private int type;
	
	public static final int SEND = 0;
	public static final int RECV = 1;
	
	private Event()
	{
	}
	
	public static Event createInstance(Interaction node, int type) throws IllegalArgumentException
	{	
		Event event = new Event();
		event.type = type;
		event.node = node;
		event.message = node.getName();
		
		if( type == SEND )
		{
			event.participant = node.getSender();
		}
		else if( type == RECV )
		{
			event.participant = node.getReceiver().get(0);
		}
		else
		{
			throw new IllegalArgumentException("Type argument should be 0(for send) or 1(for recv), but "+ type);
		}	
		
		return event;
	}

	public Interaction getNode() {
		return node;
	}

	public Participant getParticipant() {
		return participant;
	}

	public String getMessage() {
		return message;
	}

	public int getType() {
		return type;
	}
}
