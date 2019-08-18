package com.phodu.naav.manage;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;

import com.phodu.naav.core.ColumnType;

public class TestEntityDataService {

	@Test
	public void test() {
		EntityDataService entityDataService = new EntityDataService();
		String randomName = UUID.randomUUID().toString();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put(ColumnType.Integer+":1", 10);
		dataMap.put(ColumnType.Integer+":2", 11);
		dataMap.put(ColumnType.String+":1", "string1");
		long id = entityDataService.addEntityData(randomName, dataMap);
		
		Map<String,Object> retreivedMap = entityDataService.getEntityData(id);
		assertEquals(20, retreivedMap.size());
		assertEquals(Integer.class, retreivedMap.get(ColumnType.Integer+":1").getClass());
		assertEquals(Integer.class, retreivedMap.get(ColumnType.Integer+":2").getClass());
		assertEquals(String.class, retreivedMap.get(ColumnType.String+":1").getClass());
		assertEquals(10, retreivedMap.get(ColumnType.Integer+":1"));
		assertEquals(11, retreivedMap.get(ColumnType.Integer+":2"));
		assertEquals("string1", retreivedMap.get(ColumnType.String+":1"));
		
		entityDataService.remove(id);
	}

}
