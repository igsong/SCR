package kr.ac.kaist.se.interactionmodel.idl.diagram.features.interaction;

import java.util.Iterator;

import kr.ac.kaist.se.interaction.idl.Interaction;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.PropertyUtil;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

public class InteractionLayoutFeature extends AbstractLayoutFeature {

	public InteractionLayoutFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

    private static final int MIN_HEIGHT = 60;
    private static final int MIN_WIDTH = 100;

 

    public boolean canLayout(ILayoutContext context) {
       PictogramElement pe = context.getPictogramElement();
       if (!(pe instanceof ContainerShape))
           return false;
       EList<EObject> businessObjects = pe.getLink().getBusinessObjects();
       return businessObjects.size() == 1 
              && businessObjects.get(0) instanceof Interaction;
    }


    public boolean layout(ILayoutContext context) {
        boolean anythingChanged = false;
        ContainerShape containerShape =
            (ContainerShape) context.getPictogramElement();
        GraphicsAlgorithm containerGa = containerShape.getGraphicsAlgorithm();

        if (containerGa.getHeight() < MIN_HEIGHT) {
            containerGa.setHeight(MIN_HEIGHT);
            anythingChanged = true;
        }

        if (containerGa.getWidth() < MIN_WIDTH) {
            containerGa.setWidth(MIN_WIDTH);
            anythingChanged = true;
        }

        int width = containerGa.getWidth();
        int height = containerGa.getHeight();

        int nameHeight = height / 3;
        int nameHeightHalf = nameHeight / 2;
        int y1 = height / 2 - nameHeightHalf;
        int y2 = height / 2 + nameHeightHalf;

		for (Shape shape : containerShape.getChildren()) {
			if( PropertyUtil.isInteractionNameShape(shape) )
			{
				Graphiti.getGaService().setLocationAndSize(shape.getGraphicsAlgorithm(), 0, y1, width, nameHeight);
			}
			else if( PropertyUtil.isSenderShape(shape) )
			{
				Graphiti.getGaService().setLocationAndSize(shape.getGraphicsAlgorithm(), 0, 0, width, nameHeight);
			}
			else if( PropertyUtil.isReceiverShape(shape) )
			{
				Graphiti.getGaService().setLocationAndSize(shape.getGraphicsAlgorithm(), 0, y2, width, nameHeight);
			}
			else if( PropertyUtil.isLine1Shape(shape) )
			{
				Polyline polyline = (Polyline) shape.getGraphicsAlgorithm();
				Point firstPoint = polyline.getPoints().get(0);
				Point secondPoint = polyline.getPoints().get(1);
				Point newFirstPoint = Graphiti.getGaService().createPoint(0, y1);
				Point newSecondPoint = Graphiti.getGaService().createPoint(width, y1); 
				polyline.getPoints().set(0, newFirstPoint);
				polyline.getPoints().set(1, newSecondPoint);
			}
			else if( PropertyUtil.isLine2Shape(shape) )
			{
				Polyline polyline = (Polyline) shape.getGraphicsAlgorithm();
				Point firstPoint = polyline.getPoints().get(0);
				Point secondPoint = polyline.getPoints().get(1);
				Point newFirstPoint = Graphiti.getGaService().createPoint(0, y2);
				Point newSecondPoint = Graphiti.getGaService().createPoint(width, y2); 
				polyline.getPoints().set(0, newFirstPoint);
				polyline.getPoints().set(1, newSecondPoint);			
			}
			else if( PropertyUtil.isReceiverBackgroundShape(shape) )
			{
				Graphiti.getGaService().setLocationAndSize(shape.getGraphicsAlgorithm(), 1, y2, width - 2, nameHeight - 1);
			}
		}
        return true;
    }
}
