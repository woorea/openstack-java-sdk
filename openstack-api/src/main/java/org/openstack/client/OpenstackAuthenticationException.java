package org.openstack.client;

public class OpenstackAuthenticationException extends OpenstackException {
    private static final long serialVersionUID = 1L;

    public OpenstackAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public OpenstackAuthenticationException(String message) {
        super(message);
    }

}
