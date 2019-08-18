package com.phodu.naav.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EntityData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long id;
	private String entityType;
	private Integer integer1, integer2, integer3, integer4, integer5, integer6, integer7, integer8, integer9, integer10;
	private String string1, string2, string3, string4, string5, string6, string7, string8, string9, string10;
	
	public EntityData() {
		
	}
	/**
	 * @return the integer1
	 */
	public Integer getInteger1() {
		return integer1;
	}

	/**
	 * @param integer1 the integer1 to set
	 */
	public void setInteger1(Integer integer1) {
		this.integer1 = integer1;
	}

	/**
	 * @return the integer2
	 */
	public Integer getInteger2() {
		return integer2;
	}

	/**
	 * @param integer2 the integer2 to set
	 */
	public void setInteger2(Integer integer2) {
		this.integer2 = integer2;
	}

	/**
	 * @return the integer3
	 */
	public Integer getInteger3() {
		return integer3;
	}

	/**
	 * @param integer3 the integer3 to set
	 */
	public void setInteger3(Integer integer3) {
		this.integer3 = integer3;
	}

	/**
	 * @return the integer4
	 */
	public Integer getInteger4() {
		return integer4;
	}

	/**
	 * @param integer4 the integer4 to set
	 */
	public void setInteger4(Integer integer4) {
		this.integer4 = integer4;
	}

	/**
	 * @return the integer5
	 */
	public Integer getInteger5() {
		return integer5;
	}

	/**
	 * @param integer5 the integer5 to set
	 */
	public void setInteger5(Integer integer5) {
		this.integer5 = integer5;
	}

	/**
	 * @return the integer6
	 */
	public Integer getInteger6() {
		return integer6;
	}

	/**
	 * @param integer6 the integer6 to set
	 */
	public void setInteger6(Integer integer6) {
		this.integer6 = integer6;
	}

	/**
	 * @return the integer7
	 */
	public Integer getInteger7() {
		return integer7;
	}

	/**
	 * @param integer7 the integer7 to set
	 */
	public void setInteger7(Integer integer7) {
		this.integer7 = integer7;
	}

	/**
	 * @return the integer8
	 */
	public Integer getInteger8() {
		return integer8;
	}

	/**
	 * @param integer8 the integer8 to set
	 */
	public void setInteger8(Integer integer8) {
		this.integer8 = integer8;
	}

	/**
	 * @return the integer9
	 */
	public Integer getInteger9() {
		return integer9;
	}

	/**
	 * @param integer9 the integer9 to set
	 */
	public void setInteger9(Integer integer9) {
		this.integer9 = integer9;
	}

	/**
	 * @return the integer10
	 */
	public Integer getInteger10() {
		return integer10;
	}

	/**
	 * @param integer10 the integer10 to set
	 */
	public void setInteger10(Integer integer10) {
		this.integer10 = integer10;
	}

	/**
	 * @return the string1
	 */
	public String getString1() {
		return string1;
	}

	/**
	 * @param string1 the string1 to set
	 */
	public void setString1(String string1) {
		this.string1 = string1;
	}

	/**
	 * @return the string2
	 */
	public String getString2() {
		return string2;
	}

	/**
	 * @param string2 the string2 to set
	 */
	public void setString2(String string2) {
		this.string2 = string2;
	}

	/**
	 * @return the string3
	 */
	public String getString3() {
		return string3;
	}

	/**
	 * @param string3 the string3 to set
	 */
	public void setString3(String string3) {
		this.string3 = string3;
	}

	/**
	 * @return the string4
	 */
	public String getString4() {
		return string4;
	}

	/**
	 * @param string4 the string4 to set
	 */
	public void setString4(String string4) {
		this.string4 = string4;
	}

	/**
	 * @return the string5
	 */
	public String getString5() {
		return string5;
	}

	/**
	 * @param string5 the string5 to set
	 */
	public void setString5(String string5) {
		this.string5 = string5;
	}

	/**
	 * @return the string6
	 */
	public String getString6() {
		return string6;
	}

	/**
	 * @param string6 the string6 to set
	 */
	public void setString6(String string6) {
		this.string6 = string6;
	}

	/**
	 * @return the string7
	 */
	public String getString7() {
		return string7;
	}

	/**
	 * @param string7 the string7 to set
	 */
	public void setString7(String string7) {
		this.string7 = string7;
	}

	/**
	 * @return the string8
	 */
	public String getString8() {
		return string8;
	}

	/**
	 * @param string8 the string8 to set
	 */
	public void setString8(String string8) {
		this.string8 = string8;
	}

	/**
	 * @return the string9
	 */
	public String getString9() {
		return string9;
	}

	/**
	 * @param string9 the string9 to set
	 */
	public void setString9(String string9) {
		this.string9 = string9;
	}

	/**
	 * @return the string10
	 */
	public String getString10() {
		return string10;
	}

	/**
	 * @param string10 the string10 to set
	 */
	public void setString10(String string10) {
		this.string10 = string10;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the entityType
	 */
	public String getEntityType() {
		return entityType;
	}

	/**
	 * @param entityType the entityType to set
	 */
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public EntityData(String entityType, Integer[] integers, String[] strings) {
		super();
		
		this.entityType = entityType;
		
		integer1 = integers[0];
		integer2 = integers[1];
		integer3 = integers[2];
		integer4 = integers[3];
		integer5 = integers[4];
		integer6 = integers[5];
		integer7 = integers[6];
		integer8 = integers[7];
		integer9 = integers[8];
		integer10 = integers[9];
		
		string1 = strings[0];
		string2 = strings[1];
		string3 = strings[2];
		string4 = strings[3];
		string5 = strings[4];
		string6 = strings[5];
		string7 = strings[6];
		string8 = strings[7];
		string9 = strings[8];
		string10 = strings[9];
	}
	
	
}
