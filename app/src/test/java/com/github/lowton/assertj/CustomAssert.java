package com.github.lowton.assertj;

import org.assertj.core.api.AbstractAssert;

public class CustomAssert extends AbstractAssert<CustomAssert, CustomIdObject> {
	
	protected CustomAssert(CustomIdObject customAssertion) {
		super(customAssertion, CustomAssert.class);
	}
	
	public static CustomAssert assertThat(CustomIdObject actual) {
		return new CustomAssert(actual);
	}
	
	public CustomAssert hasNegativeId() {
		isNotNull();
		
		if (actual.id() >= 0) {
			failWithMessage("Expected negative id but got %s", actual.id());
		}
		
		return this;
	}
}
