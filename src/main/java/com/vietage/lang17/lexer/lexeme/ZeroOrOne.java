package com.vietage.lang17.lexer.lexeme;

import com.vietage.lang17.lexer.Context;

public class ZeroOrOne<T extends Element> extends BaseElement {

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

    public Boolean getResult() {
        return result;
    }

    public T getElement() {
        return element;
    }
}
