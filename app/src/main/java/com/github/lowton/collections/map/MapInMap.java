package com.github.lowton.collections.map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

import java.util.Collection;
import java.util.Map;

public record MapInMap(int id, String name, Type type) {
	public enum Type {BOX, PACKAGE, CONTAINER}
	
	public static Map<String, Map<Type, MapInMap>> transform(Collection<MapInMap> mapList) {
		return mapList.stream().collect(groupingBy(MapInMap::name, toMap(MapInMap::type, x -> x)));
	}
}