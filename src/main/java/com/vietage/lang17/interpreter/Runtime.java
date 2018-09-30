package com.vietage.lang17.interpreter;

import com.vietage.lang17.interpreter.operator.Operators;
import com.vietage.lang17.interpreter.state.State;

import java.util.ArrayDeque;
import java.util.Deque;

public class Runtime {

    private final Functions functions;
    private final Context globalContext = new Context();
    private final Deque<State> states = new ArrayDeque<>();
    private final Operators operators = new Operators();

    public Runtime(Functions functions) {
        this.functions = functions;
    }

    public void enterState(State state) {
        states.push(state);
    }

    public void exitState() {
        states.pop();
    }

    public State getState() {
        return states.peek();
    }

    public boolean hasState() {
        return !states.isEmpty();
    }

    public Context getGlobalContext() {
        return globalContext;
    }

    public Function getFunction(String name) {
        Function function = functions.get(name);

        if (function == null) {
            throw new InterpreterException(String.format("Function `%s` not found", name));
        }

        return function;
    }

    public Operators getOperators() {
        return operators;
    }
}
