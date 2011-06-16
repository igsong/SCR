package kr.ac.kaist.se.interactionmodel.idl.diagram.features.gateway;

import kr.ac.kaist.se.interaction.idl.GatewayType;

import org.eclipse.graphiti.features.IFeatureProvider;

public class ANDChangeFeature extends GatewayTypeChangeFeature {

	public ANDChangeFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected GatewayType getType() {
		return GatewayType.AND;
	}

}
