package com.fathomdb.cli.autocomplete;

import java.util.Collections;
import java.util.List;


import com.fathomdb.cli.CliContext;
import com.google.common.collect.Lists;

public class AutoCompletion {
    final List<String> completions = Lists.newArrayList();
    public CliContext context;
    public int wordIndex;
    public List<String> words;

    public void finish() {
        Collections.sort(completions);
        int i = 1;
        while (i < completions.size()) {
            String current = completions.get(i);
            String previous = completions.get(i - 1);
            if (current.equals(previous)) {
                completions.remove(i);
            } else {
                i++;
            }
        }
    }

    public List<String> getCompletions() {
        return completions;
    }

    public void addAll(List<String> items, String prefix) {
        for (String item : items) {
            if (prefix != null && !item.startsWith(prefix)) {
                continue;
            }

            completions.add(item);
        }
    }

}
