package app;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Ecran extends Canvas{

    /*private List<Canvas> listCanvas = new ArrayList<Canvas>();*/
    private Canvas canvas = new Canvas();
    private JFrame frame ;

    private int cHeight;
    private int cWidth;
    private int fHeight;
    private int fWidth;

    public Ecran() {
        super();
    }

    public Ecran setEcran(int cWidth, int cHeight, int fWidth, int fHeight){

        this.canvas.setCanvas(cWidth,cHeight);
        this.frame = setFrame(fWidth,fHeight);

        Ecran newEcran = new Ecran();

        return newEcran;
    }

    private JFrame setFrame(int newWidth, int newHeight){

        fHeight = newHeight;
        fWidth = newWidth;

        frame = new JFrame();

        frame.setSize(fWidth,fHeight);
        frame.getContentPane().add(canvas.getCanvas());
        frame.setTitle("Java - OpenGL");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        return frame;
    }


}
