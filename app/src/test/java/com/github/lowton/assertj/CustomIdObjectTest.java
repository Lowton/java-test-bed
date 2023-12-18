package com.github.lowton.assertj;

import static com.github.lowton.assertj.CustomAssert.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CustomIdObjectTest {
	@ParameterizedTest
	@ValueSource(ints = {-3, 0, 5})
	void checkAssertion(int value) {
		assertThat(new CustomIdObject(value)).hasNegativeId();
	}
}