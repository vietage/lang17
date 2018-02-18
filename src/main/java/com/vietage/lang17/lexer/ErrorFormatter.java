package com.vietage.lang17.lexer;

import java.util.Comparator;

public class ErrorFormatter {

    private final Comparator<Position> COMPARATOR = Comparator.comparingInt(Position::getLine)
            .thenComparingInt(Position::getColumn);

    private Position lastSuccessPosition = new Position();

    public void updateLastSuccessPosition(Position position) {
        lastSuccessPosition = max(lastSuccessPosition, position);
    }

    private Position max(Position p1, Position p2) {
        return COMPARATOR.compare(p1, p2) >= 0 ? p1 : p2;
    }

    public String format(SourceReader sourceReader) {
        int line = lastSuccessPosition.getLine();
        int column = lastSuccessPosition.getColumn();

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
