/**
 * 
 */
package com.phodu.naav.core;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ashish
 *
 */
public enum ColumnType {
    String("String"),
    Integer("Integer");

    private String name;

    private static final Map<String,ColumnType> ENUM_MAP;

    ColumnType (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // Build an immutable map of String name to enum pairs.
    // Any Map impl can be used.

    static {
        Map<String,ColumnType> map = new ConcurrentHashMap<String, ColumnType>();
        for (ColumnType instance : ColumnType.values()) {
            map.put(instance.getName(),instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static ColumnType get (String name) {
        return ENUM_MAP.get(name);
    }
}
