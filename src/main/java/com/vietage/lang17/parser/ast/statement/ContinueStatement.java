package com.vietage.lang17.parser.ast.statement;

import com.vietage.lang17.lexer.Position;

public class ContinueStatement extends Statement {

    public ContinueStatement(Position position) {
        super(position);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
