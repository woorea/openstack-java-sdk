package org.openstack.console.common.formatter;


public interface FormatterRegistry {

    Formatter getFormatter(Class<? extends Object> class1);

}
