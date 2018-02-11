package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.AdditionExpression;
import com.vietage.lang17.parser.ast.expression.AndExpression;
import com.vietage.lang17.parser.ast.expression.ArrayAllocation;
import com.vietage.lang17.parser.ast.expression.ArrayRead;
import com.vietage.lang17.parser.ast.expression.BooleanConstant;
import com.vietage.lang17.parser.ast.expression.EqualityExpression;
import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.ast.expression.FloatConstant;
import com.vietage.lang17.parser.ast.expression.FunctionCall;
import com.vietage.lang17.parser.ast.expression.IntegerConstant;
import com.vietage.lang17.parser.ast.expression.MultiplicationExpression;
import com.vietage.lang17.parser.ast.expression.OperatorPrecedence;
import com.vietage.lang17.parser.ast.expression.OrExpression;
import com.vietage.lang17.parser.ast.expression.RelationalExpression;
import com.vietage.lang17.parser.ast.expression.StringConstant;
import com.vietage.lang17.parser.ast.expression.UnaryExpression;
import com.vietage.lang17.parser.ast.expression.VariableRead;

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
    public void visit(UnaryExpression unaryExpression) {
        commandQueue.add(new FormatUnaryExpression(indent, unaryExpression, parentOperatorPrecedence));
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
    public void visit(MultiplicationExpression multiplicationExpression) {
        commandQueue.add(new FormatMultiplicationExpression(
                indent, multiplicationExpression, parentOperatorPrecedence));
    }

    @Override
    public void visit(OrExpression orExpression) {
        commandQueue.add(new FormatOrExpression(indent, orExpression, parentOperatorPrecedence));
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

    @Override
    public void visit(ArrayRead arrayRead) {
        commandQueue.add(new FormatArrayRead(indent, arrayRead));
    }

    @Override
    public void visit(ArrayAllocation arrayAllocation) {
        commandQueue.add(new FormatArrayAllocation(indent, arrayAllocation));
    }

    @Override
    public void visit(AndExpression andExpression) {
        commandQueue.add(new FormatAndExpression(indent, andExpression, parentOperatorPrecedence));
    }
}
