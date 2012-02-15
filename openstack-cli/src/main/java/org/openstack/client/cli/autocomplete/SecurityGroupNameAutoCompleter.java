package org.openstack.client.cli.autocomplete;

import java.util.List;

import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.compute.TenantResource;
import org.openstack.model.compute.SecurityGroup;
import com.fathomdb.cli.CliContext;
import com.fathomdb.cli.autocomplete.SimpleArgumentAutoCompleter;

import com.google.common.collect.Lists;

public class SecurityGroupNameAutoCompleter extends SimpleArgumentAutoCompleter {

    @Override
    public List<String> doComplete(CliContext context, String prefix) throws Exception {
        List<String> strings = Lists.newArrayList();

        OpenstackCliContext osContext = (OpenstackCliContext) context;
        TenantResource computeClient = osContext.getComputeClient();
        List<SecurityGroup> securityGroups = computeClient.securityGroups().list().getList();
        for (SecurityGroup securityGroup : securityGroups) {
            strings.add(securityGroup.getName());
        }
        addSuffix(strings, " ");

        return strings;
    }

}
