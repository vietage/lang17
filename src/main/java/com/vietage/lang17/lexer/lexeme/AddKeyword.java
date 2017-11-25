package com.vietage.lang17.lexer.lexeme;

import com.vietage.lang17.parser.ast.expression.AdditionOperator;

/**
 * EBNF:
 * <pre>
 *     '+' | '-'
 * </pre>
 */
public class AddKeyword extends Choice {

    @Override
    protected Element[] getElements() {
        return new Element[]{
                new Token("+"),
                new Token("-")
        };
    }

    public AdditionOperator getAdditionOperator() {
        return AdditionOperator.values()[getCurrentElement()];
    }
}
