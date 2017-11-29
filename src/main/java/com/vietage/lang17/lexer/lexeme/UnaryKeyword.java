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
    protected Lexeme[] getLexemes() {
        return new Lexeme[]{
                new Token("!"),
                new Token("-")
        };
    }

    public UnaryOperator getUnaryOperator() {
        return UnaryOperator.values()[getCurrentLexeme()];
    }
}
