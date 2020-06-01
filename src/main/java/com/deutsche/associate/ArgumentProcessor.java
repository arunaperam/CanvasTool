package com.deutsche.associate;
public class ArgumentProcessor {
    private Canvas canvas;

    public void process(String[] inputArray) {
        char canvas_type= inputArray[0].toUpperCase().charAt(0);

        switch (canvas_type) {
            case 'C':
                if (inputArray.length != 3) {
                    throw new IllegalArgumentException("Received wrong number of parameters, Expected: C W H");
                }
                createCanvas(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));

                break;
            case 'L':
                if (canvas == null) {
                    throw new IllegalStateException("Canvas not Available");
                }
                if (inputArray.length != 5) {
                    throw new IllegalArgumentException("Received wrong number of Parameters, Expected : L x1 y1 x2 y2");
                }
                processLineArgs(Integer.parseInt(inputArray[1]),Integer.parseInt(inputArray[2]),Integer.parseInt(inputArray[3]),Integer.parseInt(inputArray[4]));
                break;
            case 'R':
                if (canvas == null) {
                    throw new IllegalStateException("Canvas not Available");
                }
                if (inputArray.length != 5) {
                    throw new IllegalArgumentException("Received wrong number of Parameters, Expected: R x1 y1 x2 y2");
                }
                processRectArgs(Integer.parseInt(inputArray[1]),Integer.parseInt(inputArray[2]),Integer.parseInt(inputArray[3]),Integer.parseInt(inputArray[4]));
                break;

            case 'Q':
                System.exit(0);

        }
    }

    public Canvas getCanvas() {
        return canvas;
    }


    private void processRectArgs(int x1, int y1, int x2, int y2) {
        canvas.drawRect(x1, y1, x2, y2);
    }

    private void processLineArgs(int x1, int y1, int x2, int y2) {
        canvas.drawLine(x1, y1, x2, y2);
    }

    private void createCanvas(int width, int height) {
        canvas = new CanvasCreator(width, height);
    }
}
