package com.vietage.lang17.interpreter.operator;

import com.vietage.lang17.interpreter.InterpreterException;
import com.vietage.lang17.interpreter.result.BooleanResult;
import com.vietage.lang17.interpreter.result.Result;

class Equal extends Operator {

    @Override
    public Result apply(Result op1, Result op2) {
        if (op1.isInteger() && op2.isInteger()) {
            return new BooleanResult(op1.getInteger() == op2.getInteger());
        } else if (op1.isFloat() && op2.isFloat()) {
            return new BooleanResult(op1.getFloat() == op2.getFloat());
        } else if (op1.isBoolean() && op2.isBoolean()) {
            return new BooleanResult(op1.getBoolean() == op2.getBoolean());
        } else if (op1.isString() && op2.isString()) {
            return new BooleanResult(op1.getString().equals(op2.getString()));
        } else {
            throw new InterpreterException(getUnsupportedOperandsMessage(op1, op2));
        }
    }
}
