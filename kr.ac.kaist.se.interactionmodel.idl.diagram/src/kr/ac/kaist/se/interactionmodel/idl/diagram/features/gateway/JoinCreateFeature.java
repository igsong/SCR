package kr.ac.kaist.se.interactionmodel.idl.diagram.features.gateway;

import kr.ac.kaist.se.interaction.idl.Choreography;
import kr.ac.kaist.se.interaction.idl.IdlFactory;
import kr.ac.kaist.se.interaction.idl.Join;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
public class JoinCreateFeature extends AbstractCreateFeature {
 
    public JoinCreateFeature(IFeatureProvider fp) {
        // set name and description of the creation feature
        super(fp, "Join", "Create Join");
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
        
        
    	Join join = createInteraction(chor);
        
        // do the add
        addGraphicalRepresentation(context, join);
 
        // return newly created business object(s)
        return new Object[] { join };
    }
	/**
	 * Returns the currently active Shell.
	 * 
	 * @return The currently active Shell.
	 */
	private static Shell getShell() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	}
	
    
	public Join createInteraction(Choreography choreography) {
		Join ret = null;
		ret = IdlFactory.eINSTANCE.createJoin();
		choreography.getNodes().add(ret);
		return ret;
	}
}