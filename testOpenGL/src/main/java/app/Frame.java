package app;

import javax.swing.*;

public class Frame {

    private int fWidth;
    private int fHeight;
    private JFrame frame = new JFrame();

    public Frame(){
        super();
    }

    public void initNewFrame(int newWidth, int newHeight) {
        setfHeight(newHeight);
        setfWidth(newWidth);
    }

    public JFrame setFrame(Canvas newCanvas){

        frame.setSize(fWidth,fHeight);
        frame.getContentPane().add(newCanvas.getCanvas());
        frame.setTitle("Java - OpenGL");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        return frame;
    }

    public int getfWidth() {
        return fWidth;
    }

    private void setfWidth(int fWidth) {
        this.fWidth = fWidth;
    }

    public int getfHeight() {
        return fHeight;
    }

    private void setfHeight(int fHeight) {
        this.fHeight = fHeight;
    }
}

