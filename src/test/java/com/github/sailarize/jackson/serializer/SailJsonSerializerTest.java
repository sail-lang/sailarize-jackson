package com.github.sailarize.jackson.serializer;

import com.github.sailarize.jackson.serializer.SailJsonSerializer;
import com.github.sailarize.jackson.test.utils.JacksonUtils;
import com.github.sailarize.resource.SailResource;
import com.github.sailarize.resource.SailSerializerTest;

/**
 * Unit test for {@link SailJsonSerializer}.
 * 
 * @author agusmunioz
 *
 */
public class SailJsonSerializerTest extends SailSerializerTest{

	

	@Override
	protected String serialize(SailResource resource) {
		
		return JacksonUtils.serialize(resource);
	}
}
