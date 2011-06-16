/**
 * <copyright>
 * </copyright>
 *
 * $Id: Gateway.java,v 1.1 2011-02-21 04:15:42 igsong Exp $
 */
package kr.ac.kaist.se.interaction.idl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gateway</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link kr.ac.kaist.se.interaction.idl.Gateway#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see kr.ac.kaist.se.interaction.idl.IdlPackage#getGateway()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Gateway extends ControlNode {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link kr.ac.kaist.se.interaction.idl.GatewayType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see kr.ac.kaist.se.interaction.idl.GatewayType
	 * @see #setType(GatewayType)
	 * @see kr.ac.kaist.se.interaction.idl.IdlPackage#getGateway_Type()
	 * @model
	 * @generated
	 */
	GatewayType getType();

	/**
	 * Sets the value of the '{@link kr.ac.kaist.se.interaction.idl.Gateway#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see kr.ac.kaist.se.interaction.idl.GatewayType
	 * @see #getType()
	 * @generated
	 */
	void setType(GatewayType value);

} // Gateway
