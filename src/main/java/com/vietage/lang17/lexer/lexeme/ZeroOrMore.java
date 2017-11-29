package com.vietage.lang17.lexer.lexeme;

import com.vietage.lang17.lexer.Context;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

public class ZeroOrMore<T extends Lexeme> extends BaseLexeme
        implements Iterable<T> {

    private final Supplier<T> supplier;
    private final List<T> lexemes = new ArrayList<>();
    private T element;

    public ZeroOrMore(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean parse(Context context) {
        if (context.getLastResult()) {
            if (element != null) {
                lexemes.add(element);
            }
            element = supplier.get();
            context.enter(element);
        } else {
            context.exit();
        }
        return true;
    }

    public List<T> getLexemes() {
        return lexemes;
    }

    @Override
    public Iterator<T> iterator() {
        return lexemes.iterator();
    }
}
