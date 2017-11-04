package com.vietage.lang17.lexer.lexeme;

import com.vietage.lang17.lexer.Context;
import com.vietage.lang17.lexer.Position;

public interface Element {

    boolean parse(Context context);

    Position getStartPosition();

    void setStartPosition(Position startPosition);
}
