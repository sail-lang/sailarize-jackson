package com.github.sailarize.jackson.serialization;

import com.github.sailarize.form.MultilectInput;
import com.github.sailarize.form.MultilectInputSerializationTest;
import com.github.sailarize.jackson.config.SailBeanSerializerModifier;
import com.github.sailarize.jackson.config.SailSimpleModule;
import com.github.sailarize.jackson.mixin.MultilectInputMixin;
import com.github.sailarize.jackson.test.utils.JacksonUtils;

/**
 * Unit test for the serialization of a {@link MultilectInput} with Jackson using
 * the configuration set in {@link MultilectInputMixin}. All the "wiring"
 * takes place at {@link SailSimpleModule} and
 * {@link SailBeanSerializerModifier}.
 * 
 * @author agusmunioz
 *
 */
public class MultilectInputJacksonSerializationTest extends MultilectInputSerializationTest {

	@Override
	protected String serialize(MultilectInput input) {
		return JacksonUtils.serialize(input);
	}
}
