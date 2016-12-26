package com.github.sailarize.jackson.serialization;

import com.github.sailarize.form.CloneSelectInput;
import com.github.sailarize.form.CloneSelectInputSerializationTest;
import com.github.sailarize.jackson.test.utils.JacksonUtils;

public class CloneSelectInputJacksonSerializationTest extends CloneSelectInputSerializationTest {

	@Override
	protected String serialize(CloneSelectInput input) {
		return JacksonUtils.serialize(input);
	}

}
