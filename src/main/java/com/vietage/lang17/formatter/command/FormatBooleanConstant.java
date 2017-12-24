package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.BooleanConstant;

import java.util.Queue;

public class FormatBooleanConstant extends FormatCommand {

    public FormatBooleanConstant(int indent, BooleanConstant booleanConstant) {
        super(indent);
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {

    }
}
