package com.vietage.lang17.lexer.lexeme;

public interface ValueExpressionLexeme extends Lexeme {

    void accept(Visitor visitor);

    interface Visitor {

        void visit(BracketsExpression bracketsExpression);

        void visit(Constant constant);

        void visit(VarAccess varAccess);

        void visit(NewArray newArray);

        void visit(Call call);
    }
}
