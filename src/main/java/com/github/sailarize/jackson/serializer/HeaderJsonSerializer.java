package com.github.sailarize.jackson.serializer;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * A {@link JsonSerializer} for serializing a Map of HTTP headers to a
 * collection of headers.
 * 
 * @author agusmunioz
 *
 */
public class HeaderJsonSerializer extends JsonSerializer<Map<String, String>> {

	private static final String NAME = "name";

	private static final String VALUE = "value";

	@Override
	public void serialize(Map<String, String> headers, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {

		gen.writeStartArray();

		if (headers != null) {
			
			for (Entry<String, String> header : headers.entrySet()) {

				gen.writeStartObject();
				gen.writeStringField(NAME, header.getKey());
				gen.writeStringField(VALUE, header.getValue());
				gen.writeEndObject();
			}
		}

		gen.writeEndArray();
	}

}
