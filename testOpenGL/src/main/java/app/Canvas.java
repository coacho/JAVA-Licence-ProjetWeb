package app;

import com.jogamp.opengl.awt.GLCanvas;

import javax.print.DocFlavor;
import java.awt.*;
import java.util.ArrayList;

public class Canvas {

    private ArrayList<Forme> listForme = new ArrayList<>();
    private int cWidth;
    private int cHeight;
    private GLCanvas canvas = new GLCanvas();

    Canvas(){
        super();
    }

    public void newCanvas(int newWidth,int newHeight){
        setCanvasWidth(newWidth);
        setCanvasHeight(newHeight);
    }

    public void setCanvas(int newWidth,int newHeight){

        setCanvasHeight(newHeight);
        setCanvasWidth(newWidth);

        // potentiellement plusieurs "Forme" par Canvas ?
        Forme triangle = new Forme();
       // Forme test = new Forme();

        listForme.add(triangle);
       // listForme.add(test);

        for(int i = 0 ; i < listForme.size(); i++){
            this.canvas = listForme.get(i);
        }

        this.canvas.setPreferredSize(new Dimension(cWidth,cHeight));

    }
    private void setCanvasHeight(int h){
        this.cHeight = h;
    }
    private void setCanvasWidth(int w){
        this.cWidth = w;
    }

    public int getCanvasHeight(){
        cHeight = this.cHeight;
        return cHeight;
    }
    public int getCanvasWidth(){
        cWidth = this.cWidth;
        return cWidth;
    }

    public GLCanvas getCanvas(){
        canvas = this.canvas;
        return canvas;
    }

}
