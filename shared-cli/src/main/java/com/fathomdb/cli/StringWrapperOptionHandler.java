package com.fathomdb.cli;

import java.lang.reflect.Constructor;
import java.text.MessageFormat;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.OptionHandler;
import org.kohsuke.args4j.spi.Parameters;
import org.kohsuke.args4j.spi.Setter;

public class StringWrapperOptionHandler<T> extends OptionHandler<T> {

	private static final String ILLEGAL_OPERAND = "\"{1}\" is not a valid value for \"{0}\"";

	public StringWrapperOptionHandler(CmdLineParser parser, OptionDef option, Setter<? super T> setter) {
		super(parser, option, setter);
	}

	@Override
	public int parseArguments(Parameters params) throws CmdLineException {
		String token = params.getParameter(0);
		try {
			Class<? super T> fieldType = setter.getType();
			Constructor<? super T> constructor = fieldType.getConstructor(String.class);
			T o = (T) constructor.newInstance(token);
			setter.addValue(o);
			return 1;
		} catch (SecurityException e) {
			throw new CmdLineException(owner, MessageFormat.format(ILLEGAL_OPERAND, option.toString(), token));
		} catch (ReflectiveOperationException e) {
			throw new CmdLineException(owner, MessageFormat.format(ILLEGAL_OPERAND, option.toString(), token));
		} catch (IllegalArgumentException e) {
			throw new CmdLineException(owner, MessageFormat.format(ILLEGAL_OPERAND, option.toString(), token));
		}
	}

	@Override
	public String getDefaultMetaVariable() {
		return "VAL";
	}
}
