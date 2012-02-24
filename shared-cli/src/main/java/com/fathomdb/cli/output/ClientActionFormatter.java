package com.fathomdb.cli.output;

public interface ClientActionFormatter<T> {
	ClientAction formatAction(T object);
}
