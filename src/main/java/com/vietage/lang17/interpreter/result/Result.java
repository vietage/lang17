package com.vietage.lang17.interpreter.result;

import com.vietage.lang17.interpreter.InterpreterException;
import com.vietage.lang17.parser.ast.Type;

public abstract class Result {

    private final Type type;

    protected Result(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public int getInteger() {
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

    public int[] getIntegerArray() {
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
}
