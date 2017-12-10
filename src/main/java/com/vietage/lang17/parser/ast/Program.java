package com.vietage.lang17.parser.ast;

import java.util.LinkedHashMap;
import java.util.Map;

public class Program implements ASTElement {

    private final Map<String, Function> functions = new LinkedHashMap<>();

    public Map<String, Function> getFunctions() {
        return functions;
    }
}
