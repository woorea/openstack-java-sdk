package org.openstack.console.common.autocomplete;

import java.util.Arrays;
import java.util.List;

public class SimpleAutoCompleter extends AutoCompletor {
    final List<SimpleArgumentAutoCompleter> argumentCompleters;

    public SimpleAutoCompleter(List<SimpleArgumentAutoCompleter> argumentCompleters) {
        this.argumentCompleters = argumentCompleters;
    }

    public SimpleAutoCompleter(SimpleArgumentAutoCompleter... argumentCompleters) {
        this.argumentCompleters = Arrays.asList(argumentCompleters);
    }

    @Override
    public void doComplete(AutoCompletion autoComplete) throws Exception {
        String word = "";
        if (autoComplete.words.size() > autoComplete.wordIndex) {
            word = autoComplete.words.get(autoComplete.wordIndex);
        }

        int arg = autoComplete.wordIndex - 1;
        if (arg >= 0 && argumentCompleters.size() > arg) {
            SimpleArgumentAutoCompleter simpleAutoCompletor = argumentCompleters.get(arg);
            if (simpleAutoCompletor != null) {
                List<String> completions = simpleAutoCompletor.doComplete(autoComplete.context, word);
                if (completions != null) {
                    autoComplete.addAll(completions, word);
                }
            }
        }
    }

}
