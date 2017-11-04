package com.vietage.lang17.lexer.lexeme;

import com.vietage.lang17.lexer.Position;

public abstract class BaseElement implements Element {

    private Position startPosition;

    @Override
    public Position getStartPosition() {
        return startPosition;
    }

    @Override
    public void setStartPosition(Position startPosition) {
        this.startPosition = startPosition;
    }
}
