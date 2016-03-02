package com.github.sailarize.fasterxml.test.assertion;

import org.junit.Assert;

import com.github.sailarize.fasterxml.test.json.JsonUtils;

/**
 * Asserts about serializations.
 * 
 * @author agusmunioz
 *
 */
public class AssertSerialization {

	/**
	 * Asserts an object is correctly serialized.
	 * 
	 * @param message
	 *            the message for assertion failure.
	 * @param file
	 *            the file holding the expected json
	 * @param object
	 *            the object to serialize.
	 */
	public static void assertEquals(String message, String file, Object object) {

		String expected = JsonUtils.json(file);

		String actual = JsonUtils.serialize(object);

		Assert.assertEquals(message, expected, actual);
	}

}
