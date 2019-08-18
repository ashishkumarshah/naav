package com.phodu.naav.repository;

import com.phodu.naav.core.EntityInfo;
import com.phodu.naav.repository.data.EntityInfoDAO;

public class EntityInfoRepository {
	private EntityInfoDAO dao;
	
	public EntityInfoRepository() {
		dao = new EntityInfoDAO();
	}

	public void persist(EntityInfo entityInfo) {
		dao.create(entityInfo);
	}

	public EntityInfo load(String entityType) {
		return dao.load(entityType);
	}

	public void remove(String entity) {
		dao.delete(entity);
	}

}
