/**
 * <copyright>
 * </copyright>
 *
 * $Id: Interaction.java,v 1.1 2011-02-21 04:15:41 igsong Exp $
 */
package kr.ac.kaist.se.interaction.idl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link kr.ac.kaist.se.interaction.idl.Interaction#getSender <em>Sender</em>}</li>
 *   <li>{@link kr.ac.kaist.se.interaction.idl.Interaction#getReceiver <em>Receiver</em>}</li>
 * </ul>
 * </p>
 *
 * @see kr.ac.kaist.se.interaction.idl.IdlPackage#getInteraction()
 * @model
 * @generated
 */
public interface Interaction extends Node {
	/**
	 * Returns the value of the '<em><b>Sender</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sender</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sender</em>' reference.
	 * @see #setSender(Participant)
	 * @see kr.ac.kaist.se.interaction.idl.IdlPackage#getInteraction_Sender()
	 * @model
	 * @generated
	 */
	Participant getSender();

	/**
	 * Sets the value of the '{@link kr.ac.kaist.se.interaction.idl.Interaction#getSender <em>Sender</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sender</em>' reference.
	 * @see #getSender()
	 * @generated
	 */
	void setSender(Participant value);

	/**
	 * Returns the value of the '<em><b>Receiver</b></em>' reference list.
	 * The list contents are of type {@link kr.ac.kaist.se.interaction.idl.Participant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receiver</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receiver</em>' reference list.
	 * @see kr.ac.kaist.se.interaction.idl.IdlPackage#getInteraction_Receiver()
	 * @model
	 * @generated
	 */
	EList<Participant> getReceiver();

} // Interaction
