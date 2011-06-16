package kr.ac.kaist.se.interactionmodel.idl.diagram.features.flow;

import kr.ac.kaist.se.interaction.idl.IdlFactory;
import kr.ac.kaist.se.interaction.idl.Node;
import kr.ac.kaist.se.interaction.idl.SequenceFlow;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;

public class FlowCreateFeature extends AbstractCreateConnectionFeature {

	public FlowCreateFeature(IFeatureProvider fp) {
		super(fp, "SequenceFlow", "Create SequenceFlow");
	}

	public boolean canCreate(ICreateConnectionContext context) {
		Node source = getNode(context.getSourceAnchor());
		Node target = getNode(context.getTargetAnchor());
		if (source != null && target != null && source != target ) {
			return true;
		}
		return false;
	}

	public boolean canStartConnection(ICreateConnectionContext context) {
		if (getNode(context.getSourceAnchor()) != null) {
			return true;
		}
		return false;
	}

	public Connection create(ICreateConnectionContext context) {

		Connection newConnection = null;

		Node source = getNode(context.getSourceAnchor());
		Node target = getNode(context.getTargetAnchor());

		if (source != null && target != null) {
			SequenceFlow sequenceFlow = createSequenceFlow(source, target);

			AddConnectionContext addContext =
				new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
			addContext.setNewObject(sequenceFlow);
			newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);
		}

		return newConnection;
	}

	/**
	 * Returns the EClass belonging to the anchor, or null if not available.
	 */
	 private Node getNode(Anchor anchor) {
		 if (anchor != null) {
			 Object object =
				 getBusinessObjectForPictogramElement(anchor.getParent());
			 if (object instanceof Node) {
				 return (Node) object;
			 }
		 }
		 return null;
	 }

	 /**
	  * Creates a EReference between two EClasses.
	  */
	 private SequenceFlow createSequenceFlow(Node source, Node target) {
		 SequenceFlow sequenceFlow = IdlFactory.eINSTANCE.createSequenceFlow();
		 sequenceFlow.setName("new sequence flow");
		 sequenceFlow.setSource(source);
		 sequenceFlow.setTarget(target);
		 source.getOwner().getEdges().add(sequenceFlow);
		 return sequenceFlow;
	 }
}
