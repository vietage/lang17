package com.vietage.lang17.parser.command.statement;

import com.vietage.lang17.lexer.lexeme.Assignment;
import com.vietage.lang17.parser.ast.statement.VariableAssignment;
import com.vietage.lang17.parser.command.ParseCommand;
import com.vietage.lang17.parser.command.expression.ParseExpression;

import java.util.Queue;

class VariableAssignmentParser {

    VariableAssignment parse(Assignment assignment, Queue<ParseCommand> commandQueue) {
        String name = assignment.getVarAccess().getName().getResult();

        VariableAssignment variableAssignment = new VariableAssignment(name, assignment.getStartPosition());

        // parse array index expression
        if (assignment.getVarAccess().getIndexExpression().getResult()) {
            commandQueue.add(
                    new ParseExpression(
                            assignment.getVarAccess().getIndexExpression().getLexeme().getExpression(),
                            variableAssignment::setIndexExpression
                    )
            );
        }

        // parse right hand expression
        commandQueue.add(
                new ParseExpression(
                        assignment.getExpression(),
                        variableAssignment::setExpression
                )
        );
        return variableAssignment;
    }
}
