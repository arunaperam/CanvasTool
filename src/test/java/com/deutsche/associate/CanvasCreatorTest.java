package com.deutsche.associate;
import org.junit.Test;



public class CanvasCreatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCanvasCreatorException(){
        Canvas c =new CanvasCreator(15,-5);
        c.render();

    }

    @Test()
    public void testCanvasCreator(){
        Canvas c =new CanvasCreator(10,8);
        c.render();

    }

    @Test(expected = UnsupportedOperationException.class)
    public void testDrawLine() {
        Canvas c =new CanvasCreator(12,4);
        c.drawLine(1,5,7,6);
        c.render();
    }

    @Test()
    public void testDrawHorizLine() {
        Canvas c =new CanvasCreator(18,6);
        c.drawLine(2,5,7,5);
        c.render();
    }

    @Test()
    public void testDrawVertLine() {
        Canvas c =new CanvasCreator(10,10);
        c.drawLine(5,4,5,1);
        c.render();
    }

    @Test
    public void testDrawRect() {
        Canvas c =new CanvasCreator(18,10);
        c.drawRect(5,3,12,8);
        c.render();
    }

    @Test
    public void testRender() {
        Canvas c =new CanvasCreator(18,6);
        c.render();

    }

}