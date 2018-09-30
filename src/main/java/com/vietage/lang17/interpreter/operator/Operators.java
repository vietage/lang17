package com.vietage.lang17.interpreter.operator;

import com.vietage.lang17.interpreter.result.Result;

public class Operators {

    private static final Operator MULTIPLICATION = new Multiplication();
    private static final Operator DIVISION = new Division();
    private static final Operator MODULO = new Modulo();
    private static final Operator ADDITION = new Addition();
    private static final Operator SUBTRACTION = new Subtraction();

    private static final Operator LESS_OR_EQUAL = new LessOrEqual();
    private static final Operator GREATER_OR_EQUAL = new GreaterOrEqual();
    private static final Operator LESS = new Less();
    private static final Operator GREATER = new Greater();
    private static final Operator EQUAL = new Equal();

    public Result multiply(Result op1, Result op2) {
        return MULTIPLICATION.apply(op1, op2);
    }

    public Result divide(Result op1, Result op2) {
        return DIVISION.apply(op1, op2);
    }

    public Result modulo(Result op1, Result op2) {
        return MODULO.apply(op1, op2);
    }

    public Result add(Result op1, Result op2) {
        return ADDITION.apply(op1, op2);
    }

    public Result subtract(Result op1, Result op2) {
        return SUBTRACTION.apply(op1, op2);
    }

    public Result lessOrEqual(Result op1, Result op2) {
        return LESS_OR_EQUAL.apply(op1, op2);
    }

    public Result greaterOrEqual(Result op1, Result op2) {
        return GREATER_OR_EQUAL.apply(op1, op2);
    }

    public Result less(Result op1, Result op2) {
        return LESS.apply(op1, op2);
    }

    public Result greater(Result op1, Result op2) {
        return GREATER.apply(op1, op2);
    }

    public Result equal(Result op1, Result op2) {
        return EQUAL.apply(op1, op2);
    }
}
