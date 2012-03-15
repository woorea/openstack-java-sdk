package org.openstack.client.cli.output;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.model.compute.NovaSecurityGroup;
import com.fathomdb.cli.formatter.SimpleFormatter;
import com.fathomdb.cli.output.OutputSink;

import com.google.common.collect.Maps;

public class SecurityGroupFormatter extends SimpleFormatter<NovaSecurityGroup> {

    public SecurityGroupFormatter() {
        super(NovaSecurityGroup.class);
    }

    @Override
    public void visit(NovaSecurityGroup o, OutputSink sink) throws IOException {
        LinkedHashMap<String, Object> values = Maps.newLinkedHashMap();

        values.put("id", o.getId());
        values.put("name", o.getName());
        values.put("description", o.getDescription());

        sink.outputRow(values);
    }
}
