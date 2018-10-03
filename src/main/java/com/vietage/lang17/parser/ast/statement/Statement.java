package com.vietage.lang17.parser.ast.statement;

import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.parser.ast.ASTElement;
import com.vietage.lang17.parser.ast.PositionalElement;
import com.vietage.lang17.parser.ast.expression.FunctionCall;

public abstract class Statement implements ASTElement, PositionalElement {

    private final Position position;

    protected Statement(Position position) {
        this.position = position;
    }

    public abstract void accept(Visitor visitor);

    @Override
    public Position getPosition() {
        return position;
    }

    public interface Visitor {

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
