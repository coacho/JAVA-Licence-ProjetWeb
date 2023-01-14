package app;

import com.jogamp.opengl.awt.GLCanvas;
import java.util.ArrayList;
import java.awt.*;

public class Canvas {

    private ArrayList<Forme> listForme = new ArrayList<>();
    private int cWidth;
    private int cHeight;

    private GLCanvas canvas = new GLCanvas();
    private CanvasConfig config;

    Canvas(){
        super();
    }

    public void initNewCanvas(int newWidth,int newHeight){
        setCanvasWidth(newWidth);
        setCanvasHeight(newHeight);
        //setCanvasConfig(this);
    }

    public void setCanvas(int newWidth,int newHeight){

        setCanvasHeight(newHeight);
        setCanvasWidth(newWidth);

        config = new CanvasConfig();

        // potentiellement plusieurs "Forme" par Canvas ?
        //Forme triangle = new Forme(canvas);
        Forme test = new Forme();

        //listForme.add(triangle);
        listForme.add(test);

        for(int i = 0 ; i < listForme.size(); i++){
            this.canvas = listForme.get(i);
        }

        this.canvas.setPreferredSize(new Dimension(cWidth,cHeight));

    }
    private void setCanvasConfig(CanvasConfig newConfig){
        this.config = newConfig;
    }

    private void setCanvasHeight(int h){
        this.cHeight = h;
    }
    private void setCanvasWidth(int w){
        this.cWidth = w;
    }

    public CanvasConfig getCanvasConfig(){
        config = this.config;
        return config;
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
