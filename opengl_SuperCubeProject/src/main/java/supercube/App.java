package supercube;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class App {

    private long window;

    public void run(){

        init();
        loop();

        //destroy window et libère memoire
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        // Terminate GLFW et libère les erreurs en sortie
        glfwTerminate();
        glfwSetErrorCallback(null).free();

    }

    private void init(){

        GLFWErrorCallback.createPrint(System.err).set();

        if(!glfwInit()){
            throw new IllegalStateException("initialisation openGL failed, please don't ask me why, cause I don't know");
        }

        glfwDefaultWindowHints(); //default hint
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); //window invisible pendant init | config GLFW
        glfwWindowHint(GLFW_RESIZABLE,GLFW_TRUE); //window resizable pendant init | config GLFW

        //creation fenetre
        window = glfwCreateWindow(960, 960,"Hello wolrd", NULL, NULL);
        if(window == NULL){
            throw  new RuntimeException("initialisation openGL window failed, please don't ask me why, cause I don't know");
        }

        // femeture fenetre avec la touche "echap"
        glfwSetKeyCallback(window,(window, key, scancode,action,mods) -> {
            if( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE){
                glfwSetWindowShouldClose(window, true);
            }
        });


        try( MemoryStack stack = stackPush()){

            IntBuffer pWidth = stack.mallocInt(1);
            IntBuffer pHeight = stack.mallocInt(1);

            //get la size de window
            glfwGetWindowSize(window, pWidth, pHeight);

            //get résolution ecran principal de l'user
            GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            //centre la fenetre
            // xPositionEcran = tailleEcranUser - tailleWindow/2  et  yPositionEcran= hauteurEcranUser - HauteurWindow/2
            glfwSetWindowPos(window,(vidMode.width() - pWidth.get(0)/2), (vidMode.height() - pHeight.get(0)/2));

            //context current => window
            glfwMakeContextCurrent(window);

            //Active SyncroVertical (repris tuto)
            glfwSwapInterval(1);

            //show => window
            glfwShowWindow(window);

        }

    }

    private void loop(){

        GL.createCapabilities();

        glClearColor(1.0f,1.0f,0.0f,0.0f);

        //run window tantque glfwWindowShouldClose == false
        while(!glfwWindowShouldClose(window)){
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }

    public static void main(String[] args){
        new App().run();
    }

}
