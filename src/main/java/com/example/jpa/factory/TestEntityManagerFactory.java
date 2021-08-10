package com.example.jpa.factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestEntityManagerFactory {

	public static EntityManagerFactory getEMFactory() {
		return Persistence.createEntityManagerFactory("eclipselink_sample");
	}
}
