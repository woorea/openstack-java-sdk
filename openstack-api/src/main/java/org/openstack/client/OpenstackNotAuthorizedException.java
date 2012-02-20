package org.openstack.client;

public class OpenstackNotAuthorizedException extends OpenstackException {
    private static final long serialVersionUID = 1L;

    public OpenstackNotAuthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

    public OpenstackNotAuthorizedException(String message) {
        super(message);
    }

}
