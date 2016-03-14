package com.github.sailarize.jackson.config;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.github.sailarize.jackson.serializer.SailResourceSerializer;
import com.github.sailarize.resource.SailResource;

/**
 * A {@link BeanSerializerModifier} that allows the correctly initialization of
 * Sail serializers.
 * 
 * @author agusmunioz
 *
 */
public class SailBeanSerializerModifier extends BeanSerializerModifier {

	@Override
	public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc,
			JsonSerializer<?> serializer) {

		if (SailResource.class.isAssignableFrom(beanDesc.getBeanClass())) {
			return new SailResourceSerializer((BeanSerializerBase) serializer);
		}

		return serializer;
	}
}
