package com.vietage.lang17.parser.ast;

import com.vietage.lang17.parser.Context;

public class ZeroOrOne<T extends Element> extends Element {

    private final T element;

    public ZeroOrOne(T element) {
        this.element = element;
    }

    @Override
    public boolean parse(Context context) {
        return false;
    }

    public T getElement() {
        return element;
    }
}
