package kr.ac.kaist.se.interactionmodel.idl.diagram.features.etc;

import kr.ac.kaist.se.interaction.idl.Initial;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.ColorConstants;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

public class InitialAddFeature extends AbstractAddFeature {
	public InitialAddFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {

		if(context.getNewObject() instanceof Initial )
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
		Initial addedInitial = (Initial)context.getNewObject();
		Diagram targetDiagram = (Diagram)context.getTargetContainer();

		// CONTAINER SHAPE WITH ROUNDED RECTANGLE
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape =
			peCreateService.createContainerShape(targetDiagram, true);
		// check whether the context has a size (e.g. from a create feature)
		// otherwise define a default size for the shape

		int x = context.getX();
		int y = context.getY();
		
		// define a default size for the shape
		IGaService gaService = Graphiti.getGaService();
		
		
		{
			Ellipse ellipse =
				gaService.createEllipse(containerShape);

			ellipse.setForeground(manageColor(ColorConstants.INTERACTION_FOREGROUND));
			ellipse.setBackground(manageColor(ColorConstants.INTERACTION_FOREGROUND));
			ellipse.setLineVisible(false);
			gaService.setLocationAndSize(ellipse, context.getX(), context.getY(), 28, 28);
			// if added Class has no resource we add it to the resource 
			// of the diagram
			// in a real scenario the business model would have its own resource
			if (addedInitial.eResource() == null) {
				getDiagram().eResource().getContents().add(addedInitial);
			}
			// create link and wire it
			link(containerShape, addedInitial);
		}
				// add a chopbox anchor to the shape
		peCreateService.createChopboxAnchor(containerShape);
		layoutPictogramElement(containerShape);


		return containerShape;
	}


}
