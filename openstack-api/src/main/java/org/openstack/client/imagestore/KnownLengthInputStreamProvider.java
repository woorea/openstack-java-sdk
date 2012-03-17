package org.openstack.client.imagestore;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.glassfish.jersey.message.internal.AbstractMessageReaderWriterProvider;

@Produces({ "application/octet-stream", "*/*" })
@Consumes({ "application/octet-stream", "*/*" })
public final class KnownLengthInputStreamProvider extends AbstractMessageReaderWriterProvider<KnownLengthInputStream> {

	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return false;
	}

	public KnownLengthInputStream readFrom(Class<KnownLengthInputStream> type, Type genericType, Annotation annotations[],
			MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException {
		throw new UnsupportedOperationException();
	}

	public boolean isWriteable(Class<?> type, Type genericType, Annotation annotations[], MediaType mediaType) {
		return KnownLengthInputStream.class.isAssignableFrom(type);
	}

	@Override
	public long getSize(KnownLengthInputStream t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		if (t instanceof KnownLengthInputStream)
			return ((KnownLengthInputStream) t).getLength();
		else
			throw new UnsupportedOperationException();
	}

	public void writeTo(KnownLengthInputStream t, Class<?> type, Type genericType, Annotation annotations[], MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException {
		try {
			writeTo(t, entityStream);
		} finally {
			t.close();
		}
	}

}