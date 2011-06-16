package kr.ac.kaist.se.interactionmodel.idl.diagram.features.gateway;

import kr.ac.kaist.se.interaction.idl.Gateway;
import kr.ac.kaist.se.interaction.idl.GatewayType;
import kr.ac.kaist.se.interaction.idl.Interaction;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public abstract class GatewayTypeChangeFeature extends AbstractCustomFeature {

	public GatewayTypeChangeFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}
	
	protected abstract GatewayType getType();

	@Override
	public boolean isAvailable(IContext context) {
		boolean ret = false;
		if( context instanceof ICustomContext )
		{
			PictogramElement[] pes = ((ICustomContext) context).getPictogramElements();
			if (pes != null && pes.length == 1) {
				Object bo = getBusinessObjectForPictogramElement(pes[0]);
				if (bo instanceof Gateway) {
					ret = true;
				}
			}
		}
		return ret;
	}
	
	@Override
	public String getName() {
		return getType().getName();
	}

	@Override
	public String getDescription() {
		return "Change to " + getName();
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Gateway) {
				ret = !((Gateway)bo).getType().equals(getType());
			}
		}
		return ret;
	}
	
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Gateway) {
				Gateway gateway = (Gateway)bo;
				gateway.setType(getType());
			}
		}
	}
}
