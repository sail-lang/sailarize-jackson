package com.github.sailarize.jackson.mixin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.github.sailarize.form.Form;

/**
 * A Mixin that holds the Jackson serialization configuration for {@link Form}.
 * 
 * @author agusmunioz
 *
 */
@JsonInclude(Include.NON_NULL)
public interface FormMixin {

}
