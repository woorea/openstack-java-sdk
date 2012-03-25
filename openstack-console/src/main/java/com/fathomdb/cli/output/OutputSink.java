package com.fathomdb.cli.output;

import java.io.IOException;
import java.util.Map;

public interface OutputSink {
    void visitObject(Object o) throws IOException;

    void outputRow(Map<String, Object> values);

    void flush();

    void finishOutput();

}
