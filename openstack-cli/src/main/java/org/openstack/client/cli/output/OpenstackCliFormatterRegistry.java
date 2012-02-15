package org.openstack.client.cli.output;

import com.fathomdb.cli.formatter.FormatterRegistryBase;

public class OpenstackCliFormatterRegistry extends FormatterRegistryBase {

    public OpenstackCliFormatterRegistry() {
        addDefaultFormatters();
        dicoverFormatters(getClass().getPackage());
    }

}
