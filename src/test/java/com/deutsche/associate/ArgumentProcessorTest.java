package com.deutsche.associate;

import org.junit.Test;

public class ArgumentProcessorTest {


    @Test(expected = IllegalArgumentException.class)
    public void testCanvasException(){

    // throw IllegalArgumentException if width and height not available

        String[] c = {"c","20"};
        ArgumentProcessor arg = new ArgumentProcessor();
        arg.process(c);
    }

    @Test(expected = IllegalStateException.class)
    public void testLineDrawException(){

    //throw IllegalStateException if canvas not available

        String[] line = {"L", "1", "3", "7"};
        ArgumentProcessor arg = new ArgumentProcessor();
        arg.process(line);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRectDrawException(){

    //throw IllegalArgumentException if insufficient number of parameters for Rectangle

        String[] c = {"C","20","5"};
        String[] Rect = {"R", "1", "3", "7"};
        ArgumentProcessor arg = new ArgumentProcessor();
        arg.process(c);
        arg.getCanvas().render();
        arg.process(Rect);
    }



}