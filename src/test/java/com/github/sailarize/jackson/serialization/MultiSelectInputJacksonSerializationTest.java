package com.github.sailarize.jackson.serialization;

import com.github.sailarize.form.MultiSelectInput;
import com.github.sailarize.form.MultiSelectInputSerializationTest;
import com.github.sailarize.jackson.config.SailBeanSerializerModifier;
import com.github.sailarize.jackson.config.SailSimpleModule;
import com.github.sailarize.jackson.mixin.MultiSelectInputMixin;
import com.github.sailarize.jackson.test.utils.JacksonUtils;

/**
 * Unit test for the serialization of a {@link MultiSelectInput} with Jackson using
 * the configuration set in {@link MultiSelectInputMixin}. All the "wiring"
 * takes place at {@link SailSimpleModule} and
 * {@link SailBeanSerializerModifier}.
 * 
 * @author agusmunioz
 *
 */
public class MultiSelectInputJacksonSerializationTest extends MultiSelectInputSerializationTest {

	@Override
	protected String serialize(MultiSelectInput input) {
		return JacksonUtils.serialize(input);
	}
}
