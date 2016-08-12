package com.github.sailarize.jackson.serializer;

import com.github.sailarize.jackson.config.SailBeanSerializerModifier;
import com.github.sailarize.jackson.config.SailSimpleModule;
import com.github.sailarize.jackson.mixin.SailResourceMixIn;
import com.github.sailarize.jackson.test.utils.JacksonUtils;
import com.github.sailarize.resource.SailResource;
import com.github.sailarize.resource.SailSerializerTest;

/**
 * Unit test for {@link SailResourceSerializer}. It uses the configuration set
 * in {@link SailResourceMixIn}. All the "wiring" takes place at
 * {@link SailSimpleModule} and {@link SailBeanSerializerModifier}.
 * 
 * @author agusmunioz
 *
 */
public class SailResourceSerializerTest extends SailSerializerTest {

	@Override
	protected String serialize(SailResource resource) {

		return JacksonUtils.serialize(resource);
	}
}
