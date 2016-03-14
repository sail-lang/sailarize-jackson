package com.github.sailarize.jackson.mixin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.github.sailarize.form.Option;

/**
 * A Mixin that holds the Jackson serialization configuration for
 * {@link Option}.
 * 
 * @author agusmunioz
 *
 */
public interface OptionMixin {

	@JsonInclude(Include.NON_NULL)
	String getTitle();


}
