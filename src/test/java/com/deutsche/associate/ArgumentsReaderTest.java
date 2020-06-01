package com.deutsche.associate;

import org.junit.Test;
import java.io.ByteArrayInputStream;

public class ArgumentsReaderTest {


    String[] s = {"C","20","5"};
    String[] line = {"L","1","3","7","3"};
    String[] Rect = {"R","8","1","15","4"};

    @Test
    public  void testCanvasinput()
    {


        String canvas = "C 20 5";
        System.setIn(new ByteArrayInputStream(canvas.getBytes()));
        ArgumentsReader.main(new String[0]);

    }


    @Test
    public void testlineinput(){
        ArgumentProcessor cmd = new ArgumentProcessor();
        cmd.process(s);
        cmd.getCanvas().render();
        cmd.process(line);
        cmd.getCanvas().render();

    }

    @Test
    public void testRectinput(){
        ArgumentProcessor cmd = new ArgumentProcessor();
        cmd.process(s);
        cmd.getCanvas().render();
        cmd.process(Rect);
        cmd.getCanvas().render();
    }

}