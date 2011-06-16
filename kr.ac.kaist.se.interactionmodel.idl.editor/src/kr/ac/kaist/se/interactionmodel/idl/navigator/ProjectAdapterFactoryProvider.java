package kr.ac.kaist.se.interactionmodel.idl.navigator;

import java.util.ArrayList;
import java.util.List;

import kr.ac.kaist.se.interaction.idl.provider.IdlItemProviderAdapterFactory;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

public final class ProjectAdapterFactoryProvider {
	  private static ComposedAdapterFactory adapterFactory;
	  
	  public final static List<AdapterFactory> createFactoryList(){
	    List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
	    // this is my provider generated in the .Edit plugin for me. Replace with yours.
	    factories.add(new IdlItemProviderAdapterFactory());
	    // these are EMF generic providers
	    factories.add(new EcoreItemProviderAdapterFactory());
	    factories.add(new ResourceItemProviderAdapterFactory());
	    factories.add(new ReflectiveItemProviderAdapterFactory());
	    return factories;
	  }
	 
	  public final static ComposedAdapterFactory getAdapterFactory(){
	    if (adapterFactory == null) 
	      adapterFactory = new ComposedAdapterFactory(createFactoryList());
	    return adapterFactory;
	  }
}
