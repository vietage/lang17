package com.vietage.lang17.parser.command.statement;

import com.vietage.lang17.lexer.lexeme.LoopOp;
import com.vietage.lang17.parser.ParserException;
import com.vietage.lang17.parser.ast.statement.BreakStatement;
import com.vietage.lang17.parser.ast.statement.ContinueStatement;
import com.vietage.lang17.parser.ast.statement.Statement;

class LoopStatementParser {

    Statement parse(LoopOp loopOp) {
        if (loopOp.isBreak()) {
            return new BreakStatement(loopOp.getStartPosition());
        }
        if (loopOp.isContinue()) {
            return new ContinueStatement(loopOp.getStartPosition());
        }
        throw new ParserException(String.format("Unsupported lexeme: %s", loopOp));
    }
}
