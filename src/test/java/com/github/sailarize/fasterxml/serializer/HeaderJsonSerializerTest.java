package com.github.sailarize.fasterxml.serializer;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerator;
import com.github.sailarize.fasterxml.test.json.JsonUtils;

/**
 * Unit test for {@link HeaderJsonSerializer}.
 * 
 * @author agusmunioz
 *
 */
public class HeaderJsonSerializerTest {

	private HeaderJsonSerializer serializer = new HeaderJsonSerializer();

	/**
	 * Test the serialization of a map with header values.
	 */
	@Test
	public void serialization() {

		Map<String, String> headers = new LinkedHashMap<String, String>();
		headers.put("header1", "aValue1");
		headers.put("header2", "aValue2");

		try {

			JsonGenerator gen = JsonUtils.generator();

			this.serializer.serialize(headers, gen, null);

			String expected = JsonUtils.json("headers");

			String actual = JsonUtils.json(gen);

			Assert.assertEquals("Unexpected headers serialization.", expected, actual);

		} catch (Exception e) {
			Assert.fail("Unexpected exception");
		}
	}
	
	/**
	 * Test the serialization of an empty {@link Map} of headers.
	 */
	@Test
	public void emptyHeaders(){

		Map<String, String> headers = new LinkedHashMap<String, String>();

		try {

			JsonGenerator gen = JsonUtils.generator();

			this.serializer.serialize(headers, gen, null);

			String expected = "[]";

			String actual = JsonUtils.json(gen);

			Assert.assertEquals("Unexpected empty headers serialization.", expected, actual);

		} catch (Exception e) {
			Assert.fail("Unexpected exception");
		}
	}
	
	/**
	 * Test the serialization of a null {@link Map} of headers.
	 */
	@Test
	public void nullHeaders(){

		try {

			JsonGenerator gen = JsonUtils.generator();

			this.serializer.serialize(null, gen, null);

			String expected = "[]";

			String actual = JsonUtils.json(gen);

			Assert.assertEquals("Unexpected null headers serialization.", expected, actual);

		} catch (Exception e) {
			Assert.fail("Unexpected exception");
		}
	}
}
