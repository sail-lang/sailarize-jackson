package com.github.sailarize.jackson.serializer;

import com.github.sailarize.form.FormInput;
import com.github.sailarize.form.FormInputSerializationTest;
import com.github.sailarize.jackson.test.utils.JacksonUtils;

/**
 * Unit test for the serialization of a {@link FormInput} with Jackson.
 * 
 * @author agusmunioz
 *
 */
public class FormInputJacksonSerializationTest extends FormInputSerializationTest{

	
	@Override
	protected String serialize(FormInput input) {
		return JacksonUtils.serialize(input);
	}
}
