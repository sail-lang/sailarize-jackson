package com.github.sailarize.jackson.mixin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.github.sailarize.form.ValueInput;

/**
 * A Mixin that holds the Jackson serialization configuration for
 * {@link ValueInput}.
 * 
 * @author agusmunioz
 *
 */
public interface ValueInputMixin {

	@JsonInclude(Include.NON_NULL)
	String getId();

	@JsonInclude(Include.NON_NULL)
	String getMask();
	
	@JsonInclude(Include.NON_NULL)
	String getTitle();

}
