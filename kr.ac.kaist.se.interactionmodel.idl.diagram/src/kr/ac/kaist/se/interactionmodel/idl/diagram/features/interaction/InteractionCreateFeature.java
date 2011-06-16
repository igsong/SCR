package kr.ac.kaist.se.interactionmodel.idl.diagram.features.interaction;

import kr.ac.kaist.se.interaction.idl.Choreography;
import kr.ac.kaist.se.interaction.idl.IdlFactory;
import kr.ac.kaist.se.interaction.idl.Interaction;
import kr.ac.kaist.se.interaction.idl.Participant;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
public class InteractionCreateFeature extends AbstractCreateFeature {
 
    public InteractionCreateFeature(IFeatureProvider fp) {
        // set name and description of the creation feature
        super(fp, "Interaction", "Create Interaction");
    }
 
    public boolean canCreate(ICreateContext context) {
        return context.getTargetContainer() instanceof Diagram;
    }
 
    public Object[] create(ICreateContext context) {
    	
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
    		chor = IdlFactory.eINSTANCE.createChoreography();
    		getDiagram().eResource().getContents().add(chor);
    	}
        
        
        Interaction interaction = createInteraction(chor);
        
        // do the add
        addGraphicalRepresentation(context, interaction);
 
        // return newly created business object(s)
        return new Object[] { interaction };
    }
	/**
	 * Returns the currently active Shell.
	 * 
	 * @return The currently active Shell.
	 */
	private static Shell getShell() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	}
	
    
	public static Interaction createInteraction(Choreography choreography) {
		Interaction ret = null;
		Shell shell = getShell();
		InteractionInputDialog inputDialog = new InteractionInputDialog(shell, choreography);
		int retDialog = inputDialog.open();
		if (retDialog == Window.OK) {
			String interactionName = inputDialog.getInteractionName();
			Participant sender = inputDialog.getSender();
			Participant receiver = inputDialog.getReceiver();
			if (interactionName == null || interactionName.trim().length() == 0 || sender == null 
					|| receiver == null) {
				return null;
			}
			
			ret = IdlFactory.eINSTANCE.createInteraction();
			choreography.getNodes().add(ret);
			ret.setName(interactionName);
			ret.setSender(sender);
			ret.getReceiver().add(receiver);
		}
		return ret;
	}
}