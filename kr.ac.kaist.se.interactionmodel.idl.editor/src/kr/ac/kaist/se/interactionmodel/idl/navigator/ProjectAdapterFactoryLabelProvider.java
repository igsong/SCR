package kr.ac.kaist.se.interactionmodel.idl.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class ProjectAdapterFactoryLabelProvider extends AdapterFactoryLabelProvider{
 
  public ProjectAdapterFactoryLabelProvider(){
    super(ProjectAdapterFactoryProvider.getAdapterFactory());
  }
 
  /**
   * Returns the platform icon for a file. You can replace with your own icon
   * If not a IFile, then passes to the regular EMF.Edit providers 
   */
  public Image getImage(Object object) {
    if (object instanceof IFile)
      return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
    return super.getImage(object);
  }
 
  public String getText(Object object) {
    if (object instanceof IFile)
      return ((IFile)object).getName();
    return super.getText(object);
  }
}