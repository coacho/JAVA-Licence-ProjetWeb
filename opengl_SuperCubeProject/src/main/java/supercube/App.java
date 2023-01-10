package supercube;

import java.util.Objects;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
public class App {

    public void run() {

        Ecran newWindow = new Ecran();
        Vecteurs newVecteur = new Vecteurs();
        Shader newShader = new Shader();

        init(newWindow, newVecteur);
        loop(newWindow, newVecteur,newShader);

        //destroy window et libère memoire
        glfwFreeCallbacks(newWindow.window);
        glfwDestroyWindow(newWindow.window);

        // Terminate GLFW et libère les erreurs en sortie
        glfwTerminate();
        Objects.requireNonNull(glfwSetErrorCallback(null)).free();

    }

    private void init(Ecran newWindow,Vecteurs newVecteur){

        newWindow.createEcran();
        newVecteur.createStandardVecteurs();

    }

    private void loop(Ecran newWindow,Vecteurs newVecteur,Shader newShader) {

        newShader.createShader();
        ///debug
        //System.out.println(newShader.vertexShader);
        //System.out.println(newShader.fragmentShader);
        System.out.println(newShader.ShaderId);
        ////
        newWindow.runWindow(newVecteur);
    }



    public static void main(String[] args){
        new App().run();
    }

}
