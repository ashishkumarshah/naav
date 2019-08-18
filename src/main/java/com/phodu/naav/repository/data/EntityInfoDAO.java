package com.phodu.naav.repository.data;

import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.phodu.naav.core.EntityInfo;
public class EntityInfoDAO {
	private EntityManager em = EntityManagerUtil.getEntityManager();


	public EntityInfo load(String entityType) {
		return em.find(EntityInfo.class, entityType);
	}
	
	public void create(EntityInfo entityInfo) {
		executeInsideTransaction(entityManager -> entityManager.persist(entityInfo));
	}

	public EntityInfo update(EntityInfo entity) {
		String entityType = entity.getType();
		executeInsideTransaction(entityManager -> entityManager.merge(entity));
		return load(entityType);
	}

	public void delete(String entityType) {
		EntityInfo entity = load(entityType);
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
