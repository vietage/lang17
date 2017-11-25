package com.vietage.lang17.lexer.lexeme;

import com.vietage.lang17.parser.ast.expression.UnaryOperator;

/**
 * EBNF:
 * <pre>
 *     '!' | '-'
 * </pre>
 */
public class UnaryKeyword extends Choice {

    @Override
    protected Element[] getElements() {
        return new Element[]{
                new Token("!"),
                new Token("-")
        };
    }

    public UnaryOperator getUnaryOperator() {
        return UnaryOperator.values()[getCurrentElement()];
    }
}
