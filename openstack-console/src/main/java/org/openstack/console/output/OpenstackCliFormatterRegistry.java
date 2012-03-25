package org.openstack.console.output;

import org.openstack.console.common.formatter.FormatterRegistryBase;

public class OpenstackCliFormatterRegistry extends FormatterRegistryBase {

    public OpenstackCliFormatterRegistry() {
        addDefaultFormatters();
        discoverFormatters(getClass().getPackage());
    }

}
