package com.github.lowton.collections.map;

import static com.github.lowton.collections.map.MapInMap.Type.BOX;
import static com.github.lowton.collections.map.MapInMap.Type.CONTAINER;
import static com.github.lowton.collections.map.MapInMap.Type.PACKAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MapInMapTest {
	
	private Collection<MapInMap> mapList;
	
	@BeforeEach
	void setUp() {
		mapList = List.of(
				new MapInMap(1, "test-1", BOX),
				new MapInMap(2, "test-1", CONTAINER),
				new MapInMap(3, "test-1", PACKAGE),
				new MapInMap(4, "test-2", BOX),
				new MapInMap(5, "test-2", PACKAGE),
				new MapInMap(6, "test-3", PACKAGE),
				new MapInMap(7, "test-3", CONTAINER),
				new MapInMap(8, "test-4", CONTAINER),
				new MapInMap(9, "test-5", BOX),
				new MapInMap(10, "test-6", PACKAGE)
		);
	}
	
	@Test
	void check() {
		final var result = MapInMap.transform(this.mapList);
		
		assertThat(result).hasSize(6);
		assertThat(result.get("test-1"))
				.hasSize(3)
				.containsExactlyInAnyOrderEntriesOf(Map.of(
						BOX, new MapInMap(1, "test-1", BOX),
						CONTAINER, new MapInMap(2, "test-1", CONTAINER),
						PACKAGE, new MapInMap(3, "test-1", PACKAGE)));
		assertThat(result.get("test-2"))
				.hasSize(2)
				.containsExactlyInAnyOrderEntriesOf(Map.of(
						BOX, new MapInMap(4, "test-2", BOX),
						PACKAGE, new MapInMap(5, "test-2", PACKAGE)));
		assertThat(result.get("test-3"))
				.hasSize(2)
				.containsExactlyInAnyOrderEntriesOf(Map.of(
						CONTAINER, new MapInMap(7, "test-3", CONTAINER),
						PACKAGE, new MapInMap(6, "test-3", PACKAGE)));
		assertThat(result.get("test-4"))
				.hasSize(1)
				.containsEntry(CONTAINER, new MapInMap(8, "test-4", CONTAINER));
		assertThat(result.get("test-5"))
				.hasSize(1)
				.containsEntry(BOX, new MapInMap(9, "test-5", BOX));
		assertThat(result.get("test-6"))
				.hasSize(1)
				.containsEntry(PACKAGE, new MapInMap(10, "test-6", PACKAGE));
	}
}