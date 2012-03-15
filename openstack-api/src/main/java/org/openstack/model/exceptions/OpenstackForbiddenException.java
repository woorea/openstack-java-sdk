package org.openstack.model.exceptions;

public class OpenstackForbiddenException extends OpenstackException {
    private static final long serialVersionUID = 1L;

    public OpenstackForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public OpenstackForbiddenException(String message) {
        super(message);
    }

}
