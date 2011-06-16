package kr.ac.kaist.se.interactionmodel.idl.diagram.features;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.util.*;

import att.grappa.*;

public class StickBuilt {

	public final static String INSTANCES = "instances";
	public final static String SCRIPT = "formatDemo";

	public DemoFrame frame = null;
	Graph graph;

	/*
	 * simple-minded example that builds the graph: args[0] -> args[1] ->
	 * args[2] -> ... -> args[args.length - 1]
	 */

	public static void main(String[] args) {
		StickBuilt sb = new StickBuilt();
		sb.load(args);
		sb.display();
	}

	public StickBuilt() {
		graph = null;
		Element.setUserAttributeType(INSTANCES, GrappaConstants.INTEGER_TYPE);
	}

	void load(String[] nodes) {

		int inst, prev, crnt, cnt;
		Edge eg;
		Node[] nd = { null, null };
		String name;

		if (graph == null) {
			graph = new Graph("stickbuilt"/* , true, false */);
		} else {
			graph.reset(/* "stickbuilt", true, false */);
		}
		graph.setMenuable(true);

		graph.setAttribute("rankdir", "LR");
		graph.setAttribute("label", "\\n\\n \\n \\n \\n");
		graph.setAttribute("fontstyle", "bold");
		graph.setAttribute("fontsize", "24");
		graph.setAttribute("font", "Helvetica");

		graph.setNodeAttribute("shape", "ellipse");
		graph.setNodeAttribute("style", "filled");
		graph.setNodeAttribute("color", "beige");
		graph.setNodeAttribute("tip", "A Node");

		graph.setEdgeAttribute("color", "darkgreen");
		graph.setEdgeAttribute("tip", "An Edge");
		graph.setEdgeAttribute(INSTANCES, "1");

		if (nodes != null) {
			for (cnt = 0; cnt < nodes.length; cnt++) {
				crnt = cnt % 2;
				prev = (crnt + 1) % 2;
				if (nodes[cnt] == null || nodes[cnt].length() == 0) {
					name = "<no_name>";
				} else {
					name = nodes[cnt];
				}
				if ((nd[crnt] = graph.findNodeByName(name)) == null) {
					nd[crnt] = new Node(graph, name);
					/*
					 * set the initial position just so they don't all draw at
					 * (0,0). The display display frame has a button that takes
					 * advantage of GrappaSupport.filterGraph(...) to get a
					 * better layout by letting one of the graphviz layout tools
					 * such as "dot" or "neato" do the layout for you.
					 */
					nd[crnt].setAttribute(GrappaConstants.POS_ATTR,
							((cnt * 125) + ",0"));
				}
				if (nd[prev] != null) {
					name = nd[prev].getName() + "->" + name;
					if ((eg = graph.findEdgeByName(name)) == null) {
						eg = new Edge(graph, nd[prev], nd[crnt], name);
					} else {
						inst = ((Integer) (eg.getAttributeValue(INSTANCES)))
								.intValue() + 1;
						eg.setAttribute(INSTANCES, new Integer(inst));
					}
				}
			}
		}
	}

	void display() {

		frame = new DemoFrame();
		frame.show();
	}

	class DemoFrame extends JFrame implements ActionListener {
		GrappaPanel gp;
		JScrollPane jsp;

		JButton layout = null;
		JButton printer = null;
		JButton quit = null;
		JPanel panel = null;

		public DemoFrame() {
			super("DemoFrame");

			setSize(600, 400);
			setLocation(100, 100);

			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent wev) {
					Window w = wev.getWindow();
					w.setVisible(false);
					w.dispose();
					System.exit(0);
				}
			});

			jsp = new JScrollPane();
			// BLIT_SCROLL_MODE is nicer except zooming causes problems;
			// need to investigate that a bit someday
			// jsp.getViewport().setScrollMode(JViewport.BLIT_SCROLL_MODE);
			jsp.getViewport().setScrollMode(JViewport.BACKINGSTORE_SCROLL_MODE);
			jsp.getViewport().setBackground(Color.green);

			gp = new GrappaPanel(graph);
			gp.addGrappaListener(new GrappaAdapter());
			gp.setScaleToFit(false);

			java.awt.Rectangle bbox = graph.getBoundingBox().getBounds();

			GridBagLayout gbl = new GridBagLayout();
			GridBagConstraints gbc = new GridBagConstraints();

			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.anchor = GridBagConstraints.NORTHWEST;

			panel = new JPanel();
			panel.setLayout(gbl);

			layout = new JButton("Layout");
			gbl.setConstraints(layout, gbc);
			panel.add(layout);
			layout.addActionListener(this);

			printer = new JButton("Print");
			gbl.setConstraints(printer, gbc);
			panel.add(printer);
			printer.addActionListener(this);

			quit = new JButton("Quit");
			gbl.setConstraints(quit, gbc);
			panel.add(quit);
			quit.addActionListener(this);

			getContentPane().add("Center", jsp);
			getContentPane().add("West", panel);

			setVisible(true);
			jsp.setViewportView(gp);
		}

		public void actionPerformed(ActionEvent evt) {
			if (evt.getSource() instanceof JButton) {
				JButton tgt = (JButton) evt.getSource();
				if (tgt == quit) {
					System.exit(0);
				} else if (tgt == printer) {
					graph.printGraph(System.out);
					System.out.flush();
				} else if (tgt == layout) {
					Object connector = null;
					try {
						connector = Runtime.getRuntime()
								.exec(StickBuilt.SCRIPT);
					} catch (Exception ex) {
						System.err
								.println("Exception while setting up Process: "
										+ ex.getMessage()
										+ "\nTrying URLConnection...");
						connector = null;
					}
					if (connector == null) {
						try {
							connector = (new URL(
									"http://www.research.att.com/~john/cgi-bin/format-graph"))
									.openConnection();
							URLConnection urlConn = (URLConnection) connector;
							urlConn.setDoInput(true);
							urlConn.setDoOutput(true);
							urlConn.setUseCaches(false);
							urlConn.setRequestProperty("Content-Type",
									"application/x-www-form-urlencoded");
						} catch (Exception ex) {
							System.err
									.println("Exception while setting up URLConnection: "
											+ ex.getMessage()
											+ "\nLayout not performed.");
							connector = null;
						}
					}
					if (connector != null) {
						if (!GrappaSupport.filterGraph(graph, connector)) {
							System.err
									.println("ERROR: somewhere in filterGraph");
						}
						if (connector instanceof Process) {
							try {
								int code = ((Process) connector).waitFor();
								if (code != 0) {
									System.err
											.println("WARNING: proc exit code is: "
													+ code);
								}
							} catch (InterruptedException ex) {
								System.err
										.println("Exception while closing down proc: "
												+ ex.getMessage());
								ex.printStackTrace(System.err);
							}
						}
						connector = null;
					}
					graph.repaint();
				}
			}
		}
	}
}
