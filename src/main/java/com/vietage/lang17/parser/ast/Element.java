package com.vietage.lang17.parser.ast;

import com.vietage.lang17.parser.Context;

public abstract class Element {

    private int startPosition;

    public abstract boolean parse(Context context);

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }
}
