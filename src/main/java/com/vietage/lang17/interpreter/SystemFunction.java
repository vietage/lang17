package com.vietage.lang17.interpreter;

import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.parser.ast.Argument;
import com.vietage.lang17.parser.ast.Type;

import java.util.List;

public class SystemFunction implements Function {

    private final String name;
    private final Type returnType;
    private final List<Argument> arguments;
    private final StateProducer stateProducer;

    public SystemFunction(String name, Type returnType, List<Argument> arguments, StateProducer stateProducer) {
        this.name = name;
        this.returnType = returnType;
        this.arguments = arguments;
        this.stateProducer = stateProducer;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Type getReturnType() {
        return returnType;
    }

    @Override
    public List<Argument> getArguments() {
        return arguments;
    }

    @Override
    public State getBodyState(Context functionContext) {
        return stateProducer.getBodyState(functionContext);
    }

    @FunctionalInterface
    public interface StateProducer {
        State getBodyState(Context functionContext);
    }
}
