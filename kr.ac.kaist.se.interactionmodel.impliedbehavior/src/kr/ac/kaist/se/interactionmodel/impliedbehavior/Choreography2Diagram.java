package kr.ac.kaist.se.interactionmodel.impliedbehavior;

import java.util.HashMap;

import kr.ac.kaist.se.interaction.idl.Choreography;
import kr.ac.kaist.se.interaction.idl.Edge;
import kr.ac.kaist.se.interaction.idl.Final;
import kr.ac.kaist.se.interaction.idl.Initial;
import kr.ac.kaist.se.interaction.idl.Node;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.graphiti.ui.services.IExtensionManager;

public class Choreography2Diagram {
	
	
	public static void drawChoreography2Diagram(Choreography chor, Diagram diagram)
	{
		IExtensionManager em = GraphitiUi.getExtensionManager();
		IDiagramTypeProvider provider = 
			em.createDiagramTypeProvider(diagram, "kr.ac.kaist.se.interactionmodel.idl.diagram.BPMNChoreographyDiagramTypeProvider");
		diagram.eResource().getContents().add(chor);
		IFeatureProvider fp = provider.getFeatureProvider();
		HashMap<Node, Anchor> anchorMapping = new HashMap<Node, Anchor>();
		
		
		int x = 20;
		int y = 20;
		int idx = 0;
		for( Node node : chor.getNodes() )
		{
			if( node instanceof Initial || node instanceof Final )
			{
				System.err.println(node);
			}
			PictogramElement pe = fp.addIfPossible(new MyAddContext(diagram, node, x, y, 100, 60));
			Shape s = (Shape)pe;
			if( s.getAnchors().size() > 0 )
			{
				anchorMapping.put(node, s.getAnchors().get(0));
			}
			
			idx++;
			x += 150;
			if( idx == 10 )
			{
				x = 20;
				idx = 0;
				y += 110;
			}
		}
		
		for( Edge edge : chor.getEdges() )
		{
			Anchor source = anchorMapping.get(edge.getSource());
			Anchor target = anchorMapping.get(edge.getTarget());
			
			fp.addIfPossible(new MyAddConnectionContext(diagram, edge, source, target));
		}
//		MyLayoutContext lc = new MyLayoutContext(diagram);
//		ILayoutFeature lf = fp.getLayoutFeature(lc);
//		if( lf.canLayout(lc) ) lf.layout(lc);
	}
	
	public static final class MyLayoutContext implements ILayoutContext {
		public MyLayoutContext(Diagram diagram)
		{
			this.diagram = diagram;
		}
		
		public Diagram diagram;
		
		@Override
		public PictogramElement getPictogramElement() {
			return diagram;
		}

		@Override
		public Object putProperty(Object key, Object value) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getProperty(Object key) {
			// TODO Auto-generated method stub
			return null;
		}
	}

	static private class MyAddConnectionContext extends MyAddContext implements IAddConnectionContext
	{
		private Anchor source;
		private Anchor target;
		
		public MyAddConnectionContext(Diagram diagram, Object newObject, Anchor source, Anchor target)
		{
			super(diagram, newObject, 0, 0, 0, 0);
			this.source = source;
			this.target = target;
		}

		@Override
		public Anchor getSourceAnchor() {
			return source;
		}

		@Override
		public Anchor getTargetAnchor() {
			return target;
		}
		
	}
	
	static private class MyAddContext implements IAddContext{
		private int x = 0;
		private int y = 0;
		private int w = 0;
		private int h = 0;
		private Object newObject = null;
		private Connection connection = null;
		private Diagram targetContainer;
		
		public MyAddContext(Diagram targetContainer, Object newObject, int x, int y, int w, int h)
		{
			this.targetContainer = targetContainer;
			this.newObject= newObject;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}

		
		@Override
		public int getWidth() {
			return w;
		}

		@Override
		public int getHeight() {
			return h;
		}

		@Override
		public int getX() {
			return x;
		}

		@Override
		public int getY() {
			return y;
		}

		@Override
		public Object putProperty(Object key, Object value) {
			return null;
		}

		@Override
		public Object getProperty(Object key) {
			return null;
		}

		@Override
		public ContainerShape getTargetContainer() {
			return targetContainer;
		}

		@Override
		public Connection getTargetConnection() {
			return connection;
		}

		@Override
		public Object getNewObject() {
			return newObject;
		}


		@Override
		public ConnectionDecorator getTargetConnectionDecorator() {
			return null;
		}
		
	}
}
