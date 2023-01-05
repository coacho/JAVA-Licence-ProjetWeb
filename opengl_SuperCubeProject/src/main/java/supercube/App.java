package supercube;

import org.lwjgl.opengl.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Objects;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
public class App {

    public void run(){

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
        glfwSetErrorCallback(null).free();

    }

    private void init(Ecran newWindow,Vecteurs newVecteur){

        newWindow.createEcran();
        newVecteur.createStandardVecteurs();

    }

    private void loop(Ecran newWindow,Vecteurs newVecteur,Shader newShader){

        newShader.createShader();
        newWindow.runWindow(newVecteur);
    }



    public static void main(String[] args){
        new App().run();
    }

}
