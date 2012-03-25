package com.fathomdb.cli;

public interface CliHandler {

    CliOptions buildOptionsBean();

    CliContext buildContext(CliOptions options) throws Exception;

}
