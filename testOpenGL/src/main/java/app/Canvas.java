package app;

import com.jogamp.opengl.awt.GLCanvas;

import java.awt.*;

public class Canvas {

    private int cWidth;
    private int cHeight;
    private GLCanvas canvas = new GLCanvas();

    Canvas(){
        super();
    }

    public void setCanvas(int newWidth,int newHeight){

        cHeight = newHeight;
        cWidth = newWidth;

        canvas = new Forme();

        canvas.setPreferredSize(new Dimension(cWidth,cHeight));

    }

    public GLCanvas getCanvas(){

        canvas = this.canvas;

        return canvas;
    }

}
