package com.vietage.lang17.lexer.lexeme;

public interface ConstantElement extends Element {

    void accept(Visitor visitor);

    interface Visitor {

        void visit(NumberConstant numberConstant);

        void visit(StringConstant stringConstant);

        void visit(BooleanConstant booleanConstant);
    }
}
