package com.vietage.lang17.interpreter;

import com.vietage.lang17.interpreter.result.Result;

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
        if (variables == null) {
            return null;
        }

        Result result = variables.get(name);

        if (result != null) {
            return result;
        }

        return parent.get(name);
    }

    public void set(String name, Result variable) {
        if (variables == null) {
            variables = new HashMap<>();
        }
        variables.put(name, variable);
    }
}
