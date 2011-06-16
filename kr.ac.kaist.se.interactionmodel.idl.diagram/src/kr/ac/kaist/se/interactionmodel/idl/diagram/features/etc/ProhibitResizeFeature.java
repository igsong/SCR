package kr.ac.kaist.se.interactionmodel.idl.diagram.features.etc;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IResizeConfiguration;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;

public class ProhibitResizeFeature extends DefaultResizeShapeFeature {

	public static IResizeConfiguration noResizeConfiguration = new IResizeConfiguration()
	{
		@Override
		public boolean isVerticalResizeAllowed() {
			return false;
		}

		@Override
		public boolean isHorizantalResizeAllowed() {
			return false;
		}
		
	};
	
	public ProhibitResizeFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canResizeShape(IResizeShapeContext context) {
		return false;
	}

	@Override
	public IResizeConfiguration getResizeConfiguration() {
		return noResizeConfiguration;
	}

}
