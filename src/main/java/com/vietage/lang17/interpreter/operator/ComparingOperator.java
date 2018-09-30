package com.vietage.lang17.interpreter.operator;

import com.vietage.lang17.interpreter.InterpreterException;
import com.vietage.lang17.interpreter.result.BooleanResult;
import com.vietage.lang17.interpreter.result.Result;

abstract class ComparingOperator extends Operator {

    abstract boolean compareIntegers(long op1, long op2);

    abstract boolean compareFloats(double op1, double op2);

    @Override
    Result apply(Result op1, Result op2) {
        if (op1.isInteger() && op2.isInteger()) {
            return new BooleanResult(compareIntegers(op1.getInteger(), op2.getInteger()));
        } else if (op1.isFloat() && op2.isFloat()) {
            return new BooleanResult(compareFloats(op1.getFloat(), op2.getFloat()));
        } else {
            throw new InterpreterException(getUnsupportedOperandsMessage(op1, op2));
        }
    }
}
