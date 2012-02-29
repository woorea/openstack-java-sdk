package org.openstack.utils;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Wrapper class that stops the wrapped input stream from being closed. Useful e.g. when you want to wrap the input
 * stream in a Reader
 * 
 */
public class NoCloseInputStream extends FilterInputStream {

    public NoCloseInputStream(InputStream is) {
        super(is);
    }

    @Override
    public void close() throws IOException {
    }
}
