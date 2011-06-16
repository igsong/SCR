package kr.ac.kaist.se.interactionmodel.idl.diagram.features.etc;

import kr.ac.kaist.se.interaction.idl.Final;
import kr.ac.kaist.se.interaction.idl.GatewayType;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.ColorConstants;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.gateway.GatewayConstants;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

public class FinalAddFeature extends AbstractAddFeature {
	public FinalAddFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {

		if(context.getNewObject() instanceof Final )
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
		Final addedFinal = (Final)context.getNewObject();
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
			ellipse.setBackground(manageColor(ColorConstants.INTERACTION_BACKGROUND));
			ellipse.setLineWidth(2);
			gaService.setLocationAndSize(ellipse, context.getX(), context.getY(), 36, 36);
			// if added Class has no resource we add it to the resource 
			// of the diagram
			// in a real scenario the business model would have its own resource
			if (addedFinal.eResource() == null) {
				getDiagram().eResource().getContents().add(addedFinal);
			}
			// create link and wire it
			link(containerShape, addedFinal);
		}
		{
			Shape shape = peCreateService.createShape(containerShape, false);
			Ellipse innerEllipse = gaService.createEllipse(shape);
			innerEllipse.setForeground(manageColor(ColorConstants.INTERACTION_FOREGROUND));
			innerEllipse.setBackground(manageColor(ColorConstants.INTERACTION_FOREGROUND));
			innerEllipse.setLineVisible(false);
			gaService.setLocationAndSize(innerEllipse, 5, 5, 25, 25);
		}
				// add a chopbox anchor to the shape
		peCreateService.createChopboxAnchor(containerShape);
		layoutPictogramElement(containerShape);


		return containerShape;
	}


}
