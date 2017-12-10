package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.statement.WhileLoop;

import java.util.Deque;

public class FormatWhileLoop extends FormatCommand {

    private final WhileLoop whileLoop;
    private int invocationCount = 0;

    public FormatWhileLoop(int indent, WhileLoop whileLoop) {
        super(indent);
        this.whileLoop = whileLoop;
    }

    @Override
    public void format(IndentPrintStream out, Deque<FormatCommand> commands) {

        switch (invocationCount) {
            case 0:
                invocationCount++;
                commands.push(this);

                out.print("while (", indent);

                commands.push(new FormatExpression(indent, whileLoop.getCondition()));

                break;
            case 1:
                invocationCount++;
                commands.push(this);

                out.println(")", indent);
                out.println("{", indent);

                commands.push(new FormatStatements(indent + 4, whileLoop.getStatements()));

                break;
            case 2:
                invocationCount++;

                out.println("}", indent);

                break;
            default:
                throw new RuntimeException("format() method invoked too many times");
        }
    }
}
