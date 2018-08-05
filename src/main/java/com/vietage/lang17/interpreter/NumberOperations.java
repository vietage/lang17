package com.vietage.lang17.interpreter;

import com.vietage.lang17.interpreter.result.BooleanResult;
import com.vietage.lang17.interpreter.result.FloatResult;
import com.vietage.lang17.interpreter.result.IntegerResult;
import com.vietage.lang17.interpreter.result.Result;

public class NumberOperations {

    private static final Operation MULTIPLICATION = new Multiplication();
    private static final Operation DIVISION = new Division();
    private static final Operation MODULO = new Modulo();
    private static final Operation ADDITION = new Addition();
    private static final Operation SUBTRACTION = new Subtraction();

    private static final Operation LESS_OR_EQUAL = new LessOrEqual();
    private static final Operation GREATER_OR_EQUAL = new GreaterOrEqual();
    private static final Operation LESS = new Less();
    private static final Operation GREATER = new Greater();
    private static final Operation EQUAL = new Equal();

    public Result multiply(Result op1, Result op2) {
        return applyOperation(MULTIPLICATION, op1, op2);
    }

    public Result divide(Result op1, Result op2) {
        return applyOperation(DIVISION, op1, op2);
    }

    public Result modulo(Result op1, Result op2) {
        return applyOperation(MODULO, op1, op2);
    }

    public Result add(Result op1, Result op2) {
        return applyOperation(ADDITION, op1, op2);
    }

    public Result subtract(Result op1, Result op2) {
        return applyOperation(SUBTRACTION, op1, op2);
    }

    public Result lessOrEqual(Result op1, Result op2) {
        return applyOperation(LESS_OR_EQUAL, op1, op2);
    }

    public Result greaterOrEqual(Result op1, Result op2) {
        return applyOperation(GREATER_OR_EQUAL, op1, op2);
    }

    public Result less(Result op1, Result op2) {
        return applyOperation(LESS, op1, op2);
    }

    public Result greater(Result op1, Result op2) {
        return applyOperation(GREATER, op1, op2);
    }

    public Result equal(Result op1, Result op2) {
        return applyOperation(EQUAL, op1, op2);
    }

    private Result applyOperation(Operation operation, Result op1, Result op2) {
        if (op1.isFloat() || op2.isFloat()) {
            return operation.apply(toFloat(op1), toFloat(op2));
        } else if (op1.isInteger() && op2.isInteger()) {
            return operation.apply((IntegerResult) op1, (IntegerResult) op2);
        } else {
            throw new InterpreterException(String.format("Unsupported arithmetic operation over %s and %s", op1, op2));
        }
    }

    private FloatResult toFloat(Result op) {
        if (op.isInteger()) {
            return new FloatResult(op.getInteger());
        } else if (op.isFloat()) {
            return (FloatResult) op;
        } else {
            throw new InterpreterException(String.format("%s is not an integer or float!", op));
        }
    }

    private interface Operation {

        Result apply(FloatResult op1, FloatResult op2);

        Result apply(IntegerResult op1, IntegerResult op2);
    }

    private static class Multiplication implements Operation {

        @Override
        public Result apply(FloatResult op1, FloatResult op2) {
            return new FloatResult(op1.getFloat() * op2.getFloat());
        }

        @Override
        public Result apply(IntegerResult op1, IntegerResult op2) {
            return new IntegerResult(op1.getInteger() * op2.getInteger());
        }
    }

    private static class Division implements Operation {

        @Override
        public Result apply(FloatResult op1, FloatResult op2) {
            return new FloatResult(op1.getFloat() / op2.getFloat());
        }

        @Override
        public Result apply(IntegerResult op1, IntegerResult op2) {
            return new IntegerResult(op1.getInteger() / op2.getInteger());
        }
    }

    private static class Modulo implements Operation {

        @Override
        public Result apply(FloatResult op1, FloatResult op2) {
            return new FloatResult(op1.getFloat() % op2.getFloat());
        }

        @Override
        public Result apply(IntegerResult op1, IntegerResult op2) {
            return new IntegerResult(op1.getInteger() % op2.getInteger());
        }
    }

    private static class Addition implements Operation {

        @Override
        public Result apply(FloatResult op1, FloatResult op2) {
            return new FloatResult(op1.getFloat() + op2.getFloat());
        }

        @Override
        public Result apply(IntegerResult op1, IntegerResult op2) {
            return new IntegerResult(op1.getInteger() + op2.getInteger());
        }
    }

    private static class Subtraction implements Operation {

        @Override
        public Result apply(FloatResult op1, FloatResult op2) {
            return new FloatResult(op1.getFloat() - op2.getFloat());
        }

        @Override
        public Result apply(IntegerResult op1, IntegerResult op2) {
            return new IntegerResult(op1.getInteger() - op2.getInteger());
        }
    }

    private static class LessOrEqual implements Operation {

        @Override
        public Result apply(FloatResult op1, FloatResult op2) {
            return new BooleanResult(op1.getFloat() <= op2.getFloat());
        }

        @Override
        public Result apply(IntegerResult op1, IntegerResult op2) {
            return new BooleanResult(op1.getInteger() <= op2.getInteger());
        }
    }

    private static class GreaterOrEqual implements Operation {

        @Override
        public Result apply(FloatResult op1, FloatResult op2) {
            return new BooleanResult(op1.getFloat() >= op2.getFloat());
        }

        @Override
        public Result apply(IntegerResult op1, IntegerResult op2) {
            return new BooleanResult(op1.getInteger() >= op2.getInteger());
        }
    }

    private static class Greater implements Operation {

        @Override
        public Result apply(FloatResult op1, FloatResult op2) {
            return new BooleanResult(op1.getFloat() > op2.getFloat());
        }

        @Override
        public Result apply(IntegerResult op1, IntegerResult op2) {
            return new BooleanResult(op1.getInteger() > op2.getInteger());
        }
    }

    private static class Less implements Operation {

        @Override
        public Result apply(FloatResult op1, FloatResult op2) {
            return new BooleanResult(op1.getFloat() < op2.getFloat());
        }

        @Override
        public Result apply(IntegerResult op1, IntegerResult op2) {
            return new BooleanResult(op1.getInteger() < op2.getInteger());
        }
    }

    private static class Equal implements Operation {

        @Override
        public Result apply(FloatResult op1, FloatResult op2) {
            return new BooleanResult(op1.getFloat() == op2.getFloat());
        }

        @Override
        public Result apply(IntegerResult op1, IntegerResult op2) {
            return new BooleanResult(op1.getInteger() == op2.getInteger());
        }
    }
}
