package com.vietage.lang17.parser.ast.statement;

import com.vietage.lang17.parser.ast.ASTElement;
import com.vietage.lang17.parser.ast.expression.FunctionCall;

public interface Statement extends ASTElement {

    void visit(Visitor visitor);

    interface Visitor {

        void visit(ContinueStatement continueStatement);

        void visit(BreakStatement breakStatement);

        void visit(FunctionCall functionCall);

        void visit(WhileLoop whileLoop);

        void visit(ReturnStatement returnStatement);

        void visit(IfStatement ifStatement);

        void visit(VariableDefinition variableDefinition);

        void visit(VariableAssignment variableAssignment);
    }
}
