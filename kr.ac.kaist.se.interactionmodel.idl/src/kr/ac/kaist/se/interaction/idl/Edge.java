/**
 * <copyright>
 * </copyright>
 *
 * $Id: Edge.java,v 1.1 2011-02-21 04:15:41 igsong Exp $
 */
package kr.ac.kaist.se.interaction.idl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link kr.ac.kaist.se.interaction.idl.Edge#getSource <em>Source</em>}</li>
 *   <li>{@link kr.ac.kaist.se.interaction.idl.Edge#getTarget <em>Target</em>}</li>
 *   <li>{@link kr.ac.kaist.se.interaction.idl.Edge#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see kr.ac.kaist.se.interaction.idl.IdlPackage#getEdge()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Edge extends InteractionElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link kr.ac.kaist.se.interaction.idl.Node#getOutgoings <em>Outgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Node)
	 * @see kr.ac.kaist.se.interaction.idl.IdlPackage#getEdge_Source()
	 * @see kr.ac.kaist.se.interaction.idl.Node#getOutgoings
	 * @model opposite="outgoings"
	 * @generated
	 */
	Node getSource();

	/**
	 * Sets the value of the '{@link kr.ac.kaist.se.interaction.idl.Edge#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Node value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link kr.ac.kaist.se.interaction.idl.Node#getIncomings <em>Incomings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Node)
	 * @see kr.ac.kaist.se.interaction.idl.IdlPackage#getEdge_Target()
	 * @see kr.ac.kaist.se.interaction.idl.Node#getIncomings
	 * @model opposite="incomings"
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link kr.ac.kaist.se.interaction.idl.Edge#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link kr.ac.kaist.se.interaction.idl.Choreography#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Choreography)
	 * @see kr.ac.kaist.se.interaction.idl.IdlPackage#getEdge_Owner()
	 * @see kr.ac.kaist.se.interaction.idl.Choreography#getEdges
	 * @model opposite="edges" transient="false"
	 * @generated
	 */
	Choreography getOwner();

	/**
	 * Sets the value of the '{@link kr.ac.kaist.se.interaction.idl.Edge#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Choreography value);

} // Edge
