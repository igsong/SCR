/**
 * <copyright>
 * </copyright>
 *
 * $Id: IdlPackage.java,v 1.1 2011-02-21 04:15:42 igsong Exp $
 */
package kr.ac.kaist.se.interaction.idl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see kr.ac.kaist.se.interaction.idl.IdlFactory
 * @model kind="package"
 * @generated
 */
public interface IdlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "idl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.kaist.ac.kr/idl/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "idl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IdlPackage eINSTANCE = kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl.init();

	/**
	 * The meta object id for the '{@link kr.ac.kaist.se.interaction.idl.impl.ChoreographyImpl <em>Choreography</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.kaist.se.interaction.idl.impl.ChoreographyImpl
	 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getChoreography()
	 * @generated
	 */
	int CHOREOGRAPHY = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOREOGRAPHY__EANNOTATIONS = EcorePackage.EPACKAGE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOREOGRAPHY__NAME = EcorePackage.EPACKAGE__NAME;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOREOGRAPHY__NS_URI = EcorePackage.EPACKAGE__NS_URI;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOREOGRAPHY__NS_PREFIX = EcorePackage.EPACKAGE__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>EFactory Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOREOGRAPHY__EFACTORY_INSTANCE = EcorePackage.EPACKAGE__EFACTORY_INSTANCE;

	/**
	 * The feature id for the '<em><b>EClassifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOREOGRAPHY__ECLASSIFIERS = EcorePackage.EPACKAGE__ECLASSIFIERS;

	/**
	 * The feature id for the '<em><b>ESubpackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOREOGRAPHY__ESUBPACKAGES = EcorePackage.EPACKAGE__ESUBPACKAGES;

	/**
	 * The feature id for the '<em><b>ESuper Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOREOGRAPHY__ESUPER_PACKAGE = EcorePackage.EPACKAGE__ESUPER_PACKAGE;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOREOGRAPHY__NODES = EcorePackage.EPACKAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOREOGRAPHY__EDGES = EcorePackage.EPACKAGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Participants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOREOGRAPHY__PARTICIPANTS = EcorePackage.EPACKAGE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Choreography</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOREOGRAPHY_FEATURE_COUNT = EcorePackage.EPACKAGE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link kr.ac.kaist.se.interaction.idl.InteractionElement <em>Interaction Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.kaist.se.interaction.idl.InteractionElement
	 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getInteractionElement()
	 * @generated
	 */
	int INTERACTION_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_ELEMENT__EANNOTATIONS = EcorePackage.ENAMED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_ELEMENT__NAME = EcorePackage.ENAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Interaction Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_ELEMENT_FEATURE_COUNT = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link kr.ac.kaist.se.interaction.idl.impl.ParticipantImpl <em>Participant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.kaist.se.interaction.idl.impl.ParticipantImpl
	 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getParticipant()
	 * @generated
	 */
	int PARTICIPANT = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__EANNOTATIONS = INTERACTION_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__NAME = INTERACTION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__OWNER = INTERACTION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Participant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_FEATURE_COUNT = INTERACTION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link kr.ac.kaist.se.interaction.idl.Node <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.kaist.se.interaction.idl.Node
	 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 10;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__EANNOTATIONS = INTERACTION_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = INTERACTION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__INCOMINGS = INTERACTION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OUTGOINGS = INTERACTION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OWNER = INTERACTION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = INTERACTION_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link kr.ac.kaist.se.interaction.idl.impl.InteractionImpl <em>Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.kaist.se.interaction.idl.impl.InteractionImpl
	 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getInteraction()
	 * @generated
	 */
	int INTERACTION = 3;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__EANNOTATIONS = NODE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__INCOMINGS = NODE__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__OUTGOINGS = NODE__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__OWNER = NODE__OWNER;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__SENDER = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Receiver</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__RECEIVER = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_FEATURE_COUNT = NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link kr.ac.kaist.se.interaction.idl.Edge <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.kaist.se.interaction.idl.Edge
	 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 11;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__EANNOTATIONS = INTERACTION_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__NAME = INTERACTION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SOURCE = INTERACTION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TARGET = INTERACTION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__OWNER = INTERACTION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = INTERACTION_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link kr.ac.kaist.se.interaction.idl.impl.SequenceFlowImpl <em>Sequence Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.kaist.se.interaction.idl.impl.SequenceFlowImpl
	 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getSequenceFlow()
	 * @generated
	 */
	int SEQUENCE_FLOW = 4;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__EANNOTATIONS = EDGE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__NAME = EDGE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__SOURCE = EDGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__TARGET = EDGE__TARGET;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__OWNER = EDGE__OWNER;

	/**
	 * The number of structural features of the '<em>Sequence Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW_FEATURE_COUNT = EDGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link kr.ac.kaist.se.interaction.idl.ControlNode <em>Control Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.kaist.se.interaction.idl.ControlNode
	 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getControlNode()
	 * @generated
	 */
	int CONTROL_NODE = 9;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_NODE__EANNOTATIONS = NODE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_NODE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_NODE__INCOMINGS = NODE__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_NODE__OUTGOINGS = NODE__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_NODE__OWNER = NODE__OWNER;

	/**
	 * The number of structural features of the '<em>Control Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link kr.ac.kaist.se.interaction.idl.Gateway <em>Gateway</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.kaist.se.interaction.idl.Gateway
	 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getGateway()
	 * @generated
	 */
	int GATEWAY = 12;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__EANNOTATIONS = CONTROL_NODE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__NAME = CONTROL_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__INCOMINGS = CONTROL_NODE__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__OUTGOINGS = CONTROL_NODE__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__OWNER = CONTROL_NODE__OWNER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__TYPE = CONTROL_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Gateway</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY_FEATURE_COUNT = CONTROL_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link kr.ac.kaist.se.interaction.idl.impl.BranchImpl <em>Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.kaist.se.interaction.idl.impl.BranchImpl
	 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getBranch()
	 * @generated
	 */
	int BRANCH = 5;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__EANNOTATIONS = GATEWAY__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__NAME = GATEWAY__NAME;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__INCOMINGS = GATEWAY__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__OUTGOINGS = GATEWAY__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__OWNER = GATEWAY__OWNER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__TYPE = GATEWAY__TYPE;

	/**
	 * The number of structural features of the '<em>Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_FEATURE_COUNT = GATEWAY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link kr.ac.kaist.se.interaction.idl.impl.JoinImpl <em>Join</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.kaist.se.interaction.idl.impl.JoinImpl
	 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getJoin()
	 * @generated
	 */
	int JOIN = 6;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__EANNOTATIONS = GATEWAY__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__NAME = GATEWAY__NAME;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__INCOMINGS = GATEWAY__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__OUTGOINGS = GATEWAY__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__OWNER = GATEWAY__OWNER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__TYPE = GATEWAY__TYPE;

	/**
	 * The number of structural features of the '<em>Join</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_FEATURE_COUNT = GATEWAY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link kr.ac.kaist.se.interaction.idl.impl.InitialImpl <em>Initial</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.kaist.se.interaction.idl.impl.InitialImpl
	 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getInitial()
	 * @generated
	 */
	int INITIAL = 7;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL__EANNOTATIONS = CONTROL_NODE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL__NAME = CONTROL_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL__INCOMINGS = CONTROL_NODE__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL__OUTGOINGS = CONTROL_NODE__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL__OWNER = CONTROL_NODE__OWNER;

	/**
	 * The number of structural features of the '<em>Initial</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_FEATURE_COUNT = CONTROL_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link kr.ac.kaist.se.interaction.idl.impl.FinalImpl <em>Final</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.kaist.se.interaction.idl.impl.FinalImpl
	 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getFinal()
	 * @generated
	 */
	int FINAL = 8;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL__EANNOTATIONS = CONTROL_NODE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL__NAME = CONTROL_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL__INCOMINGS = CONTROL_NODE__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL__OUTGOINGS = CONTROL_NODE__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL__OWNER = CONTROL_NODE__OWNER;

	/**
	 * The number of structural features of the '<em>Final</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_FEATURE_COUNT = CONTROL_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link kr.ac.kaist.se.interaction.idl.GatewayType <em>Gateway Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kr.ac.kaist.se.interaction.idl.GatewayType
	 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getGatewayType()
	 * @generated
	 */
	int GATEWAY_TYPE = 13;


	/**
	 * Returns the meta object for class '{@link kr.ac.kaist.se.interaction.idl.Choreography <em>Choreography</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choreography</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Choreography
	 * @generated
	 */
	EClass getChoreography();

	/**
	 * Returns the meta object for the containment reference list '{@link kr.ac.kaist.se.interaction.idl.Choreography#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Choreography#getNodes()
	 * @see #getChoreography()
	 * @generated
	 */
	EReference getChoreography_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link kr.ac.kaist.se.interaction.idl.Choreography#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edges</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Choreography#getEdges()
	 * @see #getChoreography()
	 * @generated
	 */
	EReference getChoreography_Edges();

	/**
	 * Returns the meta object for the containment reference list '{@link kr.ac.kaist.se.interaction.idl.Choreography#getParticipants <em>Participants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Participants</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Choreography#getParticipants()
	 * @see #getChoreography()
	 * @generated
	 */
	EReference getChoreography_Participants();

	/**
	 * Returns the meta object for class '{@link kr.ac.kaist.se.interaction.idl.Participant <em>Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Participant</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Participant
	 * @generated
	 */
	EClass getParticipant();

	/**
	 * Returns the meta object for the container reference '{@link kr.ac.kaist.se.interaction.idl.Participant#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Participant#getOwner()
	 * @see #getParticipant()
	 * @generated
	 */
	EReference getParticipant_Owner();

	/**
	 * Returns the meta object for class '{@link kr.ac.kaist.se.interaction.idl.InteractionElement <em>Interaction Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interaction Element</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.InteractionElement
	 * @generated
	 */
	EClass getInteractionElement();

	/**
	 * Returns the meta object for class '{@link kr.ac.kaist.se.interaction.idl.Interaction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interaction</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Interaction
	 * @generated
	 */
	EClass getInteraction();

	/**
	 * Returns the meta object for the reference '{@link kr.ac.kaist.se.interaction.idl.Interaction#getSender <em>Sender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sender</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Interaction#getSender()
	 * @see #getInteraction()
	 * @generated
	 */
	EReference getInteraction_Sender();

	/**
	 * Returns the meta object for the reference list '{@link kr.ac.kaist.se.interaction.idl.Interaction#getReceiver <em>Receiver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Receiver</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Interaction#getReceiver()
	 * @see #getInteraction()
	 * @generated
	 */
	EReference getInteraction_Receiver();

	/**
	 * Returns the meta object for class '{@link kr.ac.kaist.se.interaction.idl.SequenceFlow <em>Sequence Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Flow</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.SequenceFlow
	 * @generated
	 */
	EClass getSequenceFlow();

	/**
	 * Returns the meta object for class '{@link kr.ac.kaist.se.interaction.idl.Branch <em>Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Branch</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Branch
	 * @generated
	 */
	EClass getBranch();

	/**
	 * Returns the meta object for class '{@link kr.ac.kaist.se.interaction.idl.Join <em>Join</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Join</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Join
	 * @generated
	 */
	EClass getJoin();

	/**
	 * Returns the meta object for class '{@link kr.ac.kaist.se.interaction.idl.Initial <em>Initial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initial</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Initial
	 * @generated
	 */
	EClass getInitial();

	/**
	 * Returns the meta object for class '{@link kr.ac.kaist.se.interaction.idl.Final <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Final</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Final
	 * @generated
	 */
	EClass getFinal();

	/**
	 * Returns the meta object for class '{@link kr.ac.kaist.se.interaction.idl.ControlNode <em>Control Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Node</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.ControlNode
	 * @generated
	 */
	EClass getControlNode();

	/**
	 * Returns the meta object for class '{@link kr.ac.kaist.se.interaction.idl.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the reference list '{@link kr.ac.kaist.se.interaction.idl.Node#getIncomings <em>Incomings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incomings</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Node#getIncomings()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Incomings();

	/**
	 * Returns the meta object for the reference list '{@link kr.ac.kaist.se.interaction.idl.Node#getOutgoings <em>Outgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoings</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Node#getOutgoings()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Outgoings();

	/**
	 * Returns the meta object for the container reference '{@link kr.ac.kaist.se.interaction.idl.Node#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Node#getOwner()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Owner();

	/**
	 * Returns the meta object for class '{@link kr.ac.kaist.se.interaction.idl.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the reference '{@link kr.ac.kaist.se.interaction.idl.Edge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Edge#getSource()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Source();

	/**
	 * Returns the meta object for the reference '{@link kr.ac.kaist.se.interaction.idl.Edge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Edge#getTarget()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Target();

	/**
	 * Returns the meta object for the container reference '{@link kr.ac.kaist.se.interaction.idl.Edge#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Edge#getOwner()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Owner();

	/**
	 * Returns the meta object for class '{@link kr.ac.kaist.se.interaction.idl.Gateway <em>Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gateway</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Gateway
	 * @generated
	 */
	EClass getGateway();

	/**
	 * Returns the meta object for the attribute '{@link kr.ac.kaist.se.interaction.idl.Gateway#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.Gateway#getType()
	 * @see #getGateway()
	 * @generated
	 */
	EAttribute getGateway_Type();

	/**
	 * Returns the meta object for enum '{@link kr.ac.kaist.se.interaction.idl.GatewayType <em>Gateway Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Gateway Type</em>'.
	 * @see kr.ac.kaist.se.interaction.idl.GatewayType
	 * @generated
	 */
	EEnum getGatewayType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IdlFactory getIdlFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link kr.ac.kaist.se.interaction.idl.impl.ChoreographyImpl <em>Choreography</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.kaist.se.interaction.idl.impl.ChoreographyImpl
		 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getChoreography()
		 * @generated
		 */
		EClass CHOREOGRAPHY = eINSTANCE.getChoreography();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOREOGRAPHY__NODES = eINSTANCE.getChoreography_Nodes();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOREOGRAPHY__EDGES = eINSTANCE.getChoreography_Edges();

		/**
		 * The meta object literal for the '<em><b>Participants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOREOGRAPHY__PARTICIPANTS = eINSTANCE.getChoreography_Participants();

		/**
		 * The meta object literal for the '{@link kr.ac.kaist.se.interaction.idl.impl.ParticipantImpl <em>Participant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.kaist.se.interaction.idl.impl.ParticipantImpl
		 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getParticipant()
		 * @generated
		 */
		EClass PARTICIPANT = eINSTANCE.getParticipant();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTICIPANT__OWNER = eINSTANCE.getParticipant_Owner();

		/**
		 * The meta object literal for the '{@link kr.ac.kaist.se.interaction.idl.InteractionElement <em>Interaction Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.kaist.se.interaction.idl.InteractionElement
		 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getInteractionElement()
		 * @generated
		 */
		EClass INTERACTION_ELEMENT = eINSTANCE.getInteractionElement();

		/**
		 * The meta object literal for the '{@link kr.ac.kaist.se.interaction.idl.impl.InteractionImpl <em>Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.kaist.se.interaction.idl.impl.InteractionImpl
		 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getInteraction()
		 * @generated
		 */
		EClass INTERACTION = eINSTANCE.getInteraction();

		/**
		 * The meta object literal for the '<em><b>Sender</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTION__SENDER = eINSTANCE.getInteraction_Sender();

		/**
		 * The meta object literal for the '<em><b>Receiver</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTION__RECEIVER = eINSTANCE.getInteraction_Receiver();

		/**
		 * The meta object literal for the '{@link kr.ac.kaist.se.interaction.idl.impl.SequenceFlowImpl <em>Sequence Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.kaist.se.interaction.idl.impl.SequenceFlowImpl
		 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getSequenceFlow()
		 * @generated
		 */
		EClass SEQUENCE_FLOW = eINSTANCE.getSequenceFlow();

		/**
		 * The meta object literal for the '{@link kr.ac.kaist.se.interaction.idl.impl.BranchImpl <em>Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.kaist.se.interaction.idl.impl.BranchImpl
		 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getBranch()
		 * @generated
		 */
		EClass BRANCH = eINSTANCE.getBranch();

		/**
		 * The meta object literal for the '{@link kr.ac.kaist.se.interaction.idl.impl.JoinImpl <em>Join</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.kaist.se.interaction.idl.impl.JoinImpl
		 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getJoin()
		 * @generated
		 */
		EClass JOIN = eINSTANCE.getJoin();

		/**
		 * The meta object literal for the '{@link kr.ac.kaist.se.interaction.idl.impl.InitialImpl <em>Initial</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.kaist.se.interaction.idl.impl.InitialImpl
		 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getInitial()
		 * @generated
		 */
		EClass INITIAL = eINSTANCE.getInitial();

		/**
		 * The meta object literal for the '{@link kr.ac.kaist.se.interaction.idl.impl.FinalImpl <em>Final</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.kaist.se.interaction.idl.impl.FinalImpl
		 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getFinal()
		 * @generated
		 */
		EClass FINAL = eINSTANCE.getFinal();

		/**
		 * The meta object literal for the '{@link kr.ac.kaist.se.interaction.idl.ControlNode <em>Control Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.kaist.se.interaction.idl.ControlNode
		 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getControlNode()
		 * @generated
		 */
		EClass CONTROL_NODE = eINSTANCE.getControlNode();

		/**
		 * The meta object literal for the '{@link kr.ac.kaist.se.interaction.idl.Node <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.kaist.se.interaction.idl.Node
		 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Incomings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__INCOMINGS = eINSTANCE.getNode_Incomings();

		/**
		 * The meta object literal for the '<em><b>Outgoings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__OUTGOINGS = eINSTANCE.getNode_Outgoings();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__OWNER = eINSTANCE.getNode_Owner();

		/**
		 * The meta object literal for the '{@link kr.ac.kaist.se.interaction.idl.Edge <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.kaist.se.interaction.idl.Edge
		 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__SOURCE = eINSTANCE.getEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__TARGET = eINSTANCE.getEdge_Target();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__OWNER = eINSTANCE.getEdge_Owner();

		/**
		 * The meta object literal for the '{@link kr.ac.kaist.se.interaction.idl.Gateway <em>Gateway</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.kaist.se.interaction.idl.Gateway
		 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getGateway()
		 * @generated
		 */
		EClass GATEWAY = eINSTANCE.getGateway();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GATEWAY__TYPE = eINSTANCE.getGateway_Type();

		/**
		 * The meta object literal for the '{@link kr.ac.kaist.se.interaction.idl.GatewayType <em>Gateway Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kr.ac.kaist.se.interaction.idl.GatewayType
		 * @see kr.ac.kaist.se.interaction.idl.impl.IdlPackageImpl#getGatewayType()
		 * @generated
		 */
		EEnum GATEWAY_TYPE = eINSTANCE.getGatewayType();

	}

} //IdlPackage
