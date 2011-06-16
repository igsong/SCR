package kr.ac.kaist.se.interactionmodel.impliedbehavior.eventrelation;


public class OrderedPair {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2660424209891819576L;
	
	private boolean original;
	private Event formerEvent;
	private Event latterEvent;
	
	public OrderedPair()
	{

		original = false;
	}
	
	public boolean isOriginal() {
		return original;
	}

	public void setOriginal(boolean original) {
		this.original = original;
	}

	public OrderedPair(Event former, Event latter)
	{
		setFormerEvent(former);
		setLatterEvent(latter);
	}
	
	public Event getFormerEvent()
	{
		return formerEvent;
	}
	
	public Event getLatterEvent()
	{
		return latterEvent;
	}
	
	public void setFormerEvent(Event former)
	{
		formerEvent = former;
	}
	
	public void setLatterEvent(Event latter)
	{
		latterEvent = latter;
	}
}
