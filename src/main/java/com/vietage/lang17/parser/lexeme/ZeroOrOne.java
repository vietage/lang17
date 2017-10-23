package com.vietage.lang17.parser.lexeme;

import com.vietage.lang17.parser.Context;

public class ZeroOrOne<T extends Element> extends Element {

    private final T element;
    private Boolean result;

    public ZeroOrOne(T element) {
        this.element = element;
    }

    @Override
    public boolean parse(Context context) {
        if (result == null) {
            result = true;
            context.enter(element);
        } else {
            result = context.getLastResult();
            context.exit();
        }

        return true;
    }

    public T getElement() {
        return element;
    }
}
