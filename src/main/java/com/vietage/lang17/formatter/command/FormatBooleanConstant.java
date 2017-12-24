package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.BooleanConstant;

import java.util.Queue;

public class FormatBooleanConstant extends FormatCommand {

    private final BooleanConstant booleanConstant;

    public FormatBooleanConstant(int indent, BooleanConstant booleanConstant) {
        super(indent);
        this.booleanConstant = booleanConstant;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        out.print(booleanConstant.isValue() ? "true" : "false", indent);
    }
}
