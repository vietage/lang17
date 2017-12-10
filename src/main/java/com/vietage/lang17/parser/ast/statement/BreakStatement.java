package com.vietage.lang17.parser.ast.statement;

public class BreakStatement implements LoopStatement {

    @Override
    public void visit(Visitor visitor) {
        visitor.visit(this);
    }
}
