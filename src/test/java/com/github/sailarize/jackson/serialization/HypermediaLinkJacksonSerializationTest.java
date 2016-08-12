package com.github.sailarize.jackson.serialization;

import com.github.sailarize.jackson.config.SailBeanSerializerModifier;
import com.github.sailarize.jackson.config.SailSimpleModule;
import com.github.sailarize.jackson.mixin.HypermediaLinkMixin;
import com.github.sailarize.jackson.test.utils.JacksonUtils;
import com.github.sailarize.link.HypermediaLink;
import com.github.sailarize.link.HypermediaLinkSerializationTest;

/**
 * Unit test for the serialzation of {@link HypermediaLink} with Jackson using
 * the configuration set in {@link HypermediaLinkMixin}. All the "wiring" takes
 * place at {@link SailSimpleModule} and {@link SailBeanSerializerModifier}.
 * 
 * @author agusmunioz
 *
 */
public class HypermediaLinkJacksonSerializationTest extends HypermediaLinkSerializationTest {

	@Override
	protected String serialize(HypermediaLink link) {
		return JacksonUtils.serialize(link);
	}
}
