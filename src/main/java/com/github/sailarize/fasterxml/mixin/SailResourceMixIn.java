package com.github.sailarize.fasterxml.mixin;

import java.util.Collection;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.sailarize.fasterxml.serializer.SailJsonSerializer;
import com.github.sailarize.form.Form;
import com.github.sailarize.link.HypermediaLink;
import com.github.sailarize.resource.SailResource;

/**
 * A Mixin that holds the serialization configuration for {@link SailResource}
 * with FasterXml features. Hypermedia controls are {@link JsonIgnore}d as
 * {@link SailJsonSerializer} performs a custom serialization.
 * 
 * @author agusmunioz
 *
 */
public interface SailResourceMixIn {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	String getId();

	@JsonIgnore
	Map<String, Object> getMeta();

	@JsonIgnore
	Map<String, Collection<HypermediaLink>> getLinks();

	@JsonIgnore
	Map<String, Collection<Form>> getForms();

}
