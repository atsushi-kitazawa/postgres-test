package com.example.jpa.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestEntityManagerFactory {

	public static EntityManager getEntityManager(String unitName) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory(unitName);
		return factory.createEntityManager();
	}
}
