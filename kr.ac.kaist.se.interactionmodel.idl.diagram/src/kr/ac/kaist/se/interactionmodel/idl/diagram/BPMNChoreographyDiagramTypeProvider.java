package kr.ac.kaist.se.interactionmodel.idl.diagram;

import kr.ac.kaist.se.interactionmodel.idl.diagram.features.gateway.GatewayToolBehaviorProvider;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

public class BPMNChoreographyDiagramTypeProvider extends
		AbstractDiagramTypeProvider {

	private IToolBehaviorProvider[] toolBehaviorProviders;


	public BPMNChoreographyDiagramTypeProvider() {
		super();
		setFeatureProvider(new BPMNChoreographyFeatureProvider(this));
	}

	@Override
	public String getDiagramTitle() {
		// TODO Auto-generated method stub
		return super.getDiagramTitle();
	}
	 

    @Override

    public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
        if (toolBehaviorProviders == null) {
            toolBehaviorProviders =
                new IToolBehaviorProvider[] { new GatewayToolBehaviorProvider(
                    this) };
        }
        return toolBehaviorProviders;
    }


}
