package kr.ac.kaist.se.interactionmodel.idl.diagram.features.interaction;

import kr.ac.kaist.se.interaction.idl.Interaction;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.ColorConstants;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.PropertyUtil;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

public class InteractionAddFeature extends AbstractAddShapeFeature {
	public InteractionAddFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {

		if(context.getNewObject() instanceof Interaction )
		{
			if( context.getTargetContainer() instanceof Diagram )
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		Interaction addedInteraction = (Interaction)context.getNewObject();
		Diagram targetDiagram = (Diagram)context.getTargetContainer();

		// CONTAINER SHAPE WITH ROUNDED RECTANGLE
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape =
			peCreateService.createContainerShape(targetDiagram, true);
		// check whether the context has a size (e.g. from a create feature)
		// otherwise define a default size for the shape
		int width = context.getWidth() <= 100 ? 100 : context.getWidth();
		int height = context.getHeight() <= 60 ? 60 : context.getHeight();

		// define a default size for the shape
		IGaService gaService = Graphiti.getGaService();
		RoundedRectangle base = null;
		{
			// create and set graphics algorithm
			RoundedRectangle roundedRectangle =
				gaService.createRoundedRectangle(containerShape, 5, 5);
			base = roundedRectangle;
			roundedRectangle.setForeground(manageColor(ColorConstants.INTERACTION_FOREGROUND));
			roundedRectangle.setBackground(manageColor(ColorConstants.INTERACTION_BACKGROUND));
			roundedRectangle.setLineWidth(2);
			gaService.setLocationAndSize(roundedRectangle,
					context.getX(), context.getY(), width, height);

			// if added Class has no resource we add it to the resource 
			// of the diagram
			// in a real scenario the business model would have its own resource
			if (addedInteraction.eResource() == null) {
				getDiagram().eResource().getContents().add(addedInteraction);
			}
			// create link and wire it
			link(containerShape, addedInteraction);
		}

		int nameHeight = height / 3;
		int nameHeightHalf = nameHeight / 2;
		int y1 = height / 2 - nameHeightHalf;
		int y2 = height / 2 + nameHeightHalf;

		// SHAPE WITH RECEIVER BACKGROUND
		{
			// create shape for line
			Shape shape = peCreateService.createShape(containerShape, false);

			// create and set graphics algorithm
			RoundedRectangle roundedRectangle =
				gaService.createRoundedRectangle(shape, 5, 5);
			roundedRectangle.setForeground(manageColor(ColorConstants.RECEIVER_PART_FOREGROUND));
			roundedRectangle.setBackground(manageColor(ColorConstants.RECEIVER_PART_BACKGROUND));
			roundedRectangle.setLineWidth(0);
			gaService.setLocationAndSize(roundedRectangle,
					1, y2, width - 2, nameHeight - 1);
			PropertyUtil.setReceiverBackgroundShape(shape);
		}

		// SHAPE WITH LINE1
		{
			// create shape for line
			Shape shape = peCreateService.createShape(containerShape, false);

			// create and set graphics algorithm
			Polyline polyline =
				gaService.createPolyline(shape, new int[] { 0, y1, width, y1 });
			polyline.setForeground(manageColor(ColorConstants.INTERACTION_FOREGROUND));
			polyline.setLineWidth(2);
			PropertyUtil.setLine1Shape(shape);
		}


		// SHAPE WITH LINE2
		{
			// create shape for line
			Shape shape = peCreateService.createShape(containerShape, false);

			// create and set graphics algorithm
			Polyline polyline =
				gaService.createPolyline(shape, new int[] { 0, y2, width, y2 });
			polyline.setForeground(manageColor(ColorConstants.INTERACTION_FOREGROUND));
			polyline.setLineWidth(2);
			PropertyUtil.setLine2Shape(shape);
		}



		// SHAPE WITH TEXT
		{
			// create shape for text
			Shape shape = peCreateService.createShape(containerShape, false);

			// create and set text graphics algorithm
			Text text = gaService.createDefaultText(shape, addedInteraction.getName());
			text.setForeground(manageColor(ColorConstants.TEXT_FOREGROUND));
			text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
			text.getFont().setBold(true);
			text.getFont().setSize(12);
			PropertyUtil.setInteractionNameShape(shape);

			gaService.setLocationAndSize(text, 0, y1, width, nameHeight);

			// create link and wire it
			link(shape, addedInteraction);
		}

		// SHAPE WITH SENDER
		{
			// create shape for text
			Shape shape = peCreateService.createShape(containerShape, false);

			// create and set text graphics algorithm
			String senderName = "Undefined...";
			if(addedInteraction.getSender() != null )
			{
				senderName = addedInteraction.getSender().getName();
			}
			Text text = gaService.createDefaultText(shape, senderName);
			text.setForeground(manageColor(ColorConstants.TEXT_FOREGROUND));
			text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
			text.getFont().setBold(true);
			text.getFont().setSize(12);
			PropertyUtil.setSenderShape(shape);


			gaService.setLocationAndSize(text, 0, 0, width, nameHeight);

			// create link and wire it
			link(shape, addedInteraction);
		}

		// SHAPE WITH RECIEVER
		{
			// create shape for text
			Shape shape = peCreateService.createShape(containerShape, false);

			// create and set text graphics algorithm
			String receiverName = "Undefined...";
			if( !addedInteraction.getReceiver().isEmpty() )
			{
				receiverName = addedInteraction.getReceiver().get(0).getName();
			}
			Text text = gaService.createDefaultText(shape, receiverName);
			text.setForeground(manageColor(ColorConstants.TEXT_FOREGROUND));
			text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
			text.getFont().setBold(true);
			text.getFont().setSize(12);
			PropertyUtil.setReceiverShape(shape);

			gaService.setLocationAndSize(text, 0, y2, width, nameHeight);

			// create link and wire it
			link(shape, addedInteraction);
		}
		// add a chopbox anchor to the shape
		peCreateService.createChopboxAnchor(containerShape);

		// create an additional box relative anchor at middle-right
		final BoxRelativeAnchor boxAnchor = 
			peCreateService.createBoxRelativeAnchor(containerShape);

		boxAnchor.setRelativeWidth(1.0);
		boxAnchor.setRelativeHeight(0.5);

		// anchor references visible rectangle instead of invisible rectangle

		boxAnchor.setReferencedGraphicsAlgorithm(base);

		// assign a graphics algorithm for the box relative anchor
		Rectangle rectangle = gaService.createRectangle(boxAnchor);
		rectangle.setFilled(true);

		// anchor is located on the right border of the visible rectangle
		// and touches the border of the invisible rectangle

		int w = 6;
		gaService.setLocationAndSize(rectangle, -2 * w, -w, 2 * w, 2 * w);
		rectangle.setForeground(manageColor(ColorConstants.INTERACTION_FOREGROUND));
		rectangle.setBackground(manageColor(ColorConstants.INTERACTION_BACKGROUND));

		layoutPictogramElement(containerShape);


		return containerShape;
	}



}
