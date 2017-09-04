package com.vietage.lang17.parser.ast;

import com.vietage.lang17.parser.Context;

public class ZeroOrOne<T extends Element> extends Element {

    private T element;

    public ZeroOrOne(T element) {
        this.element = element;
    }

    @Override
    public boolean parse(Context context) {
        if (!context.getLastResult()) {
            element = null;
            return false;
        }

        if (element == null) {
            context.enter(element);
        } else {
            context.exit();
        }

        return true;
    }

    public T getElement() {
        return element;
    }
}
