package org.openstack.console.common.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandSpecifier {
    final String verb;
    final String noun;

    public CommandSpecifier(String verb, String noun) {
        super();
        this.verb = verb;
        this.noun = noun;
    }

    public List<String> getStrings() {
        List<String> strings = new ArrayList<String>();
        strings.add(verb + "-" + noun);
        strings.add(verb + noun);
        return strings;
    }

    public static CommandSpecifier build(String verb, String noun) {
        return new CommandSpecifier(verb, noun);
    }
}
