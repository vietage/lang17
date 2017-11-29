package com.vietage.lang17.lexer;

import com.vietage.lang17.lexer.lexeme.Lexeme;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class ErrorChain {

    private final Deque<Lexeme> errorChain = new ArrayDeque<>();

    public void add(Lexeme lexeme) {
        errorChain.add(lexeme);
    }

    public void clear() {
        errorChain.clear();
    }

    public String formatErrorMessage(SourceReader sourceReader) {
        Iterator<Lexeme> errors = errorChain.iterator();
        Lexeme root = errors.next();

        int line = root.getStartPosition().getLine();
        int column = root.getStartPosition().getColumn();

        StringBuilder sb = new StringBuilder();

        writeLineAndColumn(line, column, sb);
        writeContextSourceLines(sourceReader, line, sb);
        drawArrow(column, sb);

        return sb.toString();
    }

    private void writeLineAndColumn(int line, int column, StringBuilder sb) {
        sb.append("Parse error at line ");
        sb.append(line + 1);
        sb.append(" column ");
        sb.append(column + 1);
        sb.append('\n');
        sb.append('\n');
    }

    private void drawArrow(int column, StringBuilder sb) {
        for (int i = 0; i < column; i++) {
            sb.append('-');
        }
        sb.append('^');
        sb.append('\n');
    }

    private void writeContextSourceLines(SourceReader sourceReader, int line, StringBuilder sb) {
        int fromLine = Math.max(line - 2, 0);
        int toLine = line + 1;

        while (fromLine < toLine) {
            sb.append(sourceReader.getLine(fromLine++));
            sb.append('\n');
        }
    }
}
