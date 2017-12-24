package com.vietage.lang17.parser.ast.expression;

import com.vietage.lang17.parser.ast.ASTElement;

public interface Expression extends ASTElement {

    void accept(Visitor visitor);

    interface Visitor {

        void visit(FunctionCall functionCall);

        void visit(UnaryExpression unaryExpression);

        void visit(BooleanConstant booleanConstant);

        void visit(StringConstant stringConstant);

        void visit(IntegerConstant integerConstant);

        void visit(FloatConstant floatConstant);

        void visit(VariableRead variableRead);

        void visit(MultiplicationExpression multiplicationExpression);

        void visit(OrExpression orExpression);

        void visit(AdditionExpression additionExpression);

        void visit(RelationalExpression relationalExpression);

        void visit(EqualityExpression equalityExpression);

        void visit(ArrayRead arrayRead);

        void visit(ArrayAllocation arrayAllocation);

        void visit(AndExpression andExpression);
    }
}
