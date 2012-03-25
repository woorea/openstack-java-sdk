package org.openstack.console.common.commands;

import java.io.PrintWriter;
import java.util.List;

import org.kohsuke.args4j.Argument;
import org.openstack.console.common.autocomplete.AutoCompletion;
import org.openstack.console.common.autocomplete.AutoCompletor;
import org.openstack.console.common.autocomplete.SimpleArgumentAutoCompleter;


public class AutoComplete extends CommandRunnerBase {
    @Argument
    public List<String> args;

    public AutoComplete() {
        super("auto", "complete");
    }

    @Override
    public Object runCommand() throws Exception {
        int cword = Integer.parseInt(args.get(0));
        List<String> words = args.subList(1, args.size());

        AutoCompletion autoComplete = new AutoCompletion();
        autoComplete.context = context;
        autoComplete.wordIndex = cword - 1;
        autoComplete.words = words;

        if (cword == 1) {
            List<String> commands = context.getCommandRegistry().listCommands();

            commands.remove("auto-complete");

            SimpleArgumentAutoCompleter.addSuffix(commands, " ");

            String prefix = words.size() == 0 ? "" : words.get(0);
            autoComplete.addAll(commands, prefix);
        }

        if (words.size() >= 1) {
            String command = words.get(0);

            CommandRunner commandRunner = context.getCommandRegistry().getCommandRunner(command);
            if (commandRunner != null) {
                AutoCompletor completor = commandRunner.getAutoCompleter();
                if (completor != null) {
                    completor.doComplete(autoComplete);
                }
            }
        }

        autoComplete.finish();
        return autoComplete;
    }

    @Override
    public void formatRaw(Object o, PrintWriter writer) {
        AutoCompletion items = (AutoCompletion) o;
        for (String item : items.getCompletions()) {
            writer.println(item);
        }
    }

}
