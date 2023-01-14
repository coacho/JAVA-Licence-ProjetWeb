package app;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Ecran extends Canvas{

    private ArrayList<Canvas> ecranListCanvas = new ArrayList<>();
   private JFrame frame ;
    private int fHeight;
    private int fWidth;

    public Ecran() {
        super();
    }

    public Ecran newEcran(ArrayList<Canvas> listCanvas ,int fWidth, int fHeight){

        ecranListCanvas = listCanvas;
        for(int i = 0; i<ecranListCanvas.size(); i++){
            setThatCanvasInList(listCanvas.get(i));
        }
        this.frame = setFrame(fWidth,fHeight);
        return this;
    }

    private void setThatCanvasInList(Canvas newCanvas){
        newCanvas.setCanvas(newCanvas.getCanvasWidth(), newCanvas.getCanvasHeight());
    }

    private JFrame setFrame(int newWidth, int newHeight){

        fHeight = newHeight;
        fWidth = newWidth;

        frame = new JFrame();

        frame.setSize(fWidth,fHeight);
        for(int i=0; i<ecranListCanvas.size();i++) {
            frame.getContentPane().add(ecranListCanvas.get(i).getCanvas());
        }
        frame.setTitle("Java - OpenGL");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        return frame;
    }


}
