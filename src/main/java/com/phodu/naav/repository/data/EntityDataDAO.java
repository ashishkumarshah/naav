package com.phodu.naav.repository.data;

import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.phodu.naav.core.EntityData;

public class EntityDataDAO {
	private EntityManager em = EntityManagerUtil.getEntityManager();
	

	public EntityData load(long id) {
		return em.find(EntityData.class, id);
	}

	
	public void create(EntityData entity) {
		executeInsideTransaction(entityManager -> entityManager.persist(entity));
		
	}

	
	public EntityData update(EntityData entity) {
		long id = entity.getId();
		executeInsideTransaction(entityManager -> entityManager.merge(entity));
		return load(id);
	}

	
	public void delete(EntityData entity) {
		executeInsideTransaction(entityManager -> entityManager.remove(entity));
		
	}
	
	private void executeInsideTransaction(Consumer<EntityManager> action) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			action.accept(em);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
	}

}
