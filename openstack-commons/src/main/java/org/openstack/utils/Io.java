package org.openstack.utils;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility functions to do with IO
 * 
 * @author justinsb
 * 
 */
public class Io {
    static final Logger log = Logger.getLogger(Io.class.getName());

    public static void safeClose(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            logError("Ignoring unexpected error closing item", e);
        }
    }

    static final void logError(String message, Throwable e) {
        log.log(Level.SEVERE, message, e);
    }
}
