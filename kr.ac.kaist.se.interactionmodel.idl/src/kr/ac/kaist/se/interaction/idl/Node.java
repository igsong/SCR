/**
 * <copyright>
 * </copyright>
 *
 * $Id: Node.java,v 1.1 2011-02-21 04:15:42 igsong Exp $
 */
package kr.ac.kaist.se.interaction.idl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link kr.ac.kaist.se.interaction.idl.Node#getIncomings <em>Incomings</em>}</li>
 *   <li>{@link kr.ac.kaist.se.interaction.idl.Node#getOutgoings <em>Outgoings</em>}</li>
 *   <li>{@link kr.ac.kaist.se.interaction.idl.Node#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see kr.ac.kaist.se.interaction.idl.IdlPackage#getNode()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Node extends InteractionElement {
	/**
	 * Returns the value of the '<em><b>Incomings</b></em>' reference list.
	 * The list contents are of type {@link kr.ac.kaist.se.interaction.idl.Edge}.
	 * It is bidirectional and its opposite is '{@link kr.ac.kaist.se.interaction.idl.Edge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incomings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incomings</em>' reference list.
	 * @see kr.ac.kaist.se.interaction.idl.IdlPackage#getNode_Incomings()
	 * @see kr.ac.kaist.se.interaction.idl.Edge#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Edge> getIncomings();

	/**
	 * Returns the value of the '<em><b>Outgoings</b></em>' reference list.
	 * The list contents are of type {@link kr.ac.kaist.se.interaction.idl.Edge}.
	 * It is bidirectional and its opposite is '{@link kr.ac.kaist.se.interaction.idl.Edge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoings</em>' reference list.
	 * @see kr.ac.kaist.se.interaction.idl.IdlPackage#getNode_Outgoings()
	 * @see kr.ac.kaist.se.interaction.idl.Edge#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Edge> getOutgoings();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link kr.ac.kaist.se.interaction.idl.Choreography#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Choreography)
	 * @see kr.ac.kaist.se.interaction.idl.IdlPackage#getNode_Owner()
	 * @see kr.ac.kaist.se.interaction.idl.Choreography#getNodes
	 * @model opposite="nodes" transient="false"
	 * @generated
	 */
	Choreography getOwner();

	/**
	 * Sets the value of the '{@link kr.ac.kaist.se.interaction.idl.Node#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Choreography value);

} // Node
