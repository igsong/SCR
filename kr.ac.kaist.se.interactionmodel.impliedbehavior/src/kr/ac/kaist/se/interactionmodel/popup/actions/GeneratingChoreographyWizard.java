package kr.ac.kaist.se.interactionmodel.popup.actions;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import kr.ac.kaist.se.interaction.idl.Choreography;
import kr.ac.kaist.se.interactionmodel.impliedbehavior.Choreography2Diagram;
import kr.ac.kaist.se.interactionmodel.impliedbehavior.LoopUnroller;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramsFactory;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.graphiti.ui.services.IExtensionManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;


public class GeneratingChoreographyWizard extends Wizard {

	/**
	 * @generated
	 */
	private TransactionalEditingDomain myEditingDomain;
	private Combo combo;
	/**
	 * @generated
	 */
	private WizardNewFileCreationPage myFileCreationPage;

	/**
	 * @generated
	 */
	private List<IFile>  mySelectedModelFileList;

	/**
	 * @generated
	 */
	private IWorkbenchPage myWorkbenchPage;

	/**
	 * @generated
	 */
	private IStructuredSelection mySelection;


	private Choreography chor;
	private Diagram oldDiagram;
	/**
	 * @generated
	 */
	public GeneratingChoreographyWizard(List<IFile> selectedModelFileList,
			IWorkbenchPage workbenchPage, IStructuredSelection selection,
			TransactionalEditingDomain editingDomain, Diagram oldDiagram, Choreography chor) {
		assert selectedModelFileList != null : "Null selectedModelFile in CFGPartitioningWizard constructor"; //$NON-NLS-1$
		assert workbenchPage != null : "Null workbenchPage in CFGPartitioningWizard constructor"; //$NON-NLS-1$
		assert selection != null : "Null selection in CFGPartitioningWizard constructor"; //$NON-NLS-1$
		assert editingDomain != null : "Null editingDomain in CFGPartitioningWizard constructor"; //$NON-NLS-1$

		mySelectedModelFileList = selectedModelFileList;
		myWorkbenchPage = workbenchPage;
		mySelection = selection;
		myEditingDomain = editingDomain;
		this.oldDiagram = oldDiagram;
		this.chor = chor;
	}

	/**
	 * @generated
	 */
	public void addPages() {
		myFileCreationPage =  new WizardNewFileCreationPage("Creating new unrolled diagram",  mySelection)
		 {

			public void createControl(Composite parent) {
				super.createControl(parent);

				IContainer parentContainer = mySelectedModelFileList.get(0).getParent();
				String originalFileName = "default_unrolled_diagram";
				String fileExtension = ".diagram"; //$NON-NLS-1$
				String fileName = originalFileName + fileExtension;
				for (int i = 1; parentContainer.getFile(new Path(fileName))
				.exists(); i++) {
					fileName = originalFileName + i + fileExtension;
				}
				setFileName(fileName);
			}

		 };
		 myFileCreationPage.setTitle("New unrolled choreography file");
		 myFileCreationPage.setDescription("Creating unrolled choreography file");
		 addPage(myFileCreationPage);
	}

	/**
	 * @generated
	 */

	public boolean performFinish() {
		final IFile chorFile = myFileCreationPage.createNewFile();
		try {
			chorFile.setCharset("UTF-8", new NullProgressMonitor()); //$NON-NLS-1$
		} catch (CoreException e) {
			e.printStackTrace();
			System.err.println("UTF-8 error");
		}
		List affectedFiles = new LinkedList();
		affectedFiles.add(chorFile);
		

		ResourceSet resourceSet = myEditingDomain.getResourceSet();
		final Resource chorResource = resourceSet
				.createResource(URI.createPlatformResourceURI(chorFile
						.getFullPath().toString(), true));

		AbstractTransactionalCommand command = new AbstractTransactionalCommand(
				myEditingDomain, "Unrolling choreography", affectedFiles) { //$NON-NLS-1$
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				
				Choreography newChor = LoopUnroller.INSTANCE.unroll(chor);
				Diagram diagram = GraphitiUi.getPeService().createDiagram(
						oldDiagram.getDiagramTypeId(), oldDiagram.getName(), 
						oldDiagram.getGridUnit(), oldDiagram.isSnapToGrid());
				chorResource.getContents().add(diagram);
				
				Choreography2Diagram.drawChoreography2Diagram(newChor, diagram);
				
				try {
					chorResource.save(null);
				} catch (IOException e) {
					return CommandResult.newErrorCommandResult("save failed");
				}
				
				return CommandResult.newOKCommandResult();
			}
		};

		try {
			OperationHistoryFactory.getOperationHistory().execute(command,
					new NullProgressMonitor(), null);
			this.mySelectedModelFileList.get(0).getProject().refreshLocal(2,
					new NullProgressMonitor());
			// IDE.openEditor(myWorkbenchPage, umlFile);
		} catch (ExecutionException e) {
			e.printStackTrace();
			System.err.println(
					"Unable to create model and diagram"); //$NON-NLS-1$
			return false;
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}