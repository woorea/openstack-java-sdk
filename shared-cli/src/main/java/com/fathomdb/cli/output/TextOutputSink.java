package com.fathomdb.cli.output;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fathomdb.cli.formatter.DefaultFormatter;
import com.fathomdb.cli.formatter.Formatter;
import com.fathomdb.cli.formatter.FormatterRegistry;

public class TextOutputSink implements OutputSink {
    final PrintWriter out;
    final FormatterRegistry formatterRegistry;
    final boolean decorate;

    public TextOutputSink(FormatterRegistry formatterRegistry, PrintWriter out, boolean decorate) {
        super();
        this.formatterRegistry = formatterRegistry;
        this.out = out;
        this.decorate = decorate;
    }

    final LinkedHashMap<String, Column> columns = new LinkedHashMap<String, Column>();

    class Column {
        final String name;
        int maxWidth;

        public Column(String name) {
            super();
            this.name = name;
            maxWidth = name.length();
        }

        public void notifyValue(String value) {
            if (value != null)
                maxWidth = Math.max(maxWidth, value.length());
        }

        public int getMaxWidth() {
            return maxWidth;
        }

        public String getLabel() {
            return name;
        }

        public String getKey() {
            return name;
        }
    }

    class Row {
        final Map<Column, String> values;

        public Row(Map<Column, String> values) {
            super();
            this.values = values;
        }

        public String getValue(Column column) {
            return values.get(column);
        }
    }

    final List<Row> rows = new ArrayList<Row>();

    @Override
    public void visitObject(Object o) throws IOException {
        Formatter formatter = formatterRegistry.getFormatter(o.getClass());
        if (formatter == null) {
            formatter = DefaultFormatter.INSTANCE;
        }
        formatter.visitObject(o, this);
    }

    @Override
    public void outputRow(Map<String, Object> map) {
        Map<Column, String> rowValues = new HashMap<Column, String>();

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Column column = columns.get(key);
            if (column == null) {
                column = new Column(key);
                columns.put(key, column);
            }

            Object value = entry.getValue();
            String stringValue = toString(value);
            column.notifyValue(stringValue);
            rowValues.put(column, stringValue);
        }

        Row row = new Row(rowValues);
        rows.add(row);
    }

    static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss yyyy-MM-dd");

    private String toString(Object value) {
        if (value == null)
            return "-";

        if (value instanceof Calendar) {
            Calendar calendar = (Calendar) value;
            return DATE_FORMAT.format(calendar.getTime());
        }

        if (value instanceof Date) {
            Date date = (Date) value;
            return DATE_FORMAT.format(date);
        }

        return value.toString();
    }

    public void finishOutput() {
        // Do output
        if (rows.size() != 0) {
            if (decorate) {
                printSeparators();
                printColumnNames();
                printSeparators();
            }
            for (Row row : rows) {
                printRow(row);
            }
            if (decorate) {
                printSeparators();
            }
        }

        if (decorate) {
            out.print(rows.size() + " rows in set");
            out.println();
        }
    }

    void printRow(Row row) {
        for (Column column : columns.values()) {
            int width = column.getMaxWidth();

            if (decorate)
                out.print("| ");
            String value = row.getValue(column);

            int valueLength;
            if (value != null) {
                out.print(value);
                valueLength = value.length();
            } else {
                valueLength = 0;
            }
            for (int w = valueLength; w < width; w++) {
                out.print(" ");
            }
            out.print(" ");
        }
        if (decorate)
            out.print("| ");

        out.println();
    }

    void printColumnNames() {
        for (Column column : columns.values()) {
            int width = column.getMaxWidth();
            String name = column.getLabel();

            out.print("| ");
            int valueLength;
            if (name != null) {
                out.print(name);
                valueLength = name.length();
            } else {
                valueLength = 0;
            }
            for (int w = valueLength; w < width; w++) {
                out.print(" ");
            }
            out.print(" ");
        }
        out.print("|");
        out.println();
    }

    void printSeparators() {
        for (Column column : columns.values()) {
            int width = column.getMaxWidth();
            out.print("+");
            for (int i = 0; i < width + 2; i++)
                out.print('-');
        }
        out.print("+");
        out.println();
    }

    @Override
    public void flush() {
        out.flush();
    }
}
