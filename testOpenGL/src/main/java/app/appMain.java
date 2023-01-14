package app;

import java.util.ArrayList;

public class appMain {

    /** The entry main() method to set up the top-level container and animator */
    public static void main(String[] args) {

        Ecran newEcran = new Ecran();

        Canvas test = new Canvas();
        test.newCanvas(100,100);
        //Canvas exempleCour = new Canvas();
        //exempleCour.newCanvas(800,900);

        ArrayList<Canvas> listCanvas = new ArrayList<>();

        listCanvas.add(test);
        //listCanvas.add(exempleCour);

        newEcran.newEcran(listCanvas,900,500);


    }

}