package com.phodu.naav.manage;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;

import com.phodu.naav.core.ColumnType;

public class TestEntityInfoService {
	@Test
	public void test() {
		EntityInfoService entityInfoService = new EntityInfoService();
		Map <String, ColumnType> columnMetadata = new HashMap<String, ColumnType>();
		columnMetadata.put("integerColumn1", ColumnType.Integer);
		columnMetadata.put("integerColumn2", ColumnType.Integer);
		columnMetadata.put("stringColumn1", ColumnType.String);
		
		String randomName = UUID.randomUUID().toString();
		entityInfoService.createEntity(randomName, columnMetadata);
		
		Map<String, String> columnMapping = entityInfoService.getColumnMapping(randomName);
		assertTrue(columnMapping.containsKey("integerColumn1"));
		assertTrue(columnMapping.containsKey("integerColumn2"));
		assertTrue(columnMapping.containsKey("stringColumn1"));
		assertEquals("The size of the columns must be 3", 3, columnMapping.keySet().size());
		assertEquals(ColumnType.Integer.toString()+":1", columnMapping.get("integerColumn1"));
		assertEquals(ColumnType.Integer.toString()+":2", columnMapping.get("integerColumn2"));
		assertEquals(ColumnType.String.toString()+":1", columnMapping.get("stringColumn1"));
		
		entityInfoService.removeEntity(randomName);
		
		columnMapping = entityInfoService.getColumnMapping(randomName);
		assertNull(columnMapping);
	}
}
