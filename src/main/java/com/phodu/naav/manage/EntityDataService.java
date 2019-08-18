/**
 * 
 */
package com.phodu.naav.manage;

import java.util.HashMap;
import java.util.Map;

import com.phodu.naav.core.ColumnType;
import com.phodu.naav.core.EntityData;
import com.phodu.naav.repository.EntityDataRepository;

/**
 * @author ashish
 *
 */
public class EntityDataService {
	private EntityDataRepository entityDataRepository = new EntityDataRepository();
	/**
	 * This function is used to save an entity's data into the database
	 * @param entityName Name of the entity
	 * @param entityDataMap Map of entity's data
	 * @return id of the saved entity
	 */
	public long addEntityData(String entityName, Map<String, Object> entityDataMap) {
		EntityData entityData = buildEntityData(entityName, entityDataMap);
		entityDataRepository.persist(entityData);
		return entityData.getId();
	}
	
	/**
	 * This function is used to build an EntityData object
	 * @param entityName Name of the entity
	 * @param entityMapping Map of entity's data
	 * @return EntityData object
	 */
	private EntityData buildEntityData(String entityName, Map<String, Object> entityMapping) {
		Integer[] integers = new Integer[10];
		String[] strings = new String[10];
		
		for(String mappingLabel : entityMapping.keySet()) {
			String[] mappingLabelData = mappingLabel.split(":");
			String mappingType = mappingLabelData[0];
			int mappingIndex = Integer.parseInt(mappingLabelData[1]);
			ColumnType type = ColumnType.get(mappingType);
			if(type == ColumnType.String) {
				strings[mappingIndex - 1] = (String) entityMapping.get(mappingLabel);
			} else if (type == ColumnType.Integer) {
				integers[mappingIndex - 1] = (Integer) entityMapping.get(mappingLabel);
			}
		}
		return new EntityData(entityName, integers, strings);
	}

	/**
	 * This function is used to retreive an entity's data corresponding to the given id
	 * @param id id of the entity data
	 * @return Map containing entity's data
	 */
	public Map<String, Object> getEntityData(long id) {
		EntityData entityData = entityDataRepository.load(id);
		return processEntityData(entityData);
	}
	
	/**
	 * This function is used to convert the entity data object to a map
	 * @param entityData Entity Data Object
	 * @return map containing the entity's data
	 */
	private Map<String, Object> processEntityData(EntityData entityData) {
		Map<String, Object> processedEntityData = new HashMap<String, Object>();
		
		processedEntityData.put(ColumnType.Integer.toString()+":1", entityData.getInteger1());
		processedEntityData.put(ColumnType.Integer.toString()+":2", entityData.getInteger2());
		processedEntityData.put(ColumnType.Integer.toString()+":3", entityData.getInteger3());
		processedEntityData.put(ColumnType.Integer.toString()+":4", entityData.getInteger4());
		processedEntityData.put(ColumnType.Integer.toString()+":5", entityData.getInteger5());
		processedEntityData.put(ColumnType.Integer.toString()+":6", entityData.getInteger6());
		processedEntityData.put(ColumnType.Integer.toString()+":7", entityData.getInteger7());
		processedEntityData.put(ColumnType.Integer.toString()+":8", entityData.getInteger8());
		processedEntityData.put(ColumnType.Integer.toString()+":9", entityData.getInteger9());
		processedEntityData.put(ColumnType.Integer.toString()+":10", entityData.getInteger10());
		
		processedEntityData.put(ColumnType.String.toString()+":1", entityData.getString1());
		processedEntityData.put(ColumnType.String.toString()+":2", entityData.getString2());
		processedEntityData.put(ColumnType.String.toString()+":3", entityData.getString3());
		processedEntityData.put(ColumnType.String.toString()+":4", entityData.getString4());
		processedEntityData.put(ColumnType.String.toString()+":5", entityData.getString5());
		processedEntityData.put(ColumnType.String.toString()+":6", entityData.getString6());
		processedEntityData.put(ColumnType.String.toString()+":7", entityData.getString7());
		processedEntityData.put(ColumnType.String.toString()+":8", entityData.getString8());
		processedEntityData.put(ColumnType.String.toString()+":9", entityData.getString9());
		processedEntityData.put(ColumnType.String.toString()+":10", entityData.getString10());
		
		return processedEntityData;
		
	}
	
	public void remove(long id) {
		entityDataRepository.remove(id);
	}
}
