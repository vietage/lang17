package com.vietage.lang17.parser.lexeme;

import com.vietage.lang17.parser.Context;

public abstract class CompositeElement extends Element {

    private static final int FIRST_ELEMENT = 0;

    private Element[] elements;
    private int currentElement = FIRST_ELEMENT;

    protected abstract Element[] getElements();

    @Override
    public boolean parse(Context context) {
        if (currentElement == FIRST_ELEMENT) {
            elements = getElements();
        } else if (!context.getLastResult()) {
            context.exit();
            return false;
        } else if (currentElement >= elements.length) {
            context.exit();
            return true;
        }
        context.enter(elements[currentElement++]);
        return true;
    }
}
