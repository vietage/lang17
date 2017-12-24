package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.StringConstant;

import java.util.Queue;

public class FormatStringConstant extends FormatCommand {

    private final StringConstant stringConstant;

    public FormatStringConstant(int indent, StringConstant stringConstant) {
        super(indent);
        this.stringConstant = stringConstant;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        out.print("\"" + stringConstant.getValue() + "\"", indent);
    }
}
