package com.vietage.lang17.interpreter;

import com.vietage.lang17.interpreter.state.State;

import java.util.ArrayDeque;
import java.util.Deque;

public class Runtime {

    private final Functions functions;
    private final Context globalContext = new Context();
    private final Deque<State> states = new ArrayDeque<>();
    private final NumberOperations numberOperations = new NumberOperations();
    private final EqualityChecker equalityChecker = new EqualityChecker(numberOperations);

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

    public NumberOperations getNumberOperations() {
        return numberOperations;
    }

    public EqualityChecker getEqualityChecker() {
        return equalityChecker;
    }
}
