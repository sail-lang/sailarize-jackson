package com.github.sailarize.jackson.test.utils;

import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sailarize.jackson.config.SailSimpleModule;

/**
 * Utilities for testing Json purposes.
 * 
 * @author agusmunioz
 *
 */
public class JacksonUtils {

	private final static JsonFactory FACTORY = new JsonFactory();

	private final static ObjectMapper MAPPER = new ObjectMapper();

	static {

		MAPPER.registerModule(new SailSimpleModule());
	}

	/**
	 * Gets the Json written in the generator. In order to read it the generator
	 * is closed.
	 * 
	 * @param gen
	 *            the generator.
	 * 
	 * @return the Json as a String or null if there was a problem.
	 */
	public static String json(JsonGenerator gen) {

		try {

			gen.close();

			return ((StringWriter) gen.getOutputTarget()).toString();

		} catch (IOException e) {
			return null;
		}

	}

	/**
	 * Creates a {@link JsonGenerator}.
	 * 
	 * @return the generator or null if there was an error.
	 */
	public static JsonGenerator generator() {

		try {

			JsonGenerator gen = FACTORY.createGenerator(new StringWriter());
			gen.setCodec(MAPPER);

			return gen;

		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * Serializes the object.
	 * 
	 * @param object
	 *            the object to be serialized.
	 * 
	 * @return the Json obtained from the serialization.
	 */
	public static String serialize(Object object) {

		try {

			JsonGenerator gen = generator();
			MAPPER.writeValue(gen, object);
			return json(gen);

		} catch (Exception e) {
			return null;
		}

	}
}
