package com.github.sailarize.jackson.serializer;

import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;

/**
 * Adapter class for Sail serializers that need to serialize an object as
 * regular bean, and then perform a special serialization in the same Json, like
 * adding extra fields.
 * 
 * @author agusmunioz
 *
 */
public abstract class BeanSerializerAdapter extends BeanSerializerBase {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates an intialized {@link SailResourceSerializer}.
	 * 
	 * @param source
	 */
	public BeanSerializerAdapter(BeanSerializerBase source) {
		super(source);
	}

	@Override
	public BeanSerializerBase withObjectIdWriter(ObjectIdWriter objectIdWriter) {
		throw new UnsupportedOperationException("This operation is not supported");
	}

	@Override
	protected BeanSerializerBase withIgnorals(String[] toIgnore) {
		throw new UnsupportedOperationException("This operation is not supported");
	}

	@Override
	protected BeanSerializerBase asArraySerializer() {
		throw new UnsupportedOperationException("This operation is not supported");
	}

	@Override
	public BeanSerializerBase withFilterId(Object filterId) {
		throw new UnsupportedOperationException("This operation is not supported");
	}
}
