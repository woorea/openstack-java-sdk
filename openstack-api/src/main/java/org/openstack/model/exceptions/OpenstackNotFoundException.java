package org.openstack.model.exceptions;

public class OpenstackNotFoundException extends OpenstackException {
    private static final long serialVersionUID = 1L;

    public OpenstackNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OpenstackNotFoundException(String message) {
        super(message);
    }

}
