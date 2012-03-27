package org.openstack.console.output;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.console.common.formatter.SimpleFormatter;
import org.openstack.console.common.output.OutputSink;
import org.openstack.model.compute.SecurityGroup;
import org.openstack.model.compute.nova.securitygroup.NovaSecurityGroup;

import com.google.common.collect.Maps;

public class SecurityGroupFormatter extends SimpleFormatter<SecurityGroup> {

    public SecurityGroupFormatter() {
        super(NovaSecurityGroup.class);
    }

    @Override
    public void visit(SecurityGroup o, OutputSink sink) throws IOException {
        LinkedHashMap<String, Object> values = Maps.newLinkedHashMap();

        values.put("id", o.getId());
        values.put("name", o.getName());
        values.put("description", o.getDescription());

        sink.outputRow(values);
    }
}
