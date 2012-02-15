package com.fathomdb.cli.autocomplete;

import java.util.List;

import com.fathomdb.cli.CliContext;

public abstract class SimpleArgumentAutoCompleter {

    public abstract List<String> doComplete(CliContext context, String prefix) throws Exception;

    protected String safeGet(List<String> items, int i) {
        if (items.size() > i) {
            return items.get(i);
        } else {
            return "";
        }
    }

    public static void addSuffix(List<String> items, String suffix) {
        for (int i = 0; i < items.size(); i++) {
            String item = items.get(i);
            item += suffix;
            items.set(i, item);
        }
    }

    public static void addPrefix(List<String> items, String prefix) {
        for (int i = 0; i < items.size(); i++) {
            String item = items.get(i);
            item = prefix + item;
            items.set(i, item);
        }
    }
}
