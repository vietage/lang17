package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.FloatConstant;

import java.util.Queue;

public class FormatFloatConstant extends FormatCommand {

    private final FloatConstant floatConstant;

    public FormatFloatConstant(int indent, FloatConstant floatConstant) {
        super(indent);
        this.floatConstant = floatConstant;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        out.print(Double.toString(floatConstant.getValue()), indent);
    }
}
