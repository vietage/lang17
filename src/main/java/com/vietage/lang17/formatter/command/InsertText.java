package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;

import java.util.Queue;

public class InsertText extends FormatCommand {

    private final String text;

    public InsertText(int indent, String text) {
        super(indent);
        this.text = text;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        out.print(text, indent);
    }
}
