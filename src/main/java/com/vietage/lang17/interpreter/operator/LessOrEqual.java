package com.vietage.lang17.interpreter.operator;

class LessOrEqual extends ComparingOperator {

    @Override
    boolean compareIntegers(long op1, long op2) {
        return op1 <= op2;
    }

    @Override
    boolean compareFloats(double op1, double op2) {
        return op1 <= op2;
    }
}
