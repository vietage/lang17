package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.IntegerConstant;

import java.util.Queue;

public class FormatIntegerConstant extends FormatCommand {

    private final IntegerConstant integerConstant;

    public FormatIntegerConstant(int indent, IntegerConstant integerConstant) {
        super(indent);
        this.integerConstant = integerConstant;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        out.print(Long.toString(integerConstant.getValue()), indent);
    }
}
