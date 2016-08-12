package com.github.sailarize.jackson.serialization;

import com.github.sailarize.form.ValueInput;
import com.github.sailarize.form.ValueInputSerializationTest;
import com.github.sailarize.jackson.config.SailBeanSerializerModifier;
import com.github.sailarize.jackson.config.SailSimpleModule;
import com.github.sailarize.jackson.mixin.ValueInputMixin;
import com.github.sailarize.jackson.test.utils.JacksonUtils;

/**
 * Unit test for the serialization of a {@link ValueInput} with Jackson using the
 * configuration set in {@link ValueInputMixin}. All the "wiring" takes place at
 * {@link SailSimpleModule} and {@link SailBeanSerializerModifier}.
 * 
 * @author agusmunioz
 *
 */
public class ValueInputJacksonSerializationTest extends ValueInputSerializationTest {

	@Override
	protected String serialize(ValueInput input) {
		return JacksonUtils.serialize(input);
	}
}
