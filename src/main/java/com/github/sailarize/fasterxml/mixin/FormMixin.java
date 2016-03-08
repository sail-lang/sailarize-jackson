package com.github.sailarize.fasterxml.mixin;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.sailarize.fasterxml.serializer.HeaderJsonSerializer;
import com.github.sailarize.form.Form;

/**
 * A Mixin that holds the Jackson serialization configuration for {@link Form}.
 * 
 * @author agusmunioz
 *
 */
@JsonInclude(Include.NON_NULL)
public interface FormMixin {

	@JsonSerialize(using = HeaderJsonSerializer.class)
	Map<String, String> getHeaders();

}
