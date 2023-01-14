package app;
import javax.swing.*;
import java.util.ArrayList;

public class Ecran extends Canvas{

    private ArrayList<Canvas> ecranListCanvas = new ArrayList<>();

    public Ecran() {
        super();
    }

    public Ecran newEcran(ArrayList<Canvas> listCanvas, Frame newFrame){

        ecranListCanvas = listCanvas;

        for(int i = 0; i<ecranListCanvas.size(); i++){
            setThatCanvasInList(listCanvas.get(i));
            setThatFrameInList(listCanvas.get(i),newFrame);
        }

        return this;
    }

    private void setThatCanvasInList(Canvas newCanvas){
        newCanvas.setCanvas(newCanvas.getCanvasWidth(), newCanvas.getCanvasHeight());
    }

    private void setThatFrameInList(Canvas newCanvas, Frame newFrame){
        newFrame.setFrame(newCanvas);
    }



}
