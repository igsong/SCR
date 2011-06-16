/**
 * <copyright>
 * </copyright>
 *
 * $Id: ChoreographyItemProvider.java,v 1.1 2011-02-21 04:16:10 igsong Exp $
 */
package kr.ac.kaist.se.interaction.idl.provider;


import java.util.Collection;
import java.util.List;

import kr.ac.kaist.se.interaction.idl.Choreography;
import kr.ac.kaist.se.interaction.idl.IdlFactory;
import kr.ac.kaist.se.interaction.idl.IdlPackage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.provider.EPackageItemProvider;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link kr.ac.kaist.se.interaction.idl.Choreography} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ChoreographyItemProvider
	extends EPackageItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChoreographyItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(IdlPackage.Literals.CHOREOGRAPHY__NODES);
			childrenFeatures.add(IdlPackage.Literals.CHOREOGRAPHY__EDGES);
			childrenFeatures.add(IdlPackage.Literals.CHOREOGRAPHY__PARTICIPANTS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Choreography.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Choreography"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Choreography)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Choreography_type") :
			getString("_UI_Choreography_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Choreography.class)) {
			case IdlPackage.CHOREOGRAPHY__NODES:
			case IdlPackage.CHOREOGRAPHY__EDGES:
			case IdlPackage.CHOREOGRAPHY__PARTICIPANTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ESUBPACKAGES,
				 IdlFactory.eINSTANCE.createChoreography()));

		newChildDescriptors.add
			(createChildParameter
				(IdlPackage.Literals.CHOREOGRAPHY__NODES,
				 IdlFactory.eINSTANCE.createInteraction()));

		newChildDescriptors.add
			(createChildParameter
				(IdlPackage.Literals.CHOREOGRAPHY__NODES,
				 IdlFactory.eINSTANCE.createBranch()));

		newChildDescriptors.add
			(createChildParameter
				(IdlPackage.Literals.CHOREOGRAPHY__NODES,
				 IdlFactory.eINSTANCE.createJoin()));

		newChildDescriptors.add
			(createChildParameter
				(IdlPackage.Literals.CHOREOGRAPHY__NODES,
				 IdlFactory.eINSTANCE.createInitial()));

		newChildDescriptors.add
			(createChildParameter
				(IdlPackage.Literals.CHOREOGRAPHY__NODES,
				 IdlFactory.eINSTANCE.createFinal()));

		newChildDescriptors.add
			(createChildParameter
				(IdlPackage.Literals.CHOREOGRAPHY__EDGES,
				 IdlFactory.eINSTANCE.createSequenceFlow()));

		newChildDescriptors.add
			(createChildParameter
				(IdlPackage.Literals.CHOREOGRAPHY__PARTICIPANTS,
				 IdlFactory.eINSTANCE.createParticipant()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return IdlEditPlugin.INSTANCE;
	}

}
