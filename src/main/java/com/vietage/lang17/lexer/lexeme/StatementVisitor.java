package com.vietage.lang17.lexer.lexeme;

public interface StatementVisitor {

    void parseVarDefinition(VarDefinition varDefinition);

    void parseAssignment(Assignment assignment);

    void parseIfStatement(IfStatement ifStatement);

    void parseWhileLoop(WhileLoop whileLoop);

    void parseLoopOp(LoopOp loopOp);

    void parseCall(Call call);

    void parseReturnStatement(ReturnStatement returnStatement);
}
