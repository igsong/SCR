package kr.ac.kaist.se.interactionmodel.idl.diagram;

import kr.ac.kaist.se.interaction.idl.Branch;
import kr.ac.kaist.se.interaction.idl.Final;
import kr.ac.kaist.se.interaction.idl.Gateway;
import kr.ac.kaist.se.interaction.idl.Initial;
import kr.ac.kaist.se.interaction.idl.Interaction;
import kr.ac.kaist.se.interaction.idl.Join;
import kr.ac.kaist.se.interaction.idl.SequenceFlow;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.DiagramLayoutFeature;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.etc.FinalAddFeature;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.etc.FinalCreateFeature;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.etc.InitialAddFeature;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.etc.InitialCreateFeature;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.etc.ProhibitResizeFeature;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.flow.FlowAddFeature;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.flow.FlowCreateFeature;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.gateway.ANDChangeFeature;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.gateway.BranchCreateFeature;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.gateway.GatewayAddFeature;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.gateway.GatewayUpdateFeature;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.gateway.IORChangeFeature;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.gateway.JoinCreateFeature;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.gateway.XORChangeFeature;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.interaction.InteractionAddFeature;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.interaction.InteractionCreateFeature;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.interaction.InteractionLayoutFeature;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.interaction.InteractionModifyFeature;
import kr.ac.kaist.se.interactionmodel.idl.diagram.features.interaction.InteractionUpdateFeature;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

public class BPMNChoreographyFeatureProvider extends DefaultFeatureProvider {

	public BPMNChoreographyFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}
	
    @Override
    public IAddFeature getAddFeature(IAddContext context) {
        // is object for add request a EClass?
        if (context.getNewObject() instanceof Interaction) {
            return new InteractionAddFeature(this);
        } else if (context.getNewObject() instanceof SequenceFlow) {
            return new FlowAddFeature(this);
        } else if (context.getNewObject() instanceof Initial) {
            return new InitialAddFeature(this);
        } else if (context.getNewObject() instanceof Final) {
            return new FinalAddFeature(this);
        } else if (context.getNewObject() instanceof Gateway) {
            return new GatewayAddFeature(this);
        }

        return super.getAddFeature(context);
    }
    
    @Override
    public ICreateFeature[] getCreateFeatures() {
        return new ICreateFeature[] { 
        		new InteractionCreateFeature(this), 
        		new BranchCreateFeature(this), 
        		new JoinCreateFeature(this), 
        		new InitialCreateFeature(this),
        		new FinalCreateFeature(this)};
    }

	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		if (pictogramElement instanceof ContainerShape) {
			Object bo = getBusinessObjectForPictogramElement(pictogramElement);
			if (bo instanceof Interaction) {
				return new InteractionUpdateFeature(this);
			}
			else if( bo instanceof Gateway )
			{
				return new GatewayUpdateFeature(this);
			}
		}
		return super.getUpdateFeature(context);
	}	 

    @Override
    public ILayoutFeature getLayoutFeature(ILayoutContext context) {
        PictogramElement pictogramElement = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo instanceof Interaction) {
            return new InteractionLayoutFeature(this);
        }
        return super.getLayoutFeature(context);
    }

 
    @Override
    public ICustomFeature[] getCustomFeatures(ICustomContext context) {
        return new ICustomFeature[] { 
        		new InteractionModifyFeature(this),
        		new XORChangeFeature(this),
        		new ANDChangeFeature(this),
        		new IORChangeFeature(this),
        		new DiagramLayoutFeature(this)};
    }

    @Override
    public ICreateConnectionFeature[] getCreateConnectionFeatures() {
    	return new ICreateConnectionFeature[] { 
    			new FlowCreateFeature (this) };
    }
    
    @Override
    public IFeature[] getDragAndDropFeatures(IPictogramElementContext context) {
        return getCreateConnectionFeatures();
    }

	@Override
	public IResizeShapeFeature getResizeShapeFeature(IResizeShapeContext context) {
        PictogramElement pictogramElement = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo instanceof Branch || bo instanceof Join || bo instanceof Initial || bo instanceof Final ) {
            return new ProhibitResizeFeature(this);
        }
		return super.getResizeShapeFeature(context);
	}
}
