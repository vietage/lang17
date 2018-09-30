package com.vietage.lang17.interpreter;

import com.vietage.lang17.interpreter.operator.Operators;
import com.vietage.lang17.interpreter.result.BooleanResult;
import com.vietage.lang17.interpreter.result.Result;

public class EqualityChecker {

    private final Operators operators;

    public EqualityChecker(Operators operators) {
        this.operators = operators;
    }

    public Result equal(Result op1, Result op2) {
        if ((op1.isFloat() || op1.isInteger()) && (op2.isFloat() || op2.isInteger())) {
            return operators.equal(op1, op2);
        } else if (op1.isBoolean() && op2.isBoolean()) {
            return new BooleanResult(op1.getBoolean() == op2.getBoolean());
        } else if (op1.isString() && op2.isString()) {
            return new BooleanResult(op1.getString().equals(op2.getString()));
        } else {
            throw new InterpreterException(String.format("Unsupported equality check of %s and %s", op1, op2));
        }
    }

    public Result notEqual(Result op1, Result op2) {
        return new BooleanResult(!equal(op1, op2).getBoolean());
    }
}
