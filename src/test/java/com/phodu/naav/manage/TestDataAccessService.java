package com.phodu.naav.manage;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;

import com.phodu.naav.core.ColumnType;

public class TestDataAccessService {

	@Test
	public void test() {
		EntityInfoService entityInfoService = new EntityInfoService();
		DataAccessService dataAccessService = new DataAccessService();
		Map <String, ColumnType> columnMetadata = new HashMap<String, ColumnType>();
		columnMetadata.put("property1", ColumnType.Integer);
		columnMetadata.put("property2", ColumnType.Integer);
		columnMetadata.put("property3", ColumnType.String);
		
		Map<String, Object> rowData1 = new HashMap<String, Object>();
		rowData1.put("property1", 10);
		rowData1.put("property2", 20);
		rowData1.put("property3", "thirty");
		
		String randomName = UUID.randomUUID().toString();
		entityInfoService.createEntity(randomName, columnMetadata);
		long id1 = dataAccessService.createEntityRecord(randomName, rowData1);
		
		
		Map <String, ColumnType> columnMetadata2 = new HashMap<String, ColumnType>();
		columnMetadata2.put("property11", ColumnType.Integer);
		columnMetadata2.put("property22", ColumnType.Integer);
		columnMetadata2.put("property33", ColumnType.String);
		
		Map<String, Object> rowData2 = new HashMap<String, Object>();
		rowData2.put("property11", 11);
		rowData2.put("property22", 22);
		rowData2.put("property33", "thirty three");
		
		String randomName2 = UUID.randomUUID().toString();
		entityInfoService.createEntity(randomName2, columnMetadata2);
		long id2 = dataAccessService.createEntityRecord(randomName2, rowData2);
		
		Map<String, Object> row1 = dataAccessService.getEntityRecord(randomName, id1);
		Map<String, Object> row2 = dataAccessService.getEntityRecord(randomName2, id2);
		
		assertEquals(rowData1.size(), row1.size());
		assertEquals(rowData2.size(), row2.size());
		
		for(String property : rowData1.keySet()) {
			assertEquals(rowData1.get(property), row1.get(property));
		}
		
		for(String property : rowData2.keySet()) {
			assertEquals(rowData2.get(property), row2.get(property));
		}
	}

}
