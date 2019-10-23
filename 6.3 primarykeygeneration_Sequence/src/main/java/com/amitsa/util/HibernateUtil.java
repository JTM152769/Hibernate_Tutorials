package com.amitsa.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amitsa.client.App;

public class HibernateUtil {
	
	private static Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
	
	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
	
	static {
		if (sessionFactory == null) {
			 try {
			        // Create StandardServiceRegistry
			        standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
			        logger.info("Hibernate serviceRegistry created");
			        // Create MetadataSources using specified service registery
			        /**
			         * Entry point into working with sources of metadata information (mapping XML, annotations).   Tell Hibernate
			         * about sources and then call {@link #buildMetadata()}, or use {@link #getMetadataBuilder()} to customize
			         * how sources are processed (naming strategies, etc).
			         */
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
			    	  logger.error("Initial SessionFactory creation failed." + e);			    	
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


