package com.phodu.naav.manage;

import java.util.HashMap;
import java.util.Map;

import com.phodu.naav.core.ColumnType;
import com.phodu.naav.core.EntityInfo;
import com.phodu.naav.repository.EntityInfoRepository;

/**
 * This class is used to manage the entity info
 * 
 * @author ashish
 *
 */
public class EntityInfoService {
	private EntityInfoRepository entityInfoRepository = new EntityInfoRepository();

	/**
	 * Function to create an entity
	 * 
	 * @param entityName
	 * @param columnNameTypeMapping
	 * @return
	 */
	public void createEntity(String entityName, Map<String, ColumnType> columnNameTypeMapping) {
		Map<String, String> entityColumnMapping = new HashMap<String, String>();
		int integerCount = 0;
		int stringCount = 0;
		for (String columnName : columnNameTypeMapping.keySet()) {
			ColumnType type = columnNameTypeMapping.get(columnName);
			int index = 0;
			if (type == ColumnType.Integer) {
				index = integerCount;
				integerCount++;
			} else if (type == ColumnType.String) {
				index = stringCount;
				stringCount++;
			}
			String columnMapping = String.format("%s:%d", type.toString(), index + 1);
			entityColumnMapping.put(columnName, columnMapping);
		}
		EntityInfo entityInfo = new EntityInfo(entityName, entityColumnMapping);
		entityInfoRepository.persist(entityInfo);
	}

	/**
	 * Function to load the entity's column mapping
	 * 
	 * @param entityName Name of the entity
	 * @return the Entity Info
	 */
	public Map<String, String> getColumnMapping(String entityName) {
		EntityInfo entityInfo = entityInfoRepository.load(entityName);
		if (entityInfo != null) {
			return entityInfo.getColumnMapping();
		}
		return null;
	}

	public Map<String, ColumnType> getEntityMetadata(String entity) {
		throw new UnsupportedOperationException();
	}

	/**
	 * This function is used to delete the entity metadata
	 * 
	 * @param entityName Name of the entity to remove
	 */
	public void removeEntity(String entity) {
		entityInfoRepository.remove(entity);
	}

}
