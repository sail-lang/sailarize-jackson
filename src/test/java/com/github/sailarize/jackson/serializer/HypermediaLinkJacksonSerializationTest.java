package com.github.sailarize.jackson.serializer;

import com.github.sailarize.jackson.test.utils.JacksonUtils;
import com.github.sailarize.link.HypermediaLink;
import com.github.sailarize.link.HypermediaLinkSerializationTest;

/**
 * Unit test for the serialzation of {@link HypermediaLink} with Jackson.
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
