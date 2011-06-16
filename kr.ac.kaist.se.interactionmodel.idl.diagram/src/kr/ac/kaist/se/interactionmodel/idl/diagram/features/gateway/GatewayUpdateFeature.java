package kr.ac.kaist.se.interactionmodel.idl.diagram.features.gateway;

import java.util.List;

import kr.ac.kaist.se.interaction.idl.Gateway;
import kr.ac.kaist.se.interaction.idl.GatewayType;
import kr.ac.kaist.se.interaction.idl.Join;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.ColorConstants;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.PropertyUtil;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.util.IColorConstant;

public class GatewayUpdateFeature extends AbstractUpdateFeature {

	public GatewayUpdateFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		Object bo = 
			this.getBusinessObjectForPictogramElement(context.getPictogramElement());
		
		return bo instanceof Gateway;
	}

	@Override
	public IReason updateNeeded(IUpdateContext context) {
		Gateway bo = 
			(Gateway)this.getBusinessObjectForPictogramElement(context.getPictogramElement());
		if( !(bo.getType().equals(PropertyUtil.getGatewayType(context.getPictogramElement()))) )
		{
			return Reason.createTrueReason();
		}
		return Reason.createFalseReason();
	}

	@Override
	public boolean update(IUpdateContext context) {
		
		Gateway bo =(Gateway)this.getBusinessObjectForPictogramElement(context.getPictogramElement());
		
		IColorConstant df = GatewayConstants.branch_df;
		IColorConstant db = GatewayConstants.branch_db;
		IColorConstant pxf = GatewayConstants.branch_pxf;
		IColorConstant pxb = GatewayConstants.branch_pxb;
		IColorConstant of = GatewayConstants.branch_of;
		IColorConstant ob = GatewayConstants.branch_ob;
		
		if( bo instanceof Join )
		{
			df = GatewayConstants.join_df;
			db = GatewayConstants.join_db;
			pxf = GatewayConstants.join_pxf;
			pxb = GatewayConstants.join_pxb;
			of = GatewayConstants.join_of;
			ob = GatewayConstants.join_ob;
		}
		
		if( context.getPictogramElement() instanceof ContainerShape )
		{
			ContainerShape cs = (ContainerShape)context.getPictogramElement();
			for( Shape s : cs.getChildren() )
			{
				if( s.getGraphicsAlgorithm() instanceof Polygon )
				{
					Polygon p = (Polygon)s.getGraphicsAlgorithm();
					switch(bo.getType().getValue() )
					{
					case GatewayType.AND_VALUE:
						changePoints(p, GatewayConstants.templatePlus);
						p.setForeground(manageColor(pxf));
						p.setBackground(manageColor(pxb));
						p.setLineWidth(2);
						break;
					case GatewayType.XOR_VALUE:
						changePoints(p, GatewayConstants.templateX);
						p.setForeground(manageColor(pxf));
						p.setBackground(manageColor(pxb));
						p.setLineWidth(2);
						break;
					case GatewayType.IOR_VALUE:
						changePoints(p, GatewayConstants.templateO);
						p.setForeground(manageColor(of));
						p.setBackground(manageColor(ob));
						p.setLineWidth(3);
						break;
					}
					PropertyUtil.setGatewayType(cs, bo.getType());
					return true;
				}
			}
		}
		return false;
	}
	
	private static void changePoints(Polygon polygon, int[] points)
	{
		List<Point> p = polygon.getPoints();
		for( int i = 0; i < p.size(); i++ )
		{
			Point newPoint = Graphiti.getGaService().createPoint(points[i*2], points[i*2+1]);
			p.set(i, newPoint);
		}
	}
}
