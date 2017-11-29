package com.vietage.lang17.lexer.lexeme;

public interface ConstantLexeme extends Lexeme {

    void accept(Visitor visitor);

    interface Visitor {

        void visit(NumberConstant numberConstant);

        void visit(StringConstant stringConstant);

        void visit(BooleanConstant booleanConstant);
    }
}
