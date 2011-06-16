package kr.ac.kaist.se.interactionmodel.idl.diagram.features.flow;

import kr.ac.kaist.se.interaction.idl.SequenceFlow;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.ManhattanConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.PictogramsFactory;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;

public class FlowAddFeature extends AbstractAddFeature {

	public FlowAddFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}
	
	public ManhattanConnection createManhattanConnection(Diagram diagram) {
		ManhattanConnection ret = PictogramsFactory.eINSTANCE.createManhattanConnection();
		ret.setVisible(true);
		ret.setActive(true);
		ret.setParent(diagram);
		return ret;
	}

	public PictogramElement add(IAddContext context) {
		IAddConnectionContext addConContext = (IAddConnectionContext) context;
		SequenceFlow addedEReference = (SequenceFlow) context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();


		Connection connection = peCreateService.createFreeFormConnection(getDiagram());
		
//		Connection connection = createManhattanConnection(getDiagram());
		
		connection.setStart(addConContext.getSourceAnchor());
		connection.setEnd(addConContext.getTargetAnchor());

		IGaService gaService = Graphiti.getGaService();
		Polyline polyline = gaService.createPolyline(connection);
		polyline.setLineWidth(2);
		polyline.setForeground(manageColor(IColorConstant.BLACK));

		link(connection, addedEReference);

		
		// add static graphical decorator (composition and navigable)

		ConnectionDecorator cd;

		cd = peCreateService
		.createConnectionDecorator(connection, false, 1.0, true);

		createArrow(cd);


		return connection;
	}

	public boolean canAdd(IAddContext context) {
		if (context instanceof IAddConnectionContext
				&& context.getNewObject() instanceof SequenceFlow) {
			return true;
		}
		return false;
	}
	
	private Polyline createArrow(GraphicsAlgorithmContainer gaContainer) {
		IGaService gaService = Graphiti.getGaService();
		Polygon polyline =
			gaService.createPolygon(gaContainer, new int[] { -13, 9, 0, 0, -13,
					-9 });
		polyline.setForeground(manageColor(IColorConstant.BLACK));
		polyline.setBackground(manageColor(IColorConstant.BLACK));
		polyline.setLineWidth(2);
		return polyline;
	}
}