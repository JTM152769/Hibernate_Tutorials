package com.amitsa.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author Amit Kumar Sah
 */
public class HibernateUtil {
	
	/**
	 * Specialization of the {@link org.hibernate.service.ServiceRegistry} contract mainly for type safety.
	 */
  private static StandardServiceRegistry standardServiceRegistry;
  private static SessionFactory sessionFactory;

  static{
	    if (sessionFactory == null) {
	      try {
	        // Create StandardServiceRegistry
	        standardServiceRegistry = new StandardServiceRegistryBuilder()
	            .configure()
	            .build();
	        // Create MetadataSources using specified service registery
	        MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);	       
	    	/**
	    	 * Get a builder for metadata where non-default options can be specified.
	    	 *
	    	 * @return The built metadata.
	    	 */
	        Metadata metadata = metadataSources.getMetadataBuilder().build();
	        /**
	         * Create SessionFactory
	    	 * Get the builder for {@link org.hibernate.SessionFactory} instances based on this metamodel,
	    	 *
	    	 * @return The builder for {@link org.hibernate.SessionFactory} instances.
	    	 */
	       
	        sessionFactory = metadata.getSessionFactoryBuilder().build();
	      } catch (Exception e) {
	        e.printStackTrace();
	        if (standardServiceRegistry != null) {
	          StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
	        }
	      }
	    }
  }
  
  //Utility method to return SessionFactory
  public static SessionFactory getSessionFactory() {
	  return sessionFactory;
  }
}