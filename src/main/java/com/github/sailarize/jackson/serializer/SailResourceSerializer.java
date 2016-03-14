package com.github.sailarize.jackson.serializer;

import java.io.IOException;
import java.util.Collection;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.github.sailarize.form.Form;
import com.github.sailarize.link.HypermediaLink;
import com.github.sailarize.resource.SailResource;
import com.github.sailarize.resource.SailTags;

/**
 * Sail resources serializer based on {@link BeanSerializerBase}. It performs a
 * special serialization of Hypermedia controls after serializing the resource's
 * regular fields.
 * 
 * @author agusmunioz
 *
 */
public class SailResourceSerializer extends BeanSerializerAdapter {

	/**
	 * Default Serial id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates an intialized {@link SailResourceSerializer}.
	 * 
	 * @param source
	 */
	public SailResourceSerializer(BeanSerializerBase source) {
		super(source);
	}

	public void serialize(Object resource, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonGenerationException {

		jgen.writeStartObject();

		this.resource(resource, jgen, provider);

		this.hypermedia((SailResource) resource, jgen);

		jgen.writeEndObject();
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
	private void resource(Object resource, JsonGenerator jgen, SerializerProvider provider) throws IOException {

		this.serializeFields(resource, jgen, provider);

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
