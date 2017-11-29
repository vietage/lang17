package com.vietage.lang17.lexer.lexeme;

public interface StatementChoiceLexeme extends Lexeme {

    void accept(Visitor visitor);

    interface Visitor {

        void visit(VarDefinition varDefinition);

        void visit(Assignment assignment);

        void visit(IfStatement ifStatement);

        void visit(WhileLoop whileLoop);

        void visit(LoopOp loopOp);

        void visit(Call call);

        void visit(ReturnStatement returnStatement);
    }
}
