package com.example.jpa.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class T1Access {
	public T1 find(EntityManager em, int id) throws EntityNotFoundException {
		T1 ret = em.find(T1.class, id);
		if (ret == null) {
			throw new EntityNotFoundException();
		}
		return ret;
	}

	public void persist(EntityManager em, T1 t) {
		em.persist(t);
	}

	public void remove(EntityManager em, T1 t) {
		em.remove(t);
	}

	public List<T1> findAll(EntityManager em) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T1> cq = cb.createQuery(T1.class);
		CriteriaQuery<T1> select = cq.select(cq.from(T1.class));
		return em.createQuery(select).getResultList();

	}
}
