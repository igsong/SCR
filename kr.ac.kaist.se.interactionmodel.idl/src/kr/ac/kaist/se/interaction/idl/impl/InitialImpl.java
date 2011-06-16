/**
 * <copyright>
 * </copyright>
 *
 * $Id: InitialImpl.java,v 1.1 2011-02-21 04:15:41 igsong Exp $
 */
package kr.ac.kaist.se.interaction.idl.impl;

import java.util.Collection;

import kr.ac.kaist.se.interaction.idl.Choreography;
import kr.ac.kaist.se.interaction.idl.Edge;
import kr.ac.kaist.se.interaction.idl.IdlPackage;
import kr.ac.kaist.se.interaction.idl.Initial;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENamedElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Initial</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link kr.ac.kaist.se.interaction.idl.impl.InitialImpl#getIncomings <em>Incomings</em>}</li>
 *   <li>{@link kr.ac.kaist.se.interaction.idl.impl.InitialImpl#getOutgoings <em>Outgoings</em>}</li>
 *   <li>{@link kr.ac.kaist.se.interaction.idl.impl.InitialImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InitialImpl extends ENamedElementImpl implements Initial {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InitialImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IdlPackage.Literals.INITIAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getIncomings() {
		if (incomings == null) {
			incomings = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, IdlPackage.INITIAL__INCOMINGS, IdlPackage.EDGE__TARGET);
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
			outgoings = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, IdlPackage.INITIAL__OUTGOINGS, IdlPackage.EDGE__SOURCE);
		}
		return outgoings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choreography getOwner() {
		if (eContainerFeatureID() != IdlPackage.INITIAL__OWNER) return null;
		return (Choreography)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Choreography newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, IdlPackage.INITIAL__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Choreography newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != IdlPackage.INITIAL__OWNER && newOwner != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.INITIAL__OWNER, newOwner, newOwner));
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
			case IdlPackage.INITIAL__INCOMINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomings()).basicAdd(otherEnd, msgs);
			case IdlPackage.INITIAL__OUTGOINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoings()).basicAdd(otherEnd, msgs);
			case IdlPackage.INITIAL__OWNER:
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
			case IdlPackage.INITIAL__INCOMINGS:
				return ((InternalEList<?>)getIncomings()).basicRemove(otherEnd, msgs);
			case IdlPackage.INITIAL__OUTGOINGS:
				return ((InternalEList<?>)getOutgoings()).basicRemove(otherEnd, msgs);
			case IdlPackage.INITIAL__OWNER:
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
			case IdlPackage.INITIAL__OWNER:
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
			case IdlPackage.INITIAL__INCOMINGS:
				return getIncomings();
			case IdlPackage.INITIAL__OUTGOINGS:
				return getOutgoings();
			case IdlPackage.INITIAL__OWNER:
				return getOwner();
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
			case IdlPackage.INITIAL__INCOMINGS:
				getIncomings().clear();
				getIncomings().addAll((Collection<? extends Edge>)newValue);
				return;
			case IdlPackage.INITIAL__OUTGOINGS:
				getOutgoings().clear();
				getOutgoings().addAll((Collection<? extends Edge>)newValue);
				return;
			case IdlPackage.INITIAL__OWNER:
				setOwner((Choreography)newValue);
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
			case IdlPackage.INITIAL__INCOMINGS:
				getIncomings().clear();
				return;
			case IdlPackage.INITIAL__OUTGOINGS:
				getOutgoings().clear();
				return;
			case IdlPackage.INITIAL__OWNER:
				setOwner((Choreography)null);
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
			case IdlPackage.INITIAL__INCOMINGS:
				return incomings != null && !incomings.isEmpty();
			case IdlPackage.INITIAL__OUTGOINGS:
				return outgoings != null && !outgoings.isEmpty();
			case IdlPackage.INITIAL__OWNER:
				return getOwner() != null;
		}
		return super.eIsSet(featureID);
	}

} //InitialImpl
