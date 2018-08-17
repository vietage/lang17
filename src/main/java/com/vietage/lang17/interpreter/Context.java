package com.vietage.lang17.interpreter;

import com.vietage.lang17.interpreter.result.*;
import com.vietage.lang17.parser.ast.Type;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private final Context parent;

    private Map<String, Result> variables;

    public Context() {
        this(null);
    }

    public Context(Context parent) {
        this.parent = parent;
    }

    public Result get(String name) {
        Result result = tryGet(name);

        checkNotNull(name, result);

        return result;
    }

    public Result get(String name, int index) {
        Result result = tryGet(name);

        checkNotNull(name, result);

        switch (result.getType()) {
            case INTEGER_ARRAY:
                long[] ints = result.getIntegerArray();
                checkArrayBounds(name, ints.length, index);
                return new IntegerResult(ints[index]);
            case FLOAT_ARRAY:
                double[] floats = result.getFloatArray();
                checkArrayBounds(name, floats.length, index);
                return new FloatResult(floats[index]);
            case BOOLEAN_ARRAY:
                boolean[] booleans = result.getBooleanArray();
                checkArrayBounds(name, booleans.length, index);
                return new BooleanResult(booleans[index]);
            case STRING_ARRAY:
                String[] strings = result.getStringArray();
                checkArrayBounds(name, strings.length, index);
                return new StringResult(strings[index]);
            default:
                throw new InterpreterException(String.format("Variable `%s` is not an array", name));
        }
    }

    public void set(String name, Result variable) {
        if (!trySet(name, variable)) {
            if (variables == null) {
                variables = new HashMap<>();
            }
            variables.put(name, variable);
        }
    }

    public void set(String name, int index, Result variable) {
        Result result = tryGet(name);

        checkNotNull(name, result);
        checkCanHoldValueOf(name, result.getType(), variable.getType());

        switch (result.getType()) {
            case INTEGER_ARRAY:
                long[] ints = result.getIntegerArray();
                checkArrayBounds(name, ints.length, index);
                ints[index] = variable.getInteger();
                break;
            case FLOAT_ARRAY:
                double[] floats = result.getFloatArray();
                checkArrayBounds(name, floats.length, index);
                floats[index] = variable.getFloat();
                break;
            case BOOLEAN_ARRAY:
                boolean[] booleans = result.getBooleanArray();
                checkArrayBounds(name, booleans.length, index);
                booleans[index] = variable.getBoolean();
                break;
            case STRING_ARRAY:
                String[] strings = result.getStringArray();
                checkArrayBounds(name, strings.length, index);
                strings[index] = result.getString();
            default:
                throw new InterpreterException(String.format("Variable `%s` is not an array", name));
        }
    }

    private Result tryGet(String name) {
        if (variables == null) {
            return null;
        }

        Result result = variables.get(name);

        if (result != null) {
            return result;
        }

        if (parent != null) {
            return parent.tryGet(name);
        }
        return null;
    }

    private boolean trySet(String name, Result variable) {
        if (variables != null && variables.containsKey(name)) {
            Result result = variables.get(name);

            if (!result.getType().equals(variable.getType())) {
                throw new InterpreterException(String.format(
                        "Illegal try to set `%s` variable of type %s to %s value",
                        name, result.getType(), variable.getType()
                ));
            }

            variables.put(name, variable);

            return true;
        }

        return parent != null && parent.trySet(name, variable);
    }

    private void checkNotNull(String name, Result result) {
        if (result == null) {
            throw new InterpreterException(String.format("Variable `%s` is not defined", name));
        }
    }

    private void checkCanHoldValueOf(String name, Type arrayType, Type valueType) {
        Type valueArrayType = Type.getArrayType(valueType);
        if (!arrayType.equals(valueArrayType)) {
            throw new InterpreterException(String.format(
                    "Illegal try to set `%s` of type %s to %s value", name, arrayType, valueType
            ));
        }
    }

    private void checkArrayBounds(String name, int length, int index) {
        if (index >= length) {
            throw new InterpreterException(String.format("Index %d out of bounds of `%s` array", index, name));
        }
    }
}
