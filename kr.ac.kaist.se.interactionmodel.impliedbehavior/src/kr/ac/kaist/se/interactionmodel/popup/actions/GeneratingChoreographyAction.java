package kr.ac.kaist.se.interactionmodel.popup.actions;


import java.util.ArrayList;
import java.util.List;

import kr.ac.kaist.se.interaction.idl.Choreography;
import kr.ac.kaist.se.interactionmodel.impliedbehavior.Activator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;


public class GeneratingChoreographyAction implements IObjectActionDelegate {
	/**
	 * @generated
	 */
	private IWorkbenchPart myPart;

	/**
	 * @generated
	 */
	private List<IFile> mySelectedModelFileList;

	/**
	 * @generated
	 */
	private IStructuredSelection mySelection;
	/**
	 * Constructor for Action1.
	 */
	public GeneratingChoreographyAction() {
		super();
		mySelectedModelFileList = new ArrayList<IFile>();
	}

	/**
	 * @generated
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		myPart = targetPart;
	}

	/**
	 * @generated
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		mySelectedModelFileList.clear();
		mySelection = StructuredSelection.EMPTY;
		action.setEnabled(false);
		if (selection instanceof IStructuredSelection == false
				|| selection.isEmpty()) {
			return;
		}
		mySelection = (IStructuredSelection) selection;
		mySelectedModelFileList.addAll(mySelection.toList());
		action.setEnabled(true);
	}

	/**
	 * @generated
	 */
	public void run(IAction action) {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
		ResourceSet resourceSet = editingDomain.getResourceSet();
		if(mySelectedModelFileList.size() == 0 ) return;
		
		IFile file = mySelectedModelFileList.get(0);
		Diagram diagram = null;
		Choreography chor = null;
		try
		{
			Resource resource = resourceSet.getResource(URI
					.createPlatformResourceURI(file
							.getFullPath().toString(), true), true);
			if( resource  == null || resource.getContents().size() == 0 )
			{
				MessageDialog.openError(myPart.getSite().getShell(), "Error",
				"Model file loading failed");
				return;
			}
			
			if( resource.getContents() == null || resource.getContents().size() == 0 )
			{
				MessageDialog.openError(myPart.getSite().getShell(), "Error",
				"Model file loading failed");
				return;
			}
			
			for( Object obj : resource.getContents())
			{
				if( (obj instanceof Diagram) )
				{
					diagram = (Diagram)obj;
				}
				else if( obj instanceof Choreography )
				{
					chor = (Choreography)obj;
				}
			}
			
		} catch (WrappedException ex) {
			System.err.println(
					"Unable to load resource: " + file.getFullPath().toString()); //$NON-NLS-1$
		}

		if( diagram == null )
		{
			MessageDialog.openError(myPart.getSite().getShell(), "Error",
			"Model file loading failed");
			return;
		}

		Wizard wizard = new GeneratingChoreographyWizard(mySelectedModelFileList, myPart
				.getSite().getPage(), mySelection, editingDomain, diagram, chor);
		IDialogSettings pluginDialogSettings = Activator.getDefault().getDialogSettings();
		
		IDialogSettings initDiagramFileSettings = pluginDialogSettings
				.getSection("InisDiagramFile"); //$NON-NLS-1$
		if (initDiagramFileSettings == null) {
			initDiagramFileSettings = pluginDialogSettings
					.addNewSection("InisDiagramFile"); //$NON-NLS-1$
		}
		wizard.setDialogSettings(initDiagramFileSettings);
		wizard.setForcePreviousAndNextButtons(false);
		wizard.setWindowTitle("Detect implied scenarios");

		WizardDialog dialog = new WizardDialog(myPart.getSite().getShell(),
				wizard);
		dialog.create();
		dialog.getShell().setSize(Math.max(500, dialog.getShell().getSize().x),
				600);
		dialog.open();
	}

}
