package com.github.sailarize.jackson.serialization;

import com.github.sailarize.form.SingleSelectInput;
import com.github.sailarize.form.SingleSelectInputSerializationTest;
import com.github.sailarize.jackson.config.SailBeanSerializerModifier;
import com.github.sailarize.jackson.config.SailSimpleModule;
import com.github.sailarize.jackson.mixin.SingleSelectInputMixin;
import com.github.sailarize.jackson.test.utils.JacksonUtils;

/**
 * Unit test for the serialization of a {@link SingleSelectInput} with Jackson using
 * the configuration set in {@link SingleSelectInputMixin}. All the "wiring"
 * takes place at {@link SailSimpleModule} and
 * {@link SailBeanSerializerModifier}.
 * 
 * @author agusmunioz
 *
 */
public class SingleSelectInputJacksonSerializationTest extends SingleSelectInputSerializationTest {

	@Override
	protected String serialize(SingleSelectInput input) {
		return JacksonUtils.serialize(input);
	}
}
