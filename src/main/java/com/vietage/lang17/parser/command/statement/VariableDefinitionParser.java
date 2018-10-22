package com.vietage.lang17.parser.command.statement;

import com.vietage.lang17.lexer.lexeme.VarDefinition;
import com.vietage.lang17.parser.ast.statement.VariableDefinition;
import com.vietage.lang17.parser.command.ParseCommand;
import com.vietage.lang17.parser.command.expression.ParseExpression;

import java.util.Queue;

class VariableDefinitionParser {

    VariableDefinition parse(VarDefinition varDefinition, Queue<ParseCommand> commandQueue) {
        VariableDefinition variableDefinition = new VariableDefinition(
                varDefinition.getType().getType(),
                varDefinition.getName().getResult(),
                varDefinition.getStartPosition()
        );

        // parse right hand expression
        commandQueue.add(
                new ParseExpression(
                        varDefinition.getExpression(),
                        variableDefinition::setExpression
                )
        );
        return variableDefinition;
    }
}
