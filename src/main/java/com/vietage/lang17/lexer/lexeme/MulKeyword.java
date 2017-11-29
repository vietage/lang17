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
    protected Lexeme[] getLexemes() {
        return new Lexeme[]{
                new Token("*"),
                new Token("/"),
                new Token("%")
        };
    }

    public MultiplicationOperator getMultiplicationOperator() {
        return MultiplicationOperator.values()[getCurrentLexeme()];
    }
}
