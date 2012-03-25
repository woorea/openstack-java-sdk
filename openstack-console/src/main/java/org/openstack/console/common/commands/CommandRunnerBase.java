package org.openstack.console.common.commands;

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.spi.OptionHandler;
import org.kohsuke.args4j.spi.Setter;
import org.openstack.console.common.CliContext;
import org.openstack.console.common.autocomplete.AutoCompletor;
import org.openstack.console.common.autocomplete.HasAutoCompletor;
import org.openstack.console.common.autocomplete.SimpleArgumentAutoCompleter;
import org.openstack.console.common.autocomplete.SimpleAutoCompleter;
import org.openstack.console.common.output.FormattedList;

import com.google.common.collect.Lists;

public abstract class CommandRunnerBase implements CommandRunner, Cloneable {

    final List<CommandSpecifier> commands;
    CliContext context;

    // @Option(name = "-h", aliases = "--help", usage = "displays this help command")
    // protected boolean showHelp = false;

    protected CliContext getContext() {
        return context;
    }

    protected CommandRunnerBase(String verb, String noun) {
        this(CommandSpecifier.build(verb, noun));
    }

    protected CommandRunnerBase(CommandSpecifier commandSpecifier) {
        commands = new ArrayList<CommandSpecifier>();
        commands.add(commandSpecifier);
    }

    @Override
    public List<CommandSpecifier> getHandledComands() {
        return commands;
    }

    @Override
    public CommandRunner clone(CliContext context) {
        try {
            CommandRunnerBase runner = (CommandRunnerBase) super.clone();
            runner.context = context;
            return runner;
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Error cloning command", e);
        }
    }

    @Override
    public void parseArguments(List<String> args) throws Exception {
        CmdLineParser parser = new CmdLineParser(this);

        String[] argsArray = (String[]) args.toArray(new String[args.size()]);
        parser.parseArgument(argsArray);
    }

    public void formatRaw(Object o, PrintWriter writer) {
        Object write = o;
        if (!(write instanceof Iterable)) {
            List list = Lists.newArrayList();
            list.add(o);
            write = list;
        }
        FormattedList<?> list = FormattedList.build(context.getFormatterRegistry(), (Iterable) write, false);
        writer.print(list.toString());
    }

    @Override
    public AutoCompletor getAutoCompleter() {
        List<SimpleArgumentAutoCompleter> completers = Lists.newArrayList();

        List<OptionHandler> arguments;

        try {
            CmdLineParser parser = new CmdLineParser(this);
            Field argumentsField = CmdLineParser.class.getDeclaredField("arguments");
            argumentsField.setAccessible(true);
            arguments = (List<OptionHandler>) argumentsField.get(parser);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while building autocompleter", e);
        }

        for (OptionHandler argument : arguments) {
            SimpleArgumentAutoCompleter completer = null;
            Setter setter = argument.setter;
            Class<?> fieldType = setter.getType();

            HasAutoCompletor autoCompleter = fieldType.getAnnotation(HasAutoCompletor.class);
            if (autoCompleter != null) {
                try {
                    completer = autoCompleter.value().newInstance();
                } catch (Exception e) {
                    throw new IllegalArgumentException("Error while building autocompleter", e);
                }
            }
            completers.add(completer);
        }

        return new SimpleAutoCompleter(completers);
    }
    // protected static String getOptionsHelp(CmdLineParser parser) {
    // StringWriter writer = new StringWriter();
    // parser.printUsage(writer, null);
    // return writer.toString();
    // }

    // @Override
    // public Object runCommand(CliContext context, String arguments) throws Exception {
    // // CmdLineParser parser = new CmdLineParser(this);
    // //
    // // try {
    // // if (arguments != null) {
    // // // TODO: Cope with quotes...
    // // String[] args = arguments.split(" ");
    // // parser.parseArgument(args);
    // // } else {
    // // parser.parseArgument(new String[0]);
    // // }
    // // } catch (CmdLineException e) {
    // // // Message is pre-formatted for us
    // // throw new CommandException(e.getMessage());
    // // }
    //
    // // if (showHelp) {
    // // String help = getOptionsHelp(parser);
    // // return help;
    // // }
    //
    // return runCommand0(context, arguments);
    // }

    // protected abstract Object runCommand0(CliContext context, String arguments) throws Exception;
}
