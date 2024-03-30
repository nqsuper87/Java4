package com.fpoly.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class JPAUtils {
	private static EntityManagerFactory factory;
	static public EntityManager getEntityManager() {
		if(factory == null && !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("PolyOE");
		}
		return factory.createEntityManager();
	}
	
	static public void shutdown() {
		if(factory != null && factory.isOpen()) {
			factory.close();
		}
		factory = null;
	}
}
