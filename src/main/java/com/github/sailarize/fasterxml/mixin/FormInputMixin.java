package com.github.sailarize.fasterxml.mixin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.github.sailarize.form.FormInput;

/**
 * A Mixin that holds the FasterXml serialization configuration for {@link FormInput}.
 * 
 * @author agusmunioz
 *
 */
public interface FormInputMixin {

	@JsonInclude(Include.NON_NULL)
	String getId();

	@JsonInclude(Include.NON_NULL)
	String getMask();
}
