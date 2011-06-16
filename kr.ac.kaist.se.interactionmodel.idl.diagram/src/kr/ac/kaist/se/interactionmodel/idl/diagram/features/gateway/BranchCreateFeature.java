package kr.ac.kaist.se.interactionmodel.idl.diagram.features.gateway;

import kr.ac.kaist.se.interaction.idl.Branch;
import kr.ac.kaist.se.interaction.idl.Choreography;
import kr.ac.kaist.se.interaction.idl.IdlFactory;
import kr.ac.kaist.se.interaction.idl.Interaction;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
public class BranchCreateFeature extends AbstractCreateFeature {
 
    public BranchCreateFeature(IFeatureProvider fp) {
        // set name and description of the creation feature
        super(fp, "Branch", "Create Branch");
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
        
        
    	Branch branch = createInteraction(chor);
        
        // do the add
        addGraphicalRepresentation(context, branch);
 
        // return newly created business object(s)
        return new Object[] { branch };
    }
	/**
	 * Returns the currently active Shell.
	 * 
	 * @return The currently active Shell.
	 */
	private static Shell getShell() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	}
	
    
	public static Branch createInteraction(Choreography choreography) {
		Branch ret = null;
		ret = IdlFactory.eINSTANCE.createBranch();
		choreography.getNodes().add(ret);
		return ret;
	}
}