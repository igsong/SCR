/**
 * <copyright>
 * </copyright>
 *
 * $Id: InteractionImpl.java,v 1.1 2011-02-21 04:15:40 igsong Exp $
 */
package kr.ac.kaist.se.interaction.idl.impl;

import java.util.Collection;

import kr.ac.kaist.se.interaction.idl.Choreography;
import kr.ac.kaist.se.interaction.idl.Edge;
import kr.ac.kaist.se.interaction.idl.IdlPackage;
import kr.ac.kaist.se.interaction.idl.Interaction;
import kr.ac.kaist.se.interaction.idl.Participant;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENamedElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link kr.ac.kaist.se.interaction.idl.impl.InteractionImpl#getIncomings <em>Incomings</em>}</li>
 *   <li>{@link kr.ac.kaist.se.interaction.idl.impl.InteractionImpl#getOutgoings <em>Outgoings</em>}</li>
 *   <li>{@link kr.ac.kaist.se.interaction.idl.impl.InteractionImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link kr.ac.kaist.se.interaction.idl.impl.InteractionImpl#getSender <em>Sender</em>}</li>
 *   <li>{@link kr.ac.kaist.se.interaction.idl.impl.InteractionImpl#getReceiver <em>Receiver</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InteractionImpl extends ENamedElementImpl implements Interaction {
	/**
	 * The cached value of the '{@link #getIncomings() <em>Incomings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomings()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> incomings;

	/**
	 * The cached value of the '{@link #getOutgoings() <em>Outgoings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoings()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> outgoings;

	/**
	 * The cached value of the '{@link #getSender() <em>Sender</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSender()
	 * @generated
	 * @ordered
	 */
	protected Participant sender;

	/**
	 * The cached value of the '{@link #getReceiver() <em>Receiver</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceiver()
	 * @generated
	 * @ordered
	 */
	protected EList<Participant> receiver;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InteractionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IdlPackage.Literals.INTERACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getIncomings() {
		if (incomings == null) {
			incomings = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, IdlPackage.INTERACTION__INCOMINGS, IdlPackage.EDGE__TARGET);
		}
		return incomings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getOutgoings() {
		if (outgoings == null) {
			outgoings = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, IdlPackage.INTERACTION__OUTGOINGS, IdlPackage.EDGE__SOURCE);
		}
		return outgoings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choreography getOwner() {
		if (eContainerFeatureID() != IdlPackage.INTERACTION__OWNER) return null;
		return (Choreography)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Choreography newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, IdlPackage.INTERACTION__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Choreography newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != IdlPackage.INTERACTION__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, IdlPackage.CHOREOGRAPHY__NODES, Choreography.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.INTERACTION__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant getSender() {
		if (sender != null && sender.eIsProxy()) {
			InternalEObject oldSender = (InternalEObject)sender;
			sender = (Participant)eResolveProxy(oldSender);
			if (sender != oldSender) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IdlPackage.INTERACTION__SENDER, oldSender, sender));
			}
		}
		return sender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant basicGetSender() {
		return sender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSender(Participant newSender) {
		Participant oldSender = sender;
		sender = newSender;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.INTERACTION__SENDER, oldSender, sender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Participant> getReceiver() {
		if (receiver == null) {
			receiver = new EObjectResolvingEList<Participant>(Participant.class, this, IdlPackage.INTERACTION__RECEIVER);
		}
		return receiver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IdlPackage.INTERACTION__INCOMINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomings()).basicAdd(otherEnd, msgs);
			case IdlPackage.INTERACTION__OUTGOINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoings()).basicAdd(otherEnd, msgs);
			case IdlPackage.INTERACTION__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((Choreography)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IdlPackage.INTERACTION__INCOMINGS:
				return ((InternalEList<?>)getIncomings()).basicRemove(otherEnd, msgs);
			case IdlPackage.INTERACTION__OUTGOINGS:
				return ((InternalEList<?>)getOutgoings()).basicRemove(otherEnd, msgs);
			case IdlPackage.INTERACTION__OWNER:
				return basicSetOwner(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case IdlPackage.INTERACTION__OWNER:
				return eInternalContainer().eInverseRemove(this, IdlPackage.CHOREOGRAPHY__NODES, Choreography.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IdlPackage.INTERACTION__INCOMINGS:
				return getIncomings();
			case IdlPackage.INTERACTION__OUTGOINGS:
				return getOutgoings();
			case IdlPackage.INTERACTION__OWNER:
				return getOwner();
			case IdlPackage.INTERACTION__SENDER:
				if (resolve) return getSender();
				return basicGetSender();
			case IdlPackage.INTERACTION__RECEIVER:
				return getReceiver();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IdlPackage.INTERACTION__INCOMINGS:
				getIncomings().clear();
				getIncomings().addAll((Collection<? extends Edge>)newValue);
				return;
			case IdlPackage.INTERACTION__OUTGOINGS:
				getOutgoings().clear();
				getOutgoings().addAll((Collection<? extends Edge>)newValue);
				return;
			case IdlPackage.INTERACTION__OWNER:
				setOwner((Choreography)newValue);
				return;
			case IdlPackage.INTERACTION__SENDER:
				setSender((Participant)newValue);
				return;
			case IdlPackage.INTERACTION__RECEIVER:
				getReceiver().clear();
				getReceiver().addAll((Collection<? extends Participant>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case IdlPackage.INTERACTION__INCOMINGS:
				getIncomings().clear();
				return;
			case IdlPackage.INTERACTION__OUTGOINGS:
				getOutgoings().clear();
				return;
			case IdlPackage.INTERACTION__OWNER:
				setOwner((Choreography)null);
				return;
			case IdlPackage.INTERACTION__SENDER:
				setSender((Participant)null);
				return;
			case IdlPackage.INTERACTION__RECEIVER:
				getReceiver().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case IdlPackage.INTERACTION__INCOMINGS:
				return incomings != null && !incomings.isEmpty();
			case IdlPackage.INTERACTION__OUTGOINGS:
				return outgoings != null && !outgoings.isEmpty();
			case IdlPackage.INTERACTION__OWNER:
				return getOwner() != null;
			case IdlPackage.INTERACTION__SENDER:
				return sender != null;
			case IdlPackage.INTERACTION__RECEIVER:
				return receiver != null && !receiver.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InteractionImpl
