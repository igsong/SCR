/**
 * <copyright>
 * </copyright>
 *
 * $Id: Participant.java,v 1.1 2011-02-21 04:15:41 igsong Exp $
 */
package kr.ac.kaist.se.interaction.idl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Participant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link kr.ac.kaist.se.interaction.idl.Participant#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see kr.ac.kaist.se.interaction.idl.IdlPackage#getParticipant()
 * @model
 * @generated
 */
public interface Participant extends InteractionElement {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link kr.ac.kaist.se.interaction.idl.Choreography#getParticipants <em>Participants</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Choreography)
	 * @see kr.ac.kaist.se.interaction.idl.IdlPackage#getParticipant_Owner()
	 * @see kr.ac.kaist.se.interaction.idl.Choreography#getParticipants
	 * @model opposite="participants" transient="false"
	 * @generated
	 */
	Choreography getOwner();

	/**
	 * Sets the value of the '{@link kr.ac.kaist.se.interaction.idl.Participant#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Choreography value);

} // Participant
