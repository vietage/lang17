package com.vietage.lang17.parser.ast;

import java.util.HashMap;
import java.util.Map;

public class Program implements ASTElement {

    private final Map<String, Function> functions = new HashMap<>();

    public Map<String, Function> getFunctions() {
        return functions;
    }
}
