package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.*;

import java.util.Queue;

public class FormatExpression extends FormatCommand implements Expression.Visitor {

    private final Expression expression;
    private final OperatorPrecedence parentOperatorPrecedence;

    private Queue<FormatCommand> commandQueue;

    public FormatExpression(int indent, Expression expression, OperatorPrecedence parentOperatorPrecedence) {
        super(indent);
        this.expression = expression;
        this.parentOperatorPrecedence = parentOperatorPrecedence;
    }

    public FormatExpression(int indent, Expression expression) {
        super(indent);
        this.expression = expression;
        this.parentOperatorPrecedence = OperatorPrecedence.OR;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        this.commandQueue = commandQueue;

        expression.accept(this);
    }

    @Override
    public void visit(FunctionCall functionCall) {
        commandQueue.add(new FormatFunctionCall(indent, functionCall));
    }

    @Override
    public void visit(BooleanConstant booleanConstant) {
        commandQueue.add(new FormatBooleanConstant(indent, booleanConstant));
    }

    @Override
    public void visit(StringConstant stringConstant) {
        commandQueue.add(new FormatStringConstant(indent, stringConstant));
    }

    @Override
    public void visit(IntegerConstant integerConstant) {
        commandQueue.add(new FormatIntegerConstant(indent, integerConstant));
    }

    @Override
    public void visit(FloatConstant floatConstant) {
        commandQueue.add(new FormatFloatConstant(indent, floatConstant));
    }

    @Override
    public void visit(VariableRead variableRead) {
        commandQueue.add(new FormatVariableRead(indent, variableRead));
    }

    @Override
    public void visit(ArrayRead arrayRead) {
        commandQueue.add(new FormatArrayRead(indent, arrayRead));
    }

    @Override
    public void visit(ArrayAllocation arrayAllocation) {
        commandQueue.add(new FormatArrayAllocation(indent, arrayAllocation));
    }

    @Override
    public void visit(UnaryExpression unaryExpression) {
        commandQueue.add(new FormatUnaryExpression(indent, unaryExpression));
    }

    @Override
    public void visit(OrExpression orExpression) {
        commandQueue.add(new FormatOrExpression(indent, orExpression, parentOperatorPrecedence));
    }

    @Override
    public void visit(AndExpression andExpression) {
        commandQueue.add(new FormatAndExpression(indent, andExpression, parentOperatorPrecedence));
    }

    @Override
    public void visit(MultiplicationExpression multiplicationExpression) {
        commandQueue.add(new FormatMultiplicationExpression(
                indent, multiplicationExpression, parentOperatorPrecedence));
    }

    @Override
    public void visit(AdditionExpression additionExpression) {
        commandQueue.add(new FormatAdditionExpression(indent, additionExpression, parentOperatorPrecedence));
    }

    @Override
    public void visit(RelationalExpression relationalExpression) {
        commandQueue.add(new FormatRelationalExpression(indent, relationalExpression, parentOperatorPrecedence));
    }

    @Override
    public void visit(EqualityExpression equalityExpression) {
        commandQueue.add(new FormatEqualityExpression(indent, equalityExpression, parentOperatorPrecedence));
    }
}
