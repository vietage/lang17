package com.vietage.lang17.interpreter.operator;

import com.vietage.lang17.interpreter.InterpreterException;
import com.vietage.lang17.interpreter.result.Result;

abstract class NumericOperator extends Operator {

    protected abstract Result applyFloats(double op1, double op2);

    protected abstract Result applyIntegers(long op1, long op2);

    @Override
    public Result apply(Result op1, Result op2) {
        if (isNumber(op1) && isNumber(op2)) {
            if (op1.isFloat() || op2.isFloat()) {
                return applyFloats(toFloat(op1), toFloat(op2));
            } else {
                return applyIntegers(op1.getInteger(), op2.getInteger());
            }
        } else {
            throw new InterpreterException(getUnsupportedOperandsMessage(op1, op2));
        }
    }

    protected double toFloat(Result op) {
        if (op.isFloat()) {
            return op.getFloat();
        } else {
            return op.getInteger();
        }
    }

    protected boolean isNumber(Result op) {
        return op.isInteger() || op.isFloat();
    }
}
