package com.vietage.lang17.interpreter.operator;

import com.vietage.lang17.interpreter.result.FloatResult;
import com.vietage.lang17.interpreter.result.IntegerResult;
import com.vietage.lang17.interpreter.result.Result;

class Modulo extends NumericOperator {

    @Override
    protected Result applyFloats(double op1, double op2) {
        return new FloatResult(op1 % op2);
    }

    @Override
    protected Result applyIntegers(long op1, long op2) {
        return new IntegerResult(op1 % op2);
    }
}
