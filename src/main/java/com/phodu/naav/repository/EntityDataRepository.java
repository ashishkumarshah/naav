package com.phodu.naav.repository;

import com.phodu.naav.core.EntityData;
import com.phodu.naav.repository.data.EntityDataDAO;

public class EntityDataRepository {
	private EntityDataDAO dao;
	public EntityDataRepository() {
		dao = new EntityDataDAO();
	}

	public void persist(EntityData entityData) {
		dao.create(entityData);
	}

	public EntityData load(long id) {
		return dao.load(id);
	}
	
	public void remove(long id) {
		EntityData data = load(id);
		dao.delete(data);
	}

}
