package kr.ac.kaist.se.interactionmodel.idl.diagram.features.interaction;

import kr.ac.kaist.se.interaction.idl.Interaction;
import kr.ac.kaist.se.interaction.idl.Participant;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.PropertyUtil;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;


public class InteractionUpdateFeature extends AbstractUpdateFeature {

	public InteractionUpdateFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		Object bo = 
			this.getBusinessObjectForPictogramElement(context.getPictogramElement());
		
		return bo instanceof Interaction;
	}

	@Override
	public IReason updateNeeded(IUpdateContext context) {
		String oldInteractionName = null;
		String oldSenderName = null;
		String oldReceiverName = null;
		
		Interaction interaction = 
			(Interaction)this.getBusinessObjectForPictogramElement(context.getPictogramElement());
		Participant sender = interaction.getSender();
		Participant receiver = interaction.getReceiver().isEmpty() ? null : interaction.getReceiver().get(0);
		
		String interactionName = interaction.getName();
		String senderName = sender != null ? sender.getName() : null;
		String receiverName = receiver != null ? receiver.getName() : null;
		
		PictogramElement pictogramElement = context.getPictogramElement();
		if (pictogramElement instanceof ContainerShape) {
			ContainerShape cs = (ContainerShape) pictogramElement;
			for (Shape shape : cs.getChildren()) {
				if (shape.getGraphicsAlgorithm() instanceof Text) {
					Text text = (Text) shape.getGraphicsAlgorithm();
					if( PropertyUtil.isInteractionNameShape(shape) )
					{
						oldInteractionName = text.getValue();
					}
					else if( PropertyUtil.isSenderShape(shape) )
					{
						oldSenderName = text.getValue();
					}
					else if( PropertyUtil.isReceiverShape(shape) )
					{
						oldReceiverName = text.getValue();
					}
				}
			}
		}

		// update needed, if names are different
		boolean updateNameNeeded =
			((oldInteractionName == null && interactionName != null) ||
					(oldInteractionName != null && !oldInteractionName.equals(interactionName))) ||
			((oldSenderName == null && senderName != null) ||
					(oldSenderName != null && !oldSenderName.equals(senderName))) ||
			((oldReceiverName == null && receiverName != null) ||
					(oldReceiverName != null && !oldReceiverName.equals(receiverName)));

		if (updateNameNeeded) {
			return Reason.createTrueReason("Name is out of date");
		} else {
			return Reason.createFalseReason();
		}
	}

	@Override
	public boolean update(IUpdateContext context) {
		Interaction interaction = 
			(Interaction)this.getBusinessObjectForPictogramElement(context.getPictogramElement());
		Participant sender = interaction.getSender();
		Participant receiver = interaction.getReceiver().isEmpty() ? null : interaction.getReceiver().get(0);
		
		String interactionName = interaction.getName();
		String senderName = sender != null ? sender.getName() : null;
		String receiverName = receiver != null ? receiver.getName() : null;
		
		PictogramElement pictogramElement = context.getPictogramElement();
		boolean isInteractionName = false;
		boolean isSenderName = false;
		boolean isReceiverName = false;
		
		if (pictogramElement instanceof ContainerShape) {
			ContainerShape cs = (ContainerShape) pictogramElement;
			for (Shape shape : cs.getChildren()) {
				if (shape.getGraphicsAlgorithm() instanceof Text) {
					Text text = (Text) shape.getGraphicsAlgorithm();
					if( PropertyUtil.isInteractionNameShape(shape) )
					{
						text.setValue(interactionName);
						isInteractionName = true;
					}
					else if( PropertyUtil.isSenderShape(shape) )
					{
						text.setValue(senderName);
						isSenderName = true;
					}
					else if( PropertyUtil.isReceiverShape(shape) )
					{
						text.setValue(receiverName);
						isReceiverName = true;
					}
				}
				
				if( isInteractionName && isSenderName && isReceiverName )
				{
					return true;
				}
			}
		}
 
        return false;
	}

}
