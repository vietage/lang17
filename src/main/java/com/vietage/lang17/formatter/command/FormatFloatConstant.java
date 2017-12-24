package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.FloatConstant;

import java.util.Queue;

public class FormatFloatConstant extends FormatCommand {

    public FormatFloatConstant(int indent, FloatConstant floatConstant) {
        super(indent);
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {

    }
}
