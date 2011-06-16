package kr.ac.kaist.se.interactionmodel.idl.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

public class ProjectAdapterFactoryContentProvider extends AdapterFactoryContentProvider {
 
  private static ResourceSet resourceSet = new ResourceSetImpl();
  
  public ProjectAdapterFactoryContentProvider(){
    super(ProjectAdapterFactoryProvider.getAdapterFactory());
  }
 
  public boolean hasChildren(Object object){
    if (object instanceof IFile)
      return true;
    return super.hasChildren(object);
  }
 
  public Object[] getChildren(Object object){
    if (object instanceof IFile){
      String path = ((IFile)object).getFullPath().toString();
      @SuppressWarnings("deprecation")
	URI uri = URI.createPlatformResourceURI(path);
      object = resourceSet.getResource(uri, true);
    }
    return super.getChildren(object); 
  }	
 
  public Object getParent(Object object){
    if (object instanceof IFile)
      return ((IResource)object).getParent();
    return super.getParent(object);
  }
 
  public Object[] getElements(Object object){
    if (object instanceof IFile){
      String path = ((IFile)object).getFullPath().toString();
      @SuppressWarnings("deprecation")
	URI uri = URI.createPlatformResourceURI(path);
      object = resourceSet.getResource(uri, true);
    }
    return super.getElements(object); 
  }
}
