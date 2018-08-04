package com.vietage.lang17.interpreter.result;

import com.vietage.lang17.interpreter.InterpreterException;
import com.vietage.lang17.parser.ast.Type;

public abstract class Result {

    private final Type type;

    protected Result(Type type) {
        this.type = type;
    }

    public abstract void accept(Visitor visitor);

    public Type getType() {
        return type;
    }

    public boolean isInteger() {
        return false;
    }

    public boolean isFloat() {
        return false;
    }

    public boolean isBoolean() {
        return false;
    }

    public boolean isString() {
        return false;
    }

    public boolean isIntegerArray() {
        return false;
    }

    public boolean isFloatArray() {
        return false;
    }

    public boolean isBooleanArray() {
        return false;
    }

    public boolean isStringArray() {
        return false;
    }

    public long getInteger() {
        throw new InterpreterException(getMessage(Type.INTEGER));
    }

    public double getFloat() {
        throw new InterpreterException(getMessage(Type.FLOAT));
    }

    public boolean getBoolean() {
        throw new InterpreterException(getMessage(Type.BOOLEAN));
    }

    public String getString() {
        throw new InterpreterException(getMessage(Type.STRING));
    }

    public long[] getIntegerArray() {
        throw new InterpreterException(getMessage(Type.INTEGER_ARRAY));
    }

    public double[] getFloatArray() {
        throw new InterpreterException(getMessage(Type.FLOAT_ARRAY));
    }

    public boolean[] getBooleanArray() {
        throw new InterpreterException(getMessage(Type.BOOLEAN_ARRAY));
    }

    public String[] getStringArray() {
        throw new InterpreterException(getMessage(Type.STRING_ARRAY));
    }

    private String getMessage(Type desiredType) {
        return String.format("Illegal try to get %s, while Result contains %s", desiredType, type);
    }

    public interface Visitor {

        default void visit(IntegerResult integerResult) {
            throw new InterpreterException("Not implemented");
        }

        default void visit(FloatResult floatResult) {
            throw new InterpreterException("Not implemented");
        }

        default void visit(BooleanResult booleanResult) {
            throw new InterpreterException("Not implemented");
        }

        default void visit(StringResult stringResult) {
            throw new InterpreterException("Not implemented");
        }

        default void visit(IntegerArrayResult integerArrayResult) {
            throw new InterpreterException("Not implemented");
        }

        default void visit(FloatArrayResult floatArrayResult) {
            throw new InterpreterException("Not implemented");
        }

        default void visit(BooleanArrayResult booleanArrayResult) {
            throw new InterpreterException("Not implemented");
        }

        default void visit(StringArrayResult stringArrayResult) {
            throw new InterpreterException("Not implemented");
        }
    }
}
