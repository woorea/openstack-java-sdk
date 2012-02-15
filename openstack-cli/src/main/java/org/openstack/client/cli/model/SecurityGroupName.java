package org.openstack.client.cli.model;

import org.openstack.client.cli.autocomplete.SecurityGroupNameAutoCompleter;

import com.fathomdb.cli.StringWrapper;
import com.fathomdb.cli.autocomplete.HasAutoCompletor;

@HasAutoCompletor(SecurityGroupNameAutoCompleter.class)
public class SecurityGroupName extends StringWrapper {

    public SecurityGroupName(String key) {
        super(key);
    }
}
