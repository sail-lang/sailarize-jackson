package com.github.sailarize.jackson.mixin;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.sailarize.form.Option;
import com.github.sailarize.form.SelectInput;
/**
 * A Mixin that holds the Jackson serialization configuration for
 * {@link SelectInput}.
 * 
 * @author agusmunioz
 *
 */
@JsonInclude(Include.NON_NULL)
public interface SelectInputMixin {

	@JsonProperty("select")
	Collection<Option> getOptions();
}
