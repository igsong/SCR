package kr.ac.kaist.se.interactionmodel.idl.diagram.features.gateway;

import kr.ac.kaist.se.interaction.idl.Gateway;
import kr.ac.kaist.se.interaction.idl.GatewayType;
import kr.ac.kaist.se.interaction.idl.Join;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.PropertyUtil;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;

public class GatewayAddFeature extends AbstractAddFeature {
	public GatewayAddFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {

		if(context.getNewObject() instanceof Gateway )
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
		Gateway addedGateway = (Gateway)context.getNewObject();
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
		IColorConstant df = GatewayConstants.branch_df;
		IColorConstant db = GatewayConstants.branch_db;
		IColorConstant pxf = GatewayConstants.branch_pxf;
		IColorConstant pxb = GatewayConstants.branch_pxb;
		IColorConstant of = GatewayConstants.branch_of;
		IColorConstant ob = GatewayConstants.branch_ob;
		
		if( addedGateway instanceof Join )
		{
			df = GatewayConstants.join_df;
			db = GatewayConstants.join_db;
			pxf = GatewayConstants.join_pxf;
			pxb = GatewayConstants.join_pxb;
			of = GatewayConstants.join_of;
			ob = GatewayConstants.join_ob;
		}
		
		
		{
			Polygon polygon =
				gaService.createPolygon(containerShape, GatewayConstants.templateDiamond);

			polygon.setForeground(manageColor(df));
			polygon.setBackground(manageColor(db));
			polygon.setLineWidth(2);
			gaService.setLocation(polygon, context.getX(), context.getY());
			// if added Class has no resource we add it to the resource 
			// of the diagram
			// in a real scenario the business model would have its own resource
			if (addedGateway.eResource() == null) {
				getDiagram().eResource().getContents().add(addedGateway);
			}
			// create link and wire it
			link(containerShape, addedGateway);
		}
		
		Shape shape = peCreateService.createShape(containerShape, false);
		Polygon polygon = null;
		if( addedGateway.getType().equals(GatewayType.XOR) )
		{
			polygon = gaService.createPolygon(shape, GatewayConstants.templateX);
			polygon.setForeground(manageColor(pxf));
			polygon.setBackground(manageColor(pxb));
			polygon.setLineWidth(2);
		}
		else if(addedGateway.getType().equals(GatewayType.AND) )
		{
			polygon = gaService.createPolygon(shape, GatewayConstants.templatePlus);
			polygon.setForeground(manageColor(pxf));
			polygon.setBackground(manageColor(pxb));
			polygon.setLineWidth(2);
		}
		else if(addedGateway.getType().equals(GatewayType.IOR) )
		{
			polygon = gaService.createPolygon(shape, GatewayConstants.templateO);
			polygon.setForeground(manageColor(of));
			polygon.setBackground(manageColor(ob));
			polygon.setLineWidth(5);
		}
		else
		{
			return null;
		}
		
		PropertyUtil.setGatewayType(containerShape, addedGateway.getType());

		// add a chopbox anchor to the shape
		peCreateService.createChopboxAnchor(containerShape);
		layoutPictogramElement(containerShape);


		return containerShape;
	}


}
