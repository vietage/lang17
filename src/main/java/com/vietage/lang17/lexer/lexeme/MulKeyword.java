package com.vietage.lang17.lexer.lexeme;

import com.vietage.lang17.parser.ast.expression.MultiplicationOperator;

/**
 * EBNF:
 * <pre>
 *     '*' | '/' | '%'
 * </pre>
 */
public class MulKeyword extends Choice {

    @Override
    protected Element[] getElements() {
        return new Element[]{
                new Token("*"),
                new Token("/"),
                new Token("%")
        };
    }

    public MultiplicationOperator getMultiplicationOperator() {
        return MultiplicationOperator.values()[getCurrentElement()];
    }
}
