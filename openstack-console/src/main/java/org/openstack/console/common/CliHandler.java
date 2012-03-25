package org.openstack.console.common;

public interface CliHandler {

    CliOptions buildOptionsBean();

    CliContext buildContext(CliOptions options) throws Exception;

}
