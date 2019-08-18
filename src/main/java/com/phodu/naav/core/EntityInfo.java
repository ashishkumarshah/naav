package com.phodu.naav.core;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This class is used to represent the information of the Entity
 * 
 * @author ashish
 *
 */
@Entity
public class EntityInfo {
	/**
	 * Type of the entity
	 */
	@Id
	private String entityName;
	/*
	 * Mapping of entity's fields to storage aliases
	 */
	private Map<String,String> columnMapping;
	
	public EntityInfo() {
		
	}

	public EntityInfo(String entityName, Map<String, String> columnMapping) {
		this.entityName = entityName;
		this.columnMapping = columnMapping;
	}

	/**
	 * This function returns the type of the entity
	 * 
	 * @return Type of the entity
	 */
	public String getType() {
		return entityName;
	}

	/**
	 * This function sets the type of the entity
	 * 
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.entityName = type;
	}

	/**
	 * This function gets the mapping of the entity
	 * 
	 * @return the column mapping
	 */
	public Map<String,String> getColumnMapping() {
		return columnMapping;
	}

	/**
	 * This function sets the mapping of the field
	 * 
	 * @param columnMapping the column mapping to set
	 */
	public void setFieldMapping(Map<String,String> columnMapping) {
		this.columnMapping = columnMapping;
	}
}
