package com.github.sailarize.jackson.serialization;

import com.github.sailarize.form.Form;
import com.github.sailarize.form.FormSerializationTest;
import com.github.sailarize.jackson.config.SailBeanSerializerModifier;
import com.github.sailarize.jackson.config.SailSimpleModule;
import com.github.sailarize.jackson.mixin.FormMixin;
import com.github.sailarize.jackson.test.utils.JacksonUtils;

/**
 * Unit test for the serialization of a {@link Form} with Jackson using the
 * configuration set in {@link FormMixin}. All the "wiring" takes place at
 * {@link SailSimpleModule} and {@link SailBeanSerializerModifier}.
 * 
 * @author agusmunioz
 *
 */
public class FormJacksonSerializationTest extends FormSerializationTest {

	@Override
	protected String serialize(Form form) {
		return JacksonUtils.serialize(form);
	}
}
