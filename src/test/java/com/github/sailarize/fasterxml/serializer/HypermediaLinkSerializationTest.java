package com.github.sailarize.fasterxml.serializer;

import org.junit.Test;

import com.github.sailarize.fasterxml.test.assertion.AssertSerialization;
import com.github.sailarize.link.HypermediaLink;

/**
 * Unit test for the serialzation of {@link HypermediaLink}.
 * 
 * @author agusmunioz
 *
 */
public class HypermediaLinkSerializationTest {

	/**
	 * Test the serialization of a link with only rel and href values.
	 */
	@Test
	public void baseLink() {

		HypermediaLink link = new HypermediaLink();
		link.setHref("www.sailarize.com/alink");
		link.setRel("rel");

		AssertSerialization.assertEquals("Unexpected serialization of a base link.", "links-base", link);
	}

	/**
	 * Test the serialization of a link with a title.
	 */
	@Test
	public void title() {

		HypermediaLink link = new HypermediaLink();
		link.setHref("www.sailarize.com/alink");
		link.setRel("rel");
		link.setTitle("aTitle");

		AssertSerialization.assertEquals("Unexpected serialization of a link with title.", "links-title", link);
	}

	/**
	 * Test the serialization of a link with a type.
	 */
	@Test
	public void type() {

		HypermediaLink link = new HypermediaLink();
		link.setHref("www.sailarize.com/alink");
		link.setRel("rel");
		link.setType("application/vnd.sail+json;version=1.0");

		AssertSerialization.assertEquals("Unexpected serialization of a link with type.", "links-type", link);

	}

	/**
	 * Test the serialization of a link with data fields.
	 */
	@Test
	public void data() {

		HypermediaLink link = new HypermediaLink();
		link.setHref("www.sailarize.com/alink");
		link.setRel("rel");
		link.addData("one", "1");
		link.addData("two", "2");

		AssertSerialization.assertEquals("Unexpected serialization of a link with data.", "links-data", link);

	}

	/**
	 * Test the serialization of a link with headers.
	 */
	@Test
	public void headers() {

		HypermediaLink link = new HypermediaLink();
		link.setHref("www.sailarize.com/alink");
		link.setRel("rel");
		link.addHeader("one", "1");
		link.addHeader("two", "2");

		AssertSerialization.assertEquals("Unexpected serialization of a link with headers.", "links-headers", link);

	}

	/**
	 * Test the serialization of a link with all fields and information set.
	 */
	@Test
	public void full() {

		HypermediaLink link = new HypermediaLink();
		link.setHref("www.sailarize.com/alink");
		link.setRel("rel");
		link.setTitle("aTitle");
		link.setType("application/vnd.sail+json;version=1.0");
		link.addData("one", "1");
		link.addData("two", "2");
		link.addHeader("one", "1");
		link.addHeader("two", "2");

		AssertSerialization.assertEquals("Unexpected serialization of a full link.", "links-full", link);

	}
}
