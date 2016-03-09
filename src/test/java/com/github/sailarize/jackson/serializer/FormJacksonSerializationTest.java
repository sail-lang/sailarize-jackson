package com.github.sailarize.jackson.serializer;

import com.github.sailarize.form.Form;
import com.github.sailarize.form.FormSerializationTest;
import com.github.sailarize.jackson.test.utils.JacksonUtils;

/**
 * Unit test for the serialization of a {@link Form} with Jackson.
 * 
 * @author agusmunioz
 *
 */
public class FormJacksonSerializationTest extends FormSerializationTest{


	@Override
	protected String serialize(Form form) {
		return JacksonUtils.serialize(form);
	}
}
