package com.vietage.lang17.parser.ast;

public class Argument implements ASTElement {

    private final Type type;
    private final String name;

    public Argument(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
