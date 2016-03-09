package com.github.sailarize.jackson.mixin;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.sailarize.jackson.serializer.HeaderJsonSerializer;
import com.github.sailarize.link.HypermediaLink;

/**
 * A Mixin that holds the Jackson serialization configuration for {@link HypermediaLink}.
 * 
 * @author agusmunioz
 *
 */
@JsonInclude(Include.NON_NULL)
public interface HypermediaLinkMixin {

	@JsonSerialize(using = HeaderJsonSerializer.class)
	Map<String, String> getHeaders();

	@JsonAnyGetter
	Map<String, String> getData();
}
