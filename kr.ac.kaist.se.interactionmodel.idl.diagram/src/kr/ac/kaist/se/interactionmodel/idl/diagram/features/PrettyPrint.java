package kr.ac.kaist.se.interactionmodel.idl.diagram.features;

import att.grappa.*;

public class PrettyPrint {

	public static void main(String[] args) throws Exception {
		Parser parser = new Parser(System.in, System.err);
		parser.parse();
		Graph graph = parser.getGraph();
		graph.printGraph(System.out);
		System.exit(0);
	}
}
