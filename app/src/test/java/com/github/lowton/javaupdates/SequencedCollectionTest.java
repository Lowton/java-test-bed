package com.github.lowton.javaupdates;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.SequencedCollection;

class SequencedCollectionTest {
	
	@Test
	void ordering() throws Exception {
		var list = LinkedHashSet.<String>newLinkedHashSet(100);
		if (list instanceof SequencedCollection<String> sequencedCollection) {
			sequencedCollection.add("ciao");
			sequencedCollection.add("hola");
			sequencedCollection.add("ni hao");
			sequencedCollection.add("salut");
			sequencedCollection.add("hello");
			sequencedCollection.addFirst("ola"); //<1>
			Assertions.assertEquals("ola", sequencedCollection.getFirst()); // ②
		}
	}
	
	@Test
	void listInterface() {
		var list = List.of("one", "two", "three", "four", "five", "six");
		Assertions.assertEquals("one", list.getFirst());
		Assertions.assertEquals("six", list.getLast());
	}
}