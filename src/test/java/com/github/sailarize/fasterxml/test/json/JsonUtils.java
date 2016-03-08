package com.github.sailarize.fasterxml.test.json;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sailarize.fasterxml.config.SailSimpleModule;

/**
 * Utilities for testing Json purposes.
 * 
 * @author agusmunioz
 *
 */
public class JsonUtils {

	private static final String JSON_FOLDER = "/com/github/sailarize/fasterxml/serializer/";

	private final static JsonFactory FACTORY = new JsonFactory();

	private final static ObjectMapper MAPPER = new ObjectMapper();

	static {

		MAPPER.registerModule(new SailSimpleModule());
	}

	/**
	 * Reads a Json from a classpath file.
	 * 
	 * @param file
	 *            the classpath file name.
	 *
	 * @return the Json as a string or null if the file was not found.
	 */
	public static String json(String file) {

		try {

			Path path = Paths.get(JsonUtils.class.getResource(JSON_FOLDER + file + ".json").toURI());

			return new String(Files.readAllBytes(path), "UTF-8").replace(" ", "").replace("\n", "");

		} catch (Exception e) {
			return null;
		}

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
