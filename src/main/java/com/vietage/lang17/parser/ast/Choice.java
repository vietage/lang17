package com.vietage.lang17.parser.ast;

import com.vietage.lang17.parser.Context;

public abstract class Choice extends Element {

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

    public Element getElement() {
        return elements[currentElement];
    }
}
