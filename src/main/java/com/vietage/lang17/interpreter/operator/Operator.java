package com.vietage.lang17.interpreter.operator;

import com.vietage.lang17.interpreter.result.Result;

abstract class Operator {

    abstract Result apply(Result op1, Result op2);

    String getUnsupportedOperandsMessage(Result op1, Result op2) {
        return String.format("Unsupported operands %s and %s", op1, op2);
    }
}
