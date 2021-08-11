package com.example.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.example.jpa.entity.T1;
import com.example.jpa.entity.T1Access;
import com.example.jpa.factory.TestEntityManagerFactory;

public class JpaMain {

	private static final String UNIT_NAME = "eclipselink_production";

	public static void main(String[] args) {
		EntityManager em = TestEntityManagerFactory.getEntityManager(UNIT_NAME);
		EntityTransaction et = em.getTransaction();

		T1Access instance = new T1Access();

		et.begin();
		T1 t1 = new T1();
		t1.setId(1);
		t1.setName("hoge");
		T1 t2 = new T1();
		t2.setId(2);
		t2.setName("uga");
		T1 t3 = new T1();
		t3.setId(3);
		t3.setName("oro");
		instance.persist(em, t1);
		instance.persist(em, t2);
		instance.persist(em, t3);
		et.commit();

		System.out.println("----- find -----");
		T1 res = instance.find(em, 1);
		System.out.println(res.getId() + ":" + res.getName());

		System.out.println("----- findAll -----");
		for (T1 t : instance.findAll(em)) {
			System.out.println(t.getId() + ":" + t.getName());
		}

		et.begin();
		instance.remove(em, t2);
		et.commit();

		System.out.println("----- findAll(after remove) -----");
		for (T1 t : instance.findAll(em)) {
			System.out.println(t.getId() + ":" + t.getName());
		}
	}
}
