package com.fathomdb.cli;

import java.lang.reflect.Constructor;
import java.text.MessageFormat;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.OptionHandler;
import org.kohsuke.args4j.spi.Parameters;
import org.kohsuke.args4j.spi.Setter;

public class StringWrapperOptionHandler extends OptionHandler<StringWrapper> {

    private static final String ILLEGAL_OPERAND = "\"{1}\" is not a valid value for \"{0}\"";

    public StringWrapperOptionHandler(CmdLineParser parser, OptionDef option, Setter<? super StringWrapper> setter) {
        super(parser, option, setter);
    }

    @Override
    public int parseArguments(Parameters params) throws CmdLineException {
        String token = params.getParameter(0);
        try {
            Class<? super StringWrapper> fieldType = setter.getType();
            Constructor<? super StringWrapper> constructor = fieldType.getConstructor(String.class);
            StringWrapper o = (StringWrapper) constructor.newInstance(token);
            setter.addValue(o);
            return 1;
        } catch (Exception e) {
            throw new CmdLineException(MessageFormat.format(ILLEGAL_OPERAND, option.toString(), token));
        }
    }

    @Override
    public String getDefaultMetaVariable() {
        return "VAL";
    }
}
