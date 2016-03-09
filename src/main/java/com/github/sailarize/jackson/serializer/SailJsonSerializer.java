package com.github.sailarize.jackson.serializer;

import java.io.IOException;
import java.util.Collection;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanSerializer;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.github.sailarize.form.Form;
import com.github.sailarize.link.HypermediaLink;
import com.github.sailarize.resource.SailResource;
import com.github.sailarize.resource.SailTags;

/**
 * Sail resources serializer based on {@link JsonSerializer}
 * 
 * @author agusmunioz
 *
 */
public class SailJsonSerializer extends JsonSerializer<SailResource> {

	private BeanSerializer defaultSerializer;

	/**
	 * Creates an initialized {@link SailJsonSerializer}.
	 * 
	 * @param serializer
	 *            a bean default serializer for serializing the resource without
	 *            Hypermedia controls.
	 */
	public SailJsonSerializer(BeanSerializer serializer) {
		this.defaultSerializer = serializer;
	}

	@Override
	public void serialize(SailResource resource, JsonGenerator jgenerator, SerializerProvider serializers)
			throws IOException, JsonProcessingException {

		jgenerator.writeStartObject();

		this.resource(resource, jgenerator, serializers);

		this.hypermedia(resource, jgenerator);

		jgenerator.writeEndObject();
	}

	/**
	 * Serializes the resource without Hypermedia controls in an unwrapped way.
	 * 
	 * @param resource
	 *            the resource.
	 * 
	 * @param jgenerator
	 *            the generator for serializing the resource.
	 * 
	 * @throws IOException
	 *             if there is a problem when serializing.
	 */
	private void resource(SailResource resource, JsonGenerator jgenerator, SerializerProvider serializers)
			throws IOException {

		this.defaultSerializer.unwrappingSerializer(NameTransformer.NOP).serialize(resource, jgenerator, serializers);

	}

	/**
	 * Serializes Hypermedia controls.
	 * 
	 * @param resource
	 *            the Sail resource with Hypermedia controls.
	 * 
	 * @param jgenerator
	 *            the generator for adding Hypermedia controls.
	 * 
	 * @throws IOException
	 *             if there is a problem when serializing.
	 */
	private void hypermedia(SailResource resource, JsonGenerator jgenerator) throws IOException {

		if (resource.getMeta() != null) {
			jgenerator.writeObjectField(SailTags.META, resource.getMeta());
		}

		for (Entry<String, Collection<HypermediaLink>> links : resource.getLinks().entrySet()) {
			jgenerator.writeObjectField(links.getKey(), links.getValue());
		}

		if (resource.getForms() != null) {
			for (Entry<String, Collection<Form>> forms : resource.getForms().entrySet()) {
				jgenerator.writeObjectField(forms.getKey(), forms.getValue());
			}
		}
	}

}
