package com.phodu.naav.manage;

import java.util.HashMap;
import java.util.Map;

public class DataAccessService {
	private EntityInfoService entityInfoService;
	private EntityDataService entityDataService;
	
	public DataAccessService() {
		entityInfoService = new EntityInfoService();
		entityDataService = new EntityDataService();
	}
	
	public Map<String,Object> getEntityRecord(String entity, long id) {
		Map<String, Object> rawEntityData = entityDataService.getEntityData(id);
		Map<String, String> columnMapping = entityInfoService.getColumnMapping(entity);
		Map<String, Object> processedEntityData = new HashMap<String, Object>();
		for(String column : columnMapping.keySet()) {
			String dbAlias = columnMapping.get(column);
			Object value = rawEntityData.get(dbAlias);
			processedEntityData.put(column, value);
		}
		return processedEntityData;
	}
	
	public void updateEntityRecord(long id, String entity, Map<String, Object> entityData) {
		throw new UnsupportedOperationException();
	}
	
	public long createEntityRecord(String entity, Map<String, Object> entityData) {
		Map<String, String> columnMapping = entityInfoService.getColumnMapping(entity);
		Map<String, Object> rawEntityData = new HashMap<String, Object>();
		for(String column : columnMapping.keySet()) {
			String dbAlias = columnMapping.get(column);
			rawEntityData.put(dbAlias, entityData.get(column));
		}
		return entityDataService.addEntityData(entity, rawEntityData);
	}
	
	public void deleteEntityRecord(long id) {
		throw new UnsupportedOperationException();
	}
}

