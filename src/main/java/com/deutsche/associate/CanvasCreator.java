package com.deutsche.associate;

import java.util.Arrays;

public class CanvasCreator implements Canvas {

    private static final char CHAR_EMPTY = ' ';
    private static final char CHAR_HORIZ = '-';
    private static final char CHAR_VERT = '|';
    private static final char CHAR_LINE ='x';
    private final int width;
    private final int height;
    private final char[][] canvasPixels;

    public CanvasCreator(int width, int height) {

        if ( width <= 0 ||  height <= 0)  {
            throw new IllegalArgumentException("Width and Height should be positive numbers");
        }
        this.width = width+2;
        this.height = height+2;
        canvasPixels = new char[this.height][this.width];
        init();
    }


    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        checkPositive(x1, y1, x2, y2);
        checkWidth(x1, x2);
        checkHeight(y1, y2);
        if (x1 == x2) {
            fillVerticalLine(x1, y1, y2, CHAR_LINE);
        } else if (y1 == y2) {
            fillHorizontalLine(y1, x1, x2, CHAR_LINE);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public void drawRect(int x1, int y1, int x2, int y2) {
        checkPositive(x1, y1, x2, y2);
        checkWidth(x1, x2);
        checkHeight(y1, y2);
        checkRightGreaterThanLeft(x1, x2);
        checkRightGreaterThanLeft(y1, y2);
        fillHorizontalLine(y1, x1, x2, CHAR_LINE);
        fillHorizontalLine(y2, x1, x2, CHAR_LINE);
        fillVerticalLine(x1, y1+1, y2-1, CHAR_LINE);
        fillVerticalLine(x2, y1+1, y2-1, CHAR_LINE);
    }

    @Override
    public void render() {
        PixelsPrinter.printLines(canvasPixels);
    }

    private void checkHeight(int... parameters) {
        for (int parameter : parameters) {
            if (parameter > this.height ) {
                throw new IllegalArgumentException("parameter out of canvas height: " + parameter);
            }
        }
    }

    private void checkWidth(int... parameters) {
        for (int parameter : parameters) {
            if (parameter > this.width ) {
                throw new IllegalArgumentException("parameter out of canvas width: " + parameter);
            }
        }
    }

    private void checkRightGreaterThanLeft(int left, int right) {
        if (left >= right) {
            throw new IllegalArgumentException("coordinate positions are wrong: (" + left + ", " + right + ")");
        }
    }

    private void init() {
        for (char[] line : canvasPixels) {
            Arrays.fill(line, CHAR_EMPTY);
        }
        fillHorizontalLine(0, 0, width-1, CHAR_HORIZ);
        fillHorizontalLine(height-1, 0, width-1, CHAR_HORIZ);
        fillVerticalLine(0, 1, height-2, CHAR_VERT);
        fillVerticalLine(width-1, 1, height-2, CHAR_VERT);
    }

    private void checkPositive(int... parameters) {
        for (int parameter : parameters) {
            if (parameter <= 0) {
                throw new IllegalArgumentException("parameter must be positive number: " + parameter);
            }
        }
    }

    private void fillHorizontalLine(int y, int begin, int end, char p) {
        fillLine(y, begin, end, p, true);
    }

    private void fillVerticalLine(int x, int begin, int end, char p) {
        fillLine(x, begin, end, p, false);
    }

    private void fillLine(int fixed, int begin, int end, char p, boolean horizontal) {
        if (begin > end) {

            begin = begin ^ end;
            end = begin ^ end;
            begin = begin ^ end;
        }
        for(int i=begin; i<=end; i++) {
            if (horizontal) {
                canvasPixels[fixed][i] = p;
            } else {
                canvasPixels[i][fixed] = p;
            }

        }
    }

}
