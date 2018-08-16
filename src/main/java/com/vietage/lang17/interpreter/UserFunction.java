package com.vietage.lang17.interpreter;

import com.vietage.lang17.interpreter.state.Block;
import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.parser.ast.Argument;
import com.vietage.lang17.parser.ast.Type;

import java.util.List;

public class UserFunction implements Function {

    private final com.vietage.lang17.parser.ast.Function delegate;

    public UserFunction(com.vietage.lang17.parser.ast.Function delegate) {
        this.delegate = delegate;
    }

    @Override
    public String getName() {
        return delegate.getName();
    }

    @Override
    public Type getReturnType() {
        return delegate.getReturnType();
    }

    @Override
    public List<Argument> getArguments() {
        return delegate.getArguments();
    }

    @Override
    public State getBodyState(Context functionContext) {
        return new Block(functionContext, delegate.getStatements().iterator());
    }
}
