package kr.ac.kaist.se.interactionmodel.idl.diagram.features.interaction;

import kr.ac.kaist.se.interaction.idl.Choreography;
import kr.ac.kaist.se.interaction.idl.IdlFactory;
import kr.ac.kaist.se.interaction.idl.Interaction;
import kr.ac.kaist.se.interaction.idl.Participant;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class InteractionModifyFeature extends AbstractCustomFeature {

	public InteractionModifyFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAvailable(IContext context) {
		boolean ret = false;
		if( context instanceof ICustomContext )
		{
			PictogramElement[] pes = ((ICustomContext) context).getPictogramElements();
			if (pes != null && pes.length == 1) {
				Object bo = getBusinessObjectForPictogramElement(pes[0]);
				if (bo instanceof Interaction) {
					ret = true;
				}
			}
		}
		return ret;
	}

	@Override
	public String getName() {
		return "Change Interaction";
	}

	@Override
	public String getDescription() {
		return "Change properties of the interaction";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Interaction) {
				ret = true;
			}
		}
		return ret;
	}
	private static Shell getShell() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	}
	
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		
	   	Choreography chor = null;
    	for( EObject obj: getDiagram().eResource().getContents() )
    	{
    		if( obj instanceof Choreography )
    		{
    			chor = (Choreography) obj;
    		}
    	}
    	
    	if( chor == null )
    	{
    		return;
    	}
        
		
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Interaction) {
				Interaction interaction = (Interaction) bo;
				String currentName = interaction.getName();
				Participant currentSender = interaction.getSender();
				Participant currentReceiver = interaction.getReceiver().isEmpty() ? null : interaction.getReceiver().get(0);
				
				changeInteraction(chor, interaction, currentName, currentSender, currentReceiver);
			}
		}
	}
	
	
	
	public static void changeInteraction(Choreography choreography, Interaction interaction, String curName, Participant curSender, Participant curReceiver) {
		Shell shell = getShell();
		InteractionInputDialog inputDialog = new InteractionInputDialog(shell, choreography, curName, curSender, curReceiver);
		int retDialog = inputDialog.open();
		if (retDialog == Window.OK) {
			String interactionName = inputDialog.getInteractionName();
			Participant sender = inputDialog.getSender();
			Participant receiver = inputDialog.getReceiver();
			if (interactionName == null || interactionName.trim().length() == 0 || sender == null 
					|| receiver == null) {
				return;
			}
			
			interaction.setName(interactionName);
			interaction.setSender(sender);
			interaction.getReceiver().clear();
			interaction.getReceiver().add(receiver);
		}
	}
}
