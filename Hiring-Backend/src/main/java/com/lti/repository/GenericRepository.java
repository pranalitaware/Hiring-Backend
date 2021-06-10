package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericRepository { 

	@PersistenceContext
	public EntityManager entityManager;
	
	public Object save(Object obj) {
		Object updatedObj = entityManager.merge(obj);//creates and return the pk
		return updatedObj;
		
	}
	
	public <E> E find(Class<E> clazz , Object pk) {
		E e =entityManager.find(clazz, pk);
		return e;
	}
}
