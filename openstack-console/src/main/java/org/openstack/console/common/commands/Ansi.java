package org.openstack.console.common.commands;

import java.io.PrintWriter;

public class Ansi {

    static class AnsiWriter {
        private final PrintWriter writer;

        public AnsiWriter(PrintWriter writer) {
            this.writer = writer;
        }

        void escape(int code) {
            writer.write("\u001b[" + code + "m");
        }
    }

    public static abstract class Action {
        public abstract Action doAction(AnsiWriter writer);
    }

    public static final Action RESET = new Action() {
        @Override
        public Action doAction(AnsiWriter writer) {
            writer.escape(0);
            return null;
        }
    };

    public static final Action TEXT_COLOR_DEFAULT = new Action() {
        @Override
        public Action doAction(AnsiWriter writer) {
            writer.escape(39);
            return null;
        }
    };

    static class ColorAction extends Action {
        final int code;

        public ColorAction(int code) {
            this.code = code;
        }

        @Override
        public Action doAction(AnsiWriter writer) {
            writer.escape(code);
            return TEXT_COLOR_DEFAULT;
        }

    }

    public static final Action TEXT_COLOR_BLACK = new ColorAction(30);
    public static final Action TEXT_COLOR_RED = new ColorAction(31);
    public static final Action TEXT_COLOR_GREEN = new ColorAction(32);
    public static final Action TEXT_COLOR_YELLOW = new ColorAction(33);
    public static final Action TEXT_COLOR_BLUE = new ColorAction(34);
    public static final Action TEXT_COLOR_MAGENTA = new ColorAction(35);
    public static final Action TEXT_COLOR_CYAN = new ColorAction(36);
    public static final Action TEXT_COLOR_WHITE = new ColorAction(37);

    private final AnsiWriter writer;

    public Ansi(PrintWriter writer) {
        this.writer = new AnsiWriter(writer);
    }

    public void reset() {
        doAction(RESET);
    }

    public Action doAction(Action action) {
        return action.doAction(writer);
    }

    @Deprecated
    public Action setColorRed() {
        return doAction(TEXT_COLOR_RED);
    }

    @Deprecated
    public Action setColorGreen() {
        return doAction(TEXT_COLOR_GREEN);
    }

    @Deprecated
    public Action setColorYellow() {
        return doAction(TEXT_COLOR_YELLOW);
    }

    @Deprecated
    public Action setColorBlue() {
        return doAction(TEXT_COLOR_BLUE);
    }

    public void println(String s) {
        writer.writer.println(s);
    }

    // public static final String ANSI_RESET = "\u001B[0m";
    // public static final String ANSI_BLACK = "\u001B[30m";
    // public static final String ANSI_RED = "\u001B[31m";
    // public static final String ANSI_GREEN = "\u001B[32m";
    // public static final String ANSI_YELLOW = "\u001B[33m";
    // public static final String ANSI_BLUE = "\u001B[34m";
    // public static final String ANSI_PURPLE = "\u001B[35m";
    // public static final String ANSI_CYAN = "\u001B[36m";
    // public static final String ANSI_WHITE = "\u001B[37m";
    // // TODO Auto-generated method stub
    //
    // }

}
