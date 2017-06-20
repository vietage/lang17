package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     'int' | 'float' | 'boolean' | 'string'
 * </pre>
 */
public class BasicType extends Choice {
    @Override
    protected Element[] getElements() {
        return new Element[0];
    }
}
