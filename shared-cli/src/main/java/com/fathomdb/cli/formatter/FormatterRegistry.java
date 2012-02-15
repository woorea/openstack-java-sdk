package com.fathomdb.cli.formatter;


public interface FormatterRegistry {

    Formatter getFormatter(Class<? extends Object> class1);

}
