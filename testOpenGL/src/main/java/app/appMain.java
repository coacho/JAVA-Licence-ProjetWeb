package app;

import java.util.ArrayList;

public class appMain {

    /** The entry main() method to set up the top-level container and animator */
    public static void main(String[] args) {

        Ecran newEcran = new Ecran();

        Frame testFrame = new Frame();
        testFrame.initNewFrame(2000,2000);

        Canvas testCanvas = new Canvas();
        testCanvas.initNewCanvas(100,100);

        Canvas exempleCour = new Canvas();
        exempleCour.initNewCanvas(800,900);

        ArrayList<Canvas> listCanvas = new ArrayList<>();

        listCanvas.add(testCanvas);
        listCanvas.add(exempleCour);

        newEcran.newEcran(listCanvas,testFrame);


    }

}