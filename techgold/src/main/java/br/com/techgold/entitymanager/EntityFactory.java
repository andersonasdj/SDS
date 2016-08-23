package br.com.techgold.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityFactory {
	private static EntityManagerFactory factory = null;
	
	static {
		try {
			factory = Persistence.createEntityManagerFactory("techgold");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	public static EntityManager getEntityManager(){
		return factory.createEntityManager();
	}
}