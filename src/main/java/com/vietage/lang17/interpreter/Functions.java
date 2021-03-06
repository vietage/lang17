package com.vietage.lang17.interpreter;

import com.vietage.lang17.interpreter.lib.*;
import com.vietage.lang17.parser.ast.Program;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;

public class Functions {

    private final Map<String, Function> functions;

    public Functions(Program program) {
        functions = Stream.concat(
                // System functions
                Stream.of(
                        Print.getSystemFunction(),
                        Println.getSystemFunction(),
                        ReadInt.getSystemFunction(),
                        IsOk.getSystemFunction(),
                        SizeInt.getSystemFunction(),
                        RandomInt.getSystemFunction()
                ),
                // User defined functions
                program.getFunctions().values().stream()
                        .map(UserFunction::new)
        ).collect(Collectors.toMap(Function::getName, identity()));
    }

    public Function get(String name) {
        return functions.get(name);
    }
}
