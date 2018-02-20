package com.vietage.lang17.interpreter;

import com.vietage.lang17.parser.ast.Function;

import java.util.Deque;

public class Invoke implements Command {

    private final Function function;

    public Invoke(Function function) {
        this.function = function;
    }

    @Override
    public void run(Deque<Command> commands) {
        System.out.println("invoke " + function);
    }
}
