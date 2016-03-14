package com.github.sailarize.jackson.serialization;

import com.github.sailarize.form.SelectInput;
import com.github.sailarize.form.SelectInputSerializationTest;
import com.github.sailarize.jackson.config.SailBeanSerializerModifier;
import com.github.sailarize.jackson.config.SailSimpleModule;
import com.github.sailarize.jackson.mixin.FormInputMixin;
import com.github.sailarize.jackson.test.utils.JacksonUtils;

/**
 * Unit test for the serialization of a {@link SelectInput} with Jackson using the
 * configuration set in {@link FormInputMixin}. All the "wiring" takes place at
 * {@link SailSimpleModule} and {@link SailBeanSerializerModifier}.
 * 
 * @author agusmunioz
 *
 */
public class SelectInputJacksonSerializationTest extends SelectInputSerializationTest {

	@Override
	protected String serialize(SelectInput input) {
		return JacksonUtils.serialize(input);
	}
}
