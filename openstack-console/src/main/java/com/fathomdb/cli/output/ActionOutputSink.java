package com.fathomdb.cli.output;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import com.fathomdb.cli.formatter.DefaultFormatter;
import com.fathomdb.cli.formatter.Formatter;
import com.fathomdb.cli.formatter.FormatterRegistry;

public class ActionOutputSink implements OutputSink {

	private final PrintWriter out;
	private final FormatterRegistry formatterRegistry;

	public ActionOutputSink(FormatterRegistry formatterRegistry, PrintWriter out) {
		this.formatterRegistry = formatterRegistry;
		this.out = out;
	}

	@Override
	public void visitObject(Object o) throws IOException {
		Formatter formatter = formatterRegistry.getFormatter(o.getClass());
		if (formatter == null) {
			formatter = DefaultFormatter.INSTANCE;
		}

		formatClientAction(formatter, o);
	}

	<T> void formatClientAction(Formatter formatter, T object) {
		if (formatter instanceof ClientActionFormatter) {
			ClientActionFormatter<T> clientActionFormatter = (ClientActionFormatter<T>) formatter;
			ClientAction clientAction = clientActionFormatter.formatAction(object);

			out.println(clientAction.getAction().toString().toLowerCase() + " " + clientAction.getParameter());
		} else {
			throw new UnsupportedOperationException("Cannot format for action");
		}
	}

	@Override
	public void outputRow(Map<String, Object> values) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void flush() {
		out.flush();
	}

	@Override
	public void finishOutput() {
	}

	public PrintWriter getWriter() {
		return out;
	}

}
