package com.github.lowton.javaupdates;

import static java.lang.Runtime.getRuntime;
import static java.util.concurrent.Executors.newFixedThreadPool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;

class FutureTest {
	
	@Test
	void futureTest() throws Exception {
		try (var executor = newFixedThreadPool(getRuntime().availableProcessors())) {
			var future = executor.submit(() -> "hello, world!");
			Thread.sleep(100);
			// ①
			var result = switch (future.state()) {
				case CANCELLED, FAILED -> throw new IllegalStateException("couldn't finish the work!");
				case SUCCESS -> future.resultNow();
				default -> null;
			};
			Assertions.assertEquals(result, "hello, world!");
		}
	}
}