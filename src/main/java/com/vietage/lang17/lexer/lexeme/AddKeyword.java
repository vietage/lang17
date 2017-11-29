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
    protected Lexeme[] getLexemes() {
        return new Lexeme[]{
                new Token("+"),
                new Token("-")
        };
    }

    public AdditionOperator getAdditionOperator() {
        return AdditionOperator.values()[getCurrentLexeme()];
    }
}
