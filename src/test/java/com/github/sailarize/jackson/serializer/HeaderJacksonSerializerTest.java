package com.github.sailarize.jackson.serializer;

import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.github.sailarize.header.HeaderSerializerTest;
import com.github.sailarize.jackson.serializer.HeaderJsonSerializer;
import com.github.sailarize.jackson.test.utils.JacksonUtils;

/**
 * Unit test for {@link HeaderJsonSerializer}.
 * 
 * @author agusmunioz
 *
 */
public class HeaderJacksonSerializerTest extends HeaderSerializerTest{

	private HeaderJsonSerializer serializer = new HeaderJsonSerializer();


	@Override
	protected String serialize(Map<String, String> headers) {
		
		try {

			JsonGenerator gen = JacksonUtils.generator();

			this.serializer.serialize(headers, gen, null);

			return JacksonUtils.json(gen);

		} catch (Exception e) {
			return null;
		}
	}
}
