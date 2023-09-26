package com.github.lowton.javaupdates;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * I used HttpResponse.BodyHandlers.ofString to get
 * a String response in that example. You can get all sorts
 * of objects back, not just String. But String results are nice
 * because they are a great segue to another fantastic feature in
 * Java 21: the new support for working with String instances.
 * This class shows two of my favorites: a repeat operation
 * for StringBuilder and a way to detect the presence of Emojis
 * in a String.
 */
class StringsTest {
	
	/**
	 * Example demonstrates using the StringBuilder to repeat a String
	 * (can we all collectively get rid of our various StringUtils, yet?)
	 * @throws Exception
	 */
	@Test
	void repeat() throws Exception {
		// ①
		var line = new StringBuilder()
				.repeat("-", 10)
				.toString();
		Assertions.assertEquals("----------", line);
	}
	
	/**
	 * Example demonstrates detecting an emoji in a String
	 * @throws Exception
	 */
	@Test
	void emojis() throws Exception {
		// ②
		var shockedFaceEmoji = "\uD83E\uDD2F";
		var cp = Character.codePointAt(shockedFaceEmoji.toCharArray(), 0);
		Assertions.assertTrue(Character.isEmoji(cp));
		System.out.println(shockedFaceEmoji);
	}
}