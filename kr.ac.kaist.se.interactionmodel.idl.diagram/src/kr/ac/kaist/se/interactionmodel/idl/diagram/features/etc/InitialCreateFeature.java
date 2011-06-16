package kr.ac.kaist.se.interactionmodel.idl.diagram.features.etc;

import kr.ac.kaist.se.interaction.idl.Choreography;
import kr.ac.kaist.se.interaction.idl.IdlFactory;
import kr.ac.kaist.se.interaction.idl.Initial;
import kr.ac.kaist.se.interaction.idl.Join;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
public class InitialCreateFeature extends AbstractCreateFeature {
 
    public InitialCreateFeature(IFeatureProvider fp) {
        // set name and description of the creation feature
        super(fp, "Initial", "Create Initial");
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
        
        
    	Initial initial = createInitial(chor);
        
        // do the add
        addGraphicalRepresentation(context, initial);
 
        // return newly created business object(s)
        return new Object[] { initial };
    }
	/**
	 * Returns the currently active Shell.
	 * 
	 * @return The currently active Shell.
	 */
	private static Shell getShell() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	}
	
    
	public Initial createInitial(Choreography choreography) {
		Initial ret = null;
		ret = IdlFactory.eINSTANCE.createInitial();
		choreography.getNodes().add(ret);
		return ret;
	}
}