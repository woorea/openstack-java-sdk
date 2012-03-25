package org.openstack.console.common.autocomplete;

import java.util.ArrayList;
import java.util.List;

import org.openstack.console.common.CliContext;


import com.google.common.collect.Lists;

public class AutoCompleteAction extends SimpleArgumentAutoCompleter {
    @Override
    public List<String> doComplete(CliContext client, String prefix) throws Exception {
        String[] operations = { "configure", "validate" };
        ArrayList<String> operationsList = Lists.newArrayList(operations);
        addSuffix(operationsList, " ");
        return operationsList;
    }

}
