package com.vietage.lang17.lexer.lexeme;

import com.vietage.lang17.lexer.Context;

public abstract class Choice extends BaseElement {

    private static final int INIT_STATE = -1;

    private Element[] elements;
    private int currentElement = INIT_STATE;

    protected abstract Element[] getElements();

    @Override
    public boolean parse(Context context) {
        if (currentElement == INIT_STATE) {
            elements = getElements();
        } else if (context.getLastResult()) {
            context.exit();
            return true;
        }
        currentElement++;
        if (currentElement < elements.length) {
            context.enter(elements[currentElement]);
            return true;
        } else {
            context.exit();
            return false;
        }
    }

    protected int getCurrentElement() {
        return currentElement;
    }

    public Element getElement() {
        return elements[currentElement];
    }
}
