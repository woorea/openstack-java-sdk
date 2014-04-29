package com.woorea.openstack.connector;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.jboss.resteasy.client.ClientExecutor;


public class RESTEasyInputStream extends FilterInputStream {

	protected ClientExecutor clientExecutor;

	public RESTEasyInputStream(InputStream inputStream, ClientExecutor clientExecutor) {
		super(inputStream);
		this.clientExecutor = clientExecutor;
	}

	@Override
	public void close() throws IOException {
		try {
			clientExecutor.close();
		} catch (Exception e) {
			// Silently skip errors in the socket close errors
		}

		try {
			super.close();
		} catch (SocketException e) {
			// We expect this exception because the socket is closed
		} catch (IllegalStateException e) {
			// We expect this exception because the socket is closed (httpclient 4.2)
		}
	}

}
