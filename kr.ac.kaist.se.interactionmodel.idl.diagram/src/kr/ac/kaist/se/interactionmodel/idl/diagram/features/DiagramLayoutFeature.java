package kr.ac.kaist.se.interactionmodel.idl.diagram.features;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import kr.ac.kaist.se.interaction.idl.Choreography;
import kr.ac.kaist.se.interaction.idl.Edge;
import kr.ac.kaist.se.interaction.idl.Final;
import kr.ac.kaist.se.interaction.idl.Gateway;
import kr.ac.kaist.se.interaction.idl.Initial;
import kr.ac.kaist.se.interaction.idl.Interaction;
import kr.ac.kaist.se.interaction.idl.Node;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.algorithms.styles.StylesFactory;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;

import att.grappa.Attribute;
import att.grappa.Graph;
import att.grappa.Grappa;
import att.grappa.GrappaConstants;
import att.grappa.GrappaLine;
import att.grappa.GrappaPoint;
import att.grappa.GrappaSupport;
import att.grappa.Parser;

public class DiagramLayoutFeature extends AbstractCustomFeature {

	public DiagramLayoutFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getName() {
		return "Layout diagram";
	}

	@Override
	public String getDescription() {
		return "Layout diagram automatically";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) 
		{
			if(pes[0] instanceof Diagram)
			{
				ret = true;
			}
		}
		return ret;
	}
	
	private Choreography getChoreography(ICustomContext context)
	{
		Diagram diagram = (Diagram)context.getPictogramElements()[0];
		if( diagram.getChildren().size() == 0 ) return null;
		Choreography chor = null;
		for( Shape shape : diagram.getChildren() )
		{
			Object bo = getBusinessObjectForPictogramElement(shape);
			if( bo instanceof Node )
			{
				Node n = (Node)bo;
				chor = n.getOwner();
			}
		}
		return chor;
	}

	public static final double zoom = 1.0;
	
	public void execute(ICustomContext context) {
		Diagram diagram = (Diagram)context.getPictogramElements()[0];
		Choreography chor = getChoreography(context);
		if( chor == null ) return;

		
		Graph g = createGrappaGraph(chor); 
		double minX = 0;
		double minY = 0;
		for( att.grappa.Node n : g.nodeElementsAsArray() )
		{
			Attribute att = n.getAttribute(GrappaConstants.POS_ATTR);
			GrappaPoint p = (GrappaPoint)att.getValue();
			if( minX > p.x ) minX = p.x;
			if( minY > p.y ) minY = p.y;
		}
		for( att.grappa.Edge e : g.edgeElementsAsArray() )
		{
			Attribute att = e.getAttribute(GrappaConstants.POS_ATTR);
			GrappaLine gl = (GrappaLine)att.getValue();
			GrappaPoint[] points = gl.getGrappaPoints();
			for( int i = 1; i < points.length - 1; i++ )
			{
				GrappaPoint p = points[i];
				if( minX > p.x ) minX = p.x;
				if( minY > p.y ) minY = p.y;
			}
		}
		
		if( minX > 0 ) minX = 0;
		if( minY > 0 ) minY = 0;

		// Minimum margin
		minX -= 50/zoom;
		minY -= 30/zoom;
		
		
		for( att.grappa.Node n : g.nodeElementsAsArray() )
		{
			Attribute att = n.getAttribute(GrappaConstants.POS_ATTR);
			GrappaPoint p = (GrappaPoint)att.getValue();
			Node nn = name2Node.get(n.getName());
			int dx = 0;
			int dy = 0;
			
			System.err.println(p.x);
			System.err.println(p.y);
			
			if( nn instanceof Interaction )
			{
				dx = 50;
				dy = 30;
			}
			else if(nn instanceof Gateway )
			{
				dx = 24;
				dy = 24;
			}
			else if(nn instanceof Initial )
			{
				dx = 14;
				dy = 14;
			}
			else if(nn instanceof Final )
			{
				dx = 18;
				dy = 18;
			}
			Graphiti.getGaService().setLocation(
					this.getFeatureProvider().getPictogramElementForBusinessObject(nn)
					.getGraphicsAlgorithm(), (int)((p.x - minX) * zoom) -dx , (int)((p.y - minY) * zoom)-dy );
		}
		
		
		for( att.grappa.Edge e : g.edgeElementsAsArray() )
		{
			Attribute att = e.getAttribute(GrappaConstants.POS_ATTR);
			GrappaLine p = (GrappaLine)att.getValue();
			Edge ee = name2Edge.get(e.getName());
			GrappaPoint[] points = p.getGrappaPoints();
			FreeFormConnection conn = 
				(FreeFormConnection)this.getFeatureProvider().getPictogramElementForBusinessObject(ee);
			conn.getBendpoints().clear();
			for( int i = 1; i < points.length - 1; i++ )
			{
				GrappaPoint gp = points[i];
				Point newP = StylesFactory.eINSTANCE.createPoint();
				newP.setX((int) ((gp.x - minX) * zoom));
				newP.setY((int) ((gp.y - minY) * zoom ));
				conn.getBendpoints().add(newP);
			}
		}
		
		this.layoutPictogramElement(diagram);
		
	}

	private HashMap<String, Node> name2Node = new HashMap<String, Node>();
	private HashMap<String, Edge> name2Edge = new HashMap<String, Edge>();
	
	private Graph createGrappaGraph(Choreography chor) {
		name2Node.clear();
		Graph graph = new Graph("Choreography", true, false);
		int i = 0;
		HashMap<Node, att.grappa.Node> map = new HashMap<Node, att.grappa.Node>();
		
		graph.setAttribute("rankdir", "LR");
		
		graph.setAttribute("fontstyle", "bold");
		graph.setAttribute("fontsize", "24");
		graph.setAttribute("font", "Helvetica");

		graph.setNodeAttribute("style", "filled");
		graph.setNodeAttribute("color", "beige");
		graph.setNodeAttribute("tip", "A Node");

		graph.setEdgeAttribute("color", "darkgreen");
		graph.setEdgeAttribute("tip", "An Edge");
		
		for( Node n : chor.getNodes() )
		{
			String name = "node" + Integer.toString(i);
			att.grappa.Node grappaNode = new att.grappa.Node(graph, name);
			name2Node.put(name, n);
			map.put(n, grappaNode);
			
			grappaNode.setAttribute("fixedsize", "true");
			
			if( n instanceof Interaction )
			{
				grappaNode.setAttribute(GrappaConstants.LABEL_ATTR, n.getName());
				grappaNode.setAttribute(GrappaConstants.SHAPE_ATTR, "box");
				grappaNode.setAttribute(GrappaConstants.WIDTH_ATTR, Double.toString(100/72./zoom));
				grappaNode.setAttribute(GrappaConstants.HEIGHT_ATTR, Double.toString(60/72./zoom));
			}
			else if(n instanceof Gateway )
			{
				grappaNode.setAttribute(GrappaConstants.SHAPE_ATTR, "diamond");
				grappaNode.setAttribute(GrappaConstants.WIDTH_ATTR, Double.toString(48/72./zoom));
				grappaNode.setAttribute(GrappaConstants.HEIGHT_ATTR, Double.toString(48/72./zoom));
			}
			else if(n instanceof Initial )
			{
				grappaNode.setAttribute(GrappaConstants.SHAPE_ATTR, "circle");
				grappaNode.setAttribute(GrappaConstants.WIDTH_ATTR, Double.toString(28/72./zoom));
				grappaNode.setAttribute(GrappaConstants.HEIGHT_ATTR, Double.toString(28/72./zoom));
			}
			else if(n instanceof Final )
			{
				grappaNode.setAttribute(GrappaConstants.SHAPE_ATTR, "circle");
				grappaNode.setAttribute(GrappaConstants.WIDTH_ATTR, Double.toString(36/72./zoom));
				grappaNode.setAttribute(GrappaConstants.HEIGHT_ATTR, Double.toString(36/72./zoom));
			}
			i++;
		}
		
		int j = 0;
		for(Edge e : chor.getEdges() )
		{
			att.grappa.Node s = map.get(e.getSource());
			att.grappa.Node t = map.get(e.getTarget());
			String name = "edge" + Integer.toString(j);
			name2Edge.put(name, e);
			j++;
			att.grappa.Edge grappaEdge = new att.grappa.Edge(graph, s, t, name);
		}
		
		Object connector = null;
		try {
			connector = Runtime.getRuntime().exec("/usr/local/bin/dot");
//			Runtime.getRuntime().e
		} catch(Exception ex) {
			System.err.println("Exception while setting up Process: " + ex.getMessage() + "\nTrying URLConnection...");
			connector = null;
		}
		if(connector == null) {
			try {
				connector = (new URL("http://www.research.att.com/~john/cgi-bin/format-graph")).openConnection();
				URLConnection urlConn = (URLConnection)connector;
				urlConn.setDoInput(true);
				urlConn.setDoOutput(true);
				urlConn.setUseCaches(false);
				urlConn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			} catch(Exception ex) {
				System.err.println("Exception while setting up URLConnection: " + ex.getMessage() + "\nLayout not performed.");
				connector = null;
			}
		}
		if(connector != null) {
			
			if(!GrappaSupport.filterGraph(graph,connector, null)) {
				System.err.println("ERROR: somewhere in filterGraph");
			}
			if(connector instanceof Process) {
				try {
					int code = ((Process)connector).waitFor();
					if(code != 0) {
						System.err.println("WARNING: proc exit code is: " + code);
					}
				} catch(InterruptedException ex) {
					System.err.println("Exception while closing down proc: " + ex.getMessage());
					ex.printStackTrace(System.err);
				}
			}
			connector = null;
		}
		
		return graph;
	}
}
