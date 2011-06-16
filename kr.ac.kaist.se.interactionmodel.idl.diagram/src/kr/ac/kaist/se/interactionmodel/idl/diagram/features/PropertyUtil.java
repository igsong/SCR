package kr.ac.kaist.se.interactionmodel.idl.diagram.features;

import kr.ac.kaist.se.interaction.idl.GatewayType;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

public class PropertyUtil {
 
    public static final void setSenderShape(PictogramElement pe) {
        Graphiti.getPeService().setPropertyValue(pe, "INTERACTION-CHILD-TYPE",
            "SENDER");
    }
 
    public static boolean isSenderShape(PictogramElement pe) {
        return "SENDER".equals(Graphiti.getPeService()
           .getPropertyValue(pe, "INTERACTION-CHILD-TYPE"));
    }
    
    public static final void setReceiverShape(PictogramElement pe) {
        Graphiti.getPeService().setPropertyValue(pe, "INTERACTION-CHILD-TYPE",
            "RECEIVER");
    }
 
    public static boolean isReceiverShape(PictogramElement pe) {
        return "RECEIVER".equals(Graphiti.getPeService()
           .getPropertyValue(pe, "INTERACTION-CHILD-TYPE"));
    }
    
    public static final void setInteractionNameShape(PictogramElement pe) {
        Graphiti.getPeService().setPropertyValue(pe, "INTERACTION-CHILD-TYPE",
            "INTERACTION-NAME");
    }
 
    public static boolean isInteractionNameShape(PictogramElement pe) {
        return "INTERACTION-NAME".equals(Graphiti.getPeService()
           .getPropertyValue(pe, "INTERACTION-CHILD-TYPE"));
    }
    
    public static final void setLine1Shape(PictogramElement pe) {
        Graphiti.getPeService().setPropertyValue(pe, "INTERACTION-CHILD-TYPE",
            "LINE1");
    }
 
    public static boolean isLine1Shape(PictogramElement pe) {
        return "LINE1".equals(Graphiti.getPeService()
           .getPropertyValue(pe, "INTERACTION-CHILD-TYPE"));
    }
    
    public static final void setLine2Shape(PictogramElement pe) {
        Graphiti.getPeService().setPropertyValue(pe, "INTERACTION-CHILD-TYPE",
            "LINE2");
    }
 
    public static boolean isLine2Shape(PictogramElement pe) {
        return "LINE2".equals(Graphiti.getPeService()
           .getPropertyValue(pe, "INTERACTION-CHILD-TYPE"));
    }
    
    public static final void setReceiverBackgroundShape(PictogramElement pe) {
        Graphiti.getPeService().setPropertyValue(pe, "INTERACTION-CHILD-TYPE",
            "RECV-BACKGROUND");
    }
 
    public static boolean isReceiverBackgroundShape(PictogramElement pe) {
        return "RECV-BACKGROUND".equals(Graphiti.getPeService()
           .getPropertyValue(pe, "INTERACTION-CHILD-TYPE"));
    }
    
    public static final void setGatewayType(PictogramElement pe, GatewayType type )
    {
    	Graphiti.getPeService().setPropertyValue(pe, "GATEWAY-TYPE", type.getLiteral());
    }
    
    public static GatewayType getGatewayType(PictogramElement pe)
    {
    	return GatewayType.get(Graphiti.getPeService().getPropertyValue(pe, "GATEWAY-TYPE"));
    }
}