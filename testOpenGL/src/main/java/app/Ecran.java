package app;

import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.*;
import java.awt.*;

public class Ecran{

    private GLCanvas canvas ;
    private JFrame frame ;

    private int cHeight;
    private int cWidth;
    private int fHeight;
    private int fWidth;

    public Ecran() {
        super();
    }

    public Ecran setEcran(int cWidth, int cHeight, int fWidth, int fHeight){

        this.canvas = setCanvas(cWidth,cHeight);
        this.frame = setFrame(fWidth,fHeight);

        Ecran newEcran = new Ecran();

        return newEcran;
    }

    private GLCanvas setCanvas(int newWidth, int newHeight){

        cHeight = newHeight;
        cWidth = newWidth;

        canvas = new Forme();

        canvas.setPreferredSize(new Dimension(cWidth,cHeight));

        return canvas;
    }

    private JFrame setFrame(int newWidth, int newHeight){

        fHeight = newHeight;
        fWidth = newWidth;

        frame = new JFrame();

        frame.setSize(fWidth,fHeight);
        frame.getContentPane().add(canvas);
        frame.setTitle("Java - OpenGL");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        return frame;
    }


}
