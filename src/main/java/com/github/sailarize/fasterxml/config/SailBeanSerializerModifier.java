package com.github.sailarize.fasterxml.config;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.github.sailarize.fasterxml.serializer.SailJsonSerializer;
import com.github.sailarize.resource.SailResource;

/**
 * A {@link BeanSerializerModifier} that allows the correctly initialization of
 * a {@link SailJsonSerializer} with the default object serializer.
 * 
 * @author agusmunioz
 *
 */
public class SailBeanSerializerModifier extends BeanSerializerModifier {

	@Override
	@SuppressWarnings("unchecked")
	public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc,
			JsonSerializer<?> serializer) {

		if (SailResource.class.isAssignableFrom(beanDesc.getBeanClass())) {
			return new SailJsonSerializer((JsonSerializer<Object>) serializer);
		}

		return serializer;
	}
}
