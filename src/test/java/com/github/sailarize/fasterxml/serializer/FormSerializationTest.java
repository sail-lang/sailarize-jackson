package com.github.sailarize.fasterxml.serializer;

import org.junit.Test;

import com.github.sailarize.fasterxml.test.assertion.AssertSerialization;
import com.github.sailarize.form.Form;
import com.github.sailarize.form.FormInput;
import com.github.sailarize.http.Http;

/**
 * Unit test for the serialization of a {@link Form}.
 * 
 * @author agusmunioz
 *
 */
public class FormSerializationTest {

	/**
	 * Test the serialization of a form with the minimum information required.
	 */
	@Test
	public void base() {

		Form form = new Form();
		form.setId("form");
		form.setMethod(Http.GET);
		form.setAction("www.sailarize.com/forms");

		AssertSerialization.assertEquals("Unexpected serialization of a base form", "forms-base", form);

	}

	/**
	 * Test the serialization of a form with a title.
	 */
	@Test
	public void title() {

		Form form = new Form();
		form.setId("form");
		form.setMethod(Http.PATCH);
		form.setAction("www.sailarize.com/forms");
		form.setTitle("Title");

		AssertSerialization.assertEquals("Unexpected serialization of a form with a title", "forms-title", form);

	}

	/**
	 * Test the serialization of a form with inputs.
	 */
	@Test
	public void inputs() {

		Form form = new Form();
		form.setId("form");
		form.setMethod(Http.PATCH);
		form.setAction("www.sailarize.com/forms");
		form.add(new FormInput("a.field"));
		form.add(new FormInput("another.field"));

		AssertSerialization.assertEquals("Unexpected serialization of a form with inputs", "forms-inputs", form);

	}

	/**
	 * Test the serialization of a form with headers.
	 */
	@Test
	public void headers() {

		Form form = new Form();
		form.setId("form");
		form.setMethod(Http.PATCH);
		form.setAction("www.sailarize.com/forms");
		form.addHeader("one", "1");
		form.addHeader("two", "2");

		AssertSerialization.assertEquals("Unexpected serialization of a form with headers", "forms-headers", form);

	}
	
	/**
	 * Test the serialization of a full form.
	 */
	@Test
	public void full() {

		Form form = new Form();
		form.setId("form");
		form.setMethod(Http.PATCH);
		form.setAction("www.sailarize.com/forms");
		form.setTitle("Title");
		form.addHeader("one", "1");
		form.addHeader("two", "2");
		form.add(new FormInput("a.field"));
		form.add(new FormInput("another.field"));
		
		AssertSerialization.assertEquals("Unexpected serialization of a full form", "forms-full", form);

	}
}
