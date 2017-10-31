package com.vietage.lang17.lexer.lexeme;

import com.vietage.lang17.lexer.Context;
import com.vietage.lang17.lexer.Position;

public abstract class Element {

    private Position startPosition;

    public abstract boolean parse(Context context);

    public Position getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Position startPosition) {
        this.startPosition = startPosition;
    }
}
