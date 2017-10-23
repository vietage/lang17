package com.vietage.lang17.parser.lexeme;

import com.vietage.lang17.parser.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ZeroOrMore<T extends Element> extends Element {

    private final Supplier<T> supplier;
    private final List<T> elements = new ArrayList<>();
    private T element;

    public ZeroOrMore(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean parse(Context context) {
        if (context.getLastResult()) {
            if (element != null) {
                elements.add(element);
            }
            element = supplier.get();
            context.enter(element);
        } else {
            context.exit();
        }
        return true;
    }

    public List<T> getElements() {
        return elements;
    }
}
