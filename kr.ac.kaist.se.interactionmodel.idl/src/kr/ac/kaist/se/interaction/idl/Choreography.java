/**
 * <copyright>
 * </copyright>
 *
 * $Id: Choreography.java,v 1.1 2011-02-21 04:15:41 igsong Exp $
 */
package kr.ac.kaist.se.interaction.idl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choreography</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link kr.ac.kaist.se.interaction.idl.Choreography#getNodes <em>Nodes</em>}</li>
 *   <li>{@link kr.ac.kaist.se.interaction.idl.Choreography#getEdges <em>Edges</em>}</li>
 *   <li>{@link kr.ac.kaist.se.interaction.idl.Choreography#getParticipants <em>Participants</em>}</li>
 * </ul>
 * </p>
 *
 * @see kr.ac.kaist.se.interaction.idl.IdlPackage#getChoreography()
 * @model
 * @generated
 */
public interface Choreography extends EPackage {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link kr.ac.kaist.se.interaction.idl.Node}.
	 * It is bidirectional and its opposite is '{@link kr.ac.kaist.se.interaction.idl.Node#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see kr.ac.kaist.se.interaction.idl.IdlPackage#getChoreography_Nodes()
	 * @see kr.ac.kaist.se.interaction.idl.Node#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link kr.ac.kaist.se.interaction.idl.Edge}.
	 * It is bidirectional and its opposite is '{@link kr.ac.kaist.se.interaction.idl.Edge#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see kr.ac.kaist.se.interaction.idl.IdlPackage#getChoreography_Edges()
	 * @see kr.ac.kaist.se.interaction.idl.Edge#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Edge> getEdges();

	/**
	 * Returns the value of the '<em><b>Participants</b></em>' containment reference list.
	 * The list contents are of type {@link kr.ac.kaist.se.interaction.idl.Participant}.
	 * It is bidirectional and its opposite is '{@link kr.ac.kaist.se.interaction.idl.Participant#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participants</em>' containment reference list.
	 * @see kr.ac.kaist.se.interaction.idl.IdlPackage#getChoreography_Participants()
	 * @see kr.ac.kaist.se.interaction.idl.Participant#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Participant> getParticipants();

} // Choreography
