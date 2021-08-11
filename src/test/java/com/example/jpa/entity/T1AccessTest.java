package com.example.jpa.entity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.jpa.factory.TestEntityManagerFactory;

public class T1AccessTest {

	private static final String UNIT_NAME = "eclipselink_testing";
	private EntityManager em;

	@Before
	public void setUp() throws Exception {
		em = TestEntityManagerFactory.getEntityManager(UNIT_NAME);
	}

	@After
	public void tearDown() throws Exception {
		em.close();
	}

	@Test
	public void testFind() {
		T1Access a = new T1Access();
		T1 t1 = a.find(em, 1);
		assertThat(t1.getId(), is(1));
		assertThat(t1.getName(), is("hoge"));
	}

	@Test
	public void testPersist() {
		T1 t = new T1();
		t.setId(10);
		t.setName("aaa");
		T1Access a = new T1Access();
		a.persist(em, t);

		T1 tt = a.find(em, 10);
		assertThat(tt.getId(), is(10));
		assertThat(tt.getName(), is("aaa"));
	}

	@Test(expected = EntityNotFoundException.class)
	public void testRemove() {
		T1 t = new T1();
		t.setId(10);
		t.setName("aaa");
		T1Access a = new T1Access();
		a.remove(em, t);

		a.find(em, 10);
	}
}
