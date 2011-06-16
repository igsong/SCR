package kr.ac.kaist.se.interactionmodel.idl.diagram.features.gateway;

import kr.ac.kaist.se.interaction.idl.Gateway;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextMenuEntry;

public class GatewayToolBehaviorProvider extends DefaultToolBehaviorProvider {
	
	
	
	public GatewayToolBehaviorProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
	}
	 
	private IContextMenuEntry[] gatewayTypeMenu = null;
    @Override
    public IContextMenuEntry[] getContextMenu(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		if ( pes == null || pes.length != 1 || pes[0].getLink() == null || pes[0].getLink().getBusinessObjects() == null ||
				pes[0].getLink().getBusinessObjects().size() != 1 ) return super.getContextMenu(context);
		Object bo = pes[0].getLink().getBusinessObjects().get(0);
		if( !(bo instanceof Gateway) ) return super.getContextMenu(context);
		
		if( gatewayTypeMenu == null )
		{
	        // create a sub-menu for all custom features
	        ContextMenuEntry subMenu = new ContextMenuEntry(null, context);
	        subMenu.setText("Gateway type");
	        subMenu.setDescription("Change type of the gateway");
	
	        // display sub-menu hierarchical or flat
	        subMenu.setSubmenu(true);
	
	        // create a menu-entry in the sub-menu for each custom feature
	        if (context instanceof ICustomContext) {
	            ICustomContext customContext = (ICustomContext) context;
	            ICustomFeature[] customFeatures =
	                getFeatureProvider().getCustomFeatures(customContext);
	            for (int i = 0; i < customFeatures.length; i++) {
	                ICustomFeature customFeature = customFeatures[i];
	                if( customFeature instanceof GatewayTypeChangeFeature )
	                {
	                    ContextMenuEntry menuEntry = new ContextMenuEntry(customFeature, context);
	                    subMenu.add(menuEntry);
	                }
	            }
	        }
	        
	        gatewayTypeMenu = new IContextMenuEntry[] { subMenu };
		}
 
        return gatewayTypeMenu;
    }

 

}
