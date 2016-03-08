package com.github.sailarize.fasterxml.serializer;

import org.junit.Test;

import com.github.sailarize.fasterxml.test.assertion.AssertSerialization;
import com.github.sailarize.fasterxml.test.mocks.PersonMock;
import com.github.sailarize.form.FormBuilder;
import com.github.sailarize.link.LinkBuilder;

/**
 * Unit test for {@link SailJsonSerializer}.
 * 
 * @author agusmunioz
 *
 */
public class SailJsonSerializerTest {

	/**
	 * Test the serialization of a base resource, that is to say, it doesn't
	 * define any hypermedia control.
	 */
	@Test
	public void base() {

		AssertSerialization.assertEquals("Unexpected base resource serialization", "resource_base",
				new PersonMock("1", "Agus", 34));

	}

	/**
	 * Test the serialization of a resource with several links.
	 */
	@Test
	public void links() {

		PersonMock person = new PersonMock("1", "Agus", 34);

		person.add(new LinkBuilder(new PersonMock("2", "Barby", 34), "wife").build());

		person.add(new LinkBuilder(PersonMock.class, "cousines").filter("cousines", "1").build(), "relatives");

		person.add(new LinkBuilder(PersonMock.class, "uncles").filter("uncles", "1").build(), "relatives");

		AssertSerialization.assertEquals("Unexpected resource with links serialization", "resource_links", person);
	}

	/**
	 * Test the serialization of a resource with several forms.
	 */
	@Test
	public void forms() {

		PersonMock person = new PersonMock("1", "Agus", 34);

		person.add(FormBuilder.update(person).number("age").build());

		person.add(FormBuilder.update(person).number("wife").build(), "relatives");

		AssertSerialization.assertEquals("Unexpected resource with forms serialization", "resource_forms", person);
	}

	/**
	 * Test the serialization of a resource with meta information.
	 */
	@Test
	public void meta() {

		PersonMock person = new PersonMock("1", "Agus", 34);

		person.meta("aMeta", "123");

		person.meta("anotherMeta", "456");

		AssertSerialization.assertEquals("Unexpected resource with meta serialization", "resource_meta", person);

	}

	/**
	 * Test the serialization of a resource with links, forms and meta.
	 */
	@Test
	public void full() {

		PersonMock person = new PersonMock("1", "Agus", 34);

		person.add(new LinkBuilder(new PersonMock("2", "Barby", 34), "wife").build());

		person.add(new LinkBuilder(PersonMock.class, "cousines").filter("cousines", "1").build(), "relatives");

		person.add(new LinkBuilder(PersonMock.class, "uncles").filter("uncles", "1").build(), "relatives");

		person.add(FormBuilder.update(person).number("age").build());

		person.add(FormBuilder.update(person).number("wife").build(), "relatives");

		person.meta("aMeta", "123");

		person.meta("anotherMeta", "456");

		AssertSerialization.assertEquals("Unexpected resource with each type of hypermedia controls serialization",
				"resource_full", person);
	}
}
