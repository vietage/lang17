package com.vietage.lang17.interpreter.operator;

import com.vietage.lang17.interpreter.InterpreterException;
import com.vietage.lang17.interpreter.result.FloatResult;
import com.vietage.lang17.interpreter.result.IntegerResult;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.result.StringResult;

class Addition extends NumericOperator {

    @Override
    public Result apply(Result op1, Result op2) {
        if (isNumber(op1) && isNumber(op2)) {
            return add(op1, op2);
        } else if (canConcat(op1) && canConcat(op2)) {
            return concat(op1, op2);
        } else {
            throw new InterpreterException(getUnsupportedOperandsMessage(op1, op2));
        }
    }

    @Override
    protected Result applyFloats(double op1, double op2) {
        return new FloatResult(op1 + op2);
    }

    @Override
    protected Result applyIntegers(long op1, long op2) {
        return new IntegerResult(op1 + op2);
    }

    private Result add(Result op1, Result op2) {
        if (op1.isFloat() || op2.isFloat()) {
            return applyFloats(toFloat(op1), toFloat(op2));
        } else {
            return applyIntegers(op1.getInteger(), op2.getInteger());
        }
    }

    private Result concat(Result op1, Result op2) {
        return new StringResult(getString(op1) + getString(op2));
    }

    private String getString(Result op) {
        if (op.isString()) {
            return op.getString();
        } else if (op.isInteger()) {
            return Long.toString(op.getInteger());
        } else if (op.isFloat()) {
            return Double.toString(op.getFloat());
        } else {
            throw new InterpreterException(String.format("Unable to convert %s to string", op));
        }
    }

    private boolean canConcat(Result op) {
        return op.isString() || isNumber(op);
    }
}
