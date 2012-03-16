package com.google.gwt.user.client.rpc.core.javax.xml.namespace;

import javax.xml.namespace.QName;

import com.google.gwt.user.client.rpc.CustomFieldSerializer;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public final class QName_CustomFieldSerializer extends
		CustomFieldSerializer<QName> {

	public static void deserialize(SerializationStreamReader streamReader,
			QName instance) throws SerializationException {

	}

	public static QName instantiate(SerializationStreamReader streamReader)
			throws SerializationException {
		return new QName("", "", "");
	}

	public static void serialize(SerializationStreamWriter streamWriter,
			QName instance) {

	}

	@Override
	public QName instantiateInstance(SerializationStreamReader streamReader)
			throws SerializationException {
		return QName_CustomFieldSerializer.instantiate(streamReader);
	}

	@Override
	public void deserializeInstance(SerializationStreamReader streamReader,
			QName instance) throws SerializationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void serializeInstance(SerializationStreamWriter streamWriter,
			QName instance) throws SerializationException {
		// TODO Auto-generated method stub

	}

}
