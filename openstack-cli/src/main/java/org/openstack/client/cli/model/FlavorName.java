package org.openstack.client.cli.model;

import java.util.List;

import org.openstack.client.OpenstackException;
import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.cli.autocomplete.FlavorNameAutoCompleter;
import org.openstack.model.compute.Flavor;

import com.fathomdb.cli.StringWrapper;
import com.fathomdb.cli.autocomplete.HasAutoCompletor;

import com.google.common.collect.Lists;

@HasAutoCompletor(FlavorNameAutoCompleter.class)
public class FlavorName extends StringWrapper {
    public FlavorName(String key) {
        super(key);
    }

    public String findImageId(OpenstackCliContext context) throws OpenstackException {
        List<Flavor> matches = Lists.newArrayList();
        for (Flavor flavor : context.getFlavors()) {
            if (flavor.getName().equals(getKey())) {
                matches.add(flavor);
            } else if (flavor.getName().equals(getKey())) {
                matches.add(flavor);
            }
        }

        if (matches.size() == 0)
            return null;

        if (matches.size() != 1) {
            throw new IllegalArgumentException("Image name is ambiguous");
        }

        return matches.get(0).getId();
    }
}
