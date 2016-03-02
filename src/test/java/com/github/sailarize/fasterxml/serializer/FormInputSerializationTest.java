package com.github.sailarize.fasterxml.serializer;

import org.junit.Test;

import com.github.sailarize.fasterxml.test.assertion.AssertSerialization;
import com.github.sailarize.form.FormInput;

/**
 * Unit test for the serialization of a {@link FormInput}.
 * 
 * @author agusmunioz
 *
 */
public class FormInputSerializationTest {

	/**
	 * Test for a form input with minimum information.
	 */
	@Test
	public void base() {

		FormInput input = new FormInput("input.field");

		AssertSerialization.assertEquals("Unexpected serialization of a base form input.", "form_input-base", input);

	}

	/**
	 * Test for a form input with id.
	 */
	@Test
	public void id() {

		FormInput input = new FormInput("input.field");
		input.setId("field");

		AssertSerialization.assertEquals("Unexpected serialization of a form input with id.", "form_input-id", input);
	}

	/**
	 * Test for a form input with a value set.
	 */
	@Test
	public void value() {

		FormInput input = new FormInput("input.field");
		input.setValue(3);

		AssertSerialization.assertEquals("Unexpected serialization of a form input with value.", "form_input-value",
				input);

	}

	/**
	 * Test for a form input with a mask.
	 */
	@Test
	public void mask() {

		FormInput input = new FormInput("input.field");
		input.setMask("dd/MM/yyyy");

		AssertSerialization.assertEquals("Unexpected serialization of a form input with a mask.", "form_input-mask",
				input);

	}

	/**
	 * Test for a complete form input.
	 */
	@Test
	public void full() {

		FormInput input = new FormInput("input.field");
		input.setId("field");
		input.setValue(3);
		input.setMask("dd/MM/yyyy");

		AssertSerialization.assertEquals("Unexpected serialization of a full form input.", "form_input-full", input);

	}
}
