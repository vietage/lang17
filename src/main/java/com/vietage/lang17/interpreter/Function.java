package com.vietage.lang17.interpreter;

import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.parser.ast.Argument;
import com.vietage.lang17.parser.ast.Type;

import java.util.List;

public interface Function {

    String getName();

    Type getReturnType();

    List<Argument> getArguments();

    State getBodyState(Context functionContext);
}
