package com.github.sailarize.jackson.mixin;

import java.util.Collection;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.github.sailarize.form.Form;
import com.github.sailarize.jackson.serializer.SailResourceSerializer;
import com.github.sailarize.link.HypermediaLink;
import com.github.sailarize.media.Image;
import com.github.sailarize.media.Video;
import com.github.sailarize.resource.SailResource;

/**
 * A Mixin that holds the Jackson serialization configuration for
 * {@link SailResource}. Hypermedia controls are {@link JsonIgnore}d as
 * {@link SailResourceSerializer} performs a custom serialization.
 * 
 * @author agusmunioz
 *
 */
public interface SailResourceMixIn {

	@JsonInclude(Include.NON_NULL)
	String getId();

	@JsonIgnore
	Map<String, Object> getMeta();

	@JsonIgnore
	Map<String, Collection<HypermediaLink>> getLinks();

	@JsonIgnore
	Map<String, Collection<Form>> getForms();

	@JsonIgnore
	Map<String, Collection<Image>> getImages();
	
	@JsonIgnore
	Map<String, Collection<Video>> getVideos();

}
