package supercube;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL30;
import org.lwjgl.system.MemoryStack;

import java.nio.IntBuffer;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Ecran {

    public long window;

    public Ecran(){
        super();
    }

    public Ecran createEcran(){

        this.window = setWindow();

        return this;
    }

    private long setWindow(){

        GLFWErrorCallback.createPrint(System.err).set();

        if(!glfwInit()){
            throw new IllegalStateException("initialisation openGL failed, please don't ask me why, cause I don't know");
        }

        glfwDefaultWindowHints(); //default hint
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); //window invisible pendant init | config GLFW
        glfwWindowHint(GLFW_RESIZABLE,GLFW_TRUE); //window resizable pendant init | config GLFW

        //creation fenetre
        window = glfwCreateWindow(960, 960,"SuperCube", NULL, NULL);
        if(window == NULL){
            throw new RuntimeException("initialisation openGL window failed, please don't ask me why, cause I don't know");
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

            //centre la fenetre :
            //xPositionEcran = tailleEcranUser - tailleWindow/2
            //yPositionEcran = hauteurEcranUser - HauteurWindow/2)
            //centreEcranUser(x,y) = centreEcranUSer(xPositionEcran, yPositionEcran)
            glfwSetWindowPos(window,(vidMode.width() - pWidth.get(0)/2), (vidMode.height() - pHeight.get(0)/2));

            //context current => window
            glfwMakeContextCurrent(window);

            //Active SyncroVertical
            glfwSwapInterval(1);

            //show => window
            glfwShowWindow(window);

        }
        GL.createCapabilities();

        glClearColor(0.5f,0.5f,0.5f,1.0f); // set backgroundcolor (ici jaune)
        glClear(GL_COLOR_BUFFER_BIT);

        return window;
    }

    public void runWindow(Vecteurs vecteurs){

        //run window tant que glfwWindowShouldClose == false
        while(!glfwWindowShouldClose(window)){
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            // draw carre
            glDrawElements(GL30.GL_TRIANGLES, vecteurs.indices.length,GL_UNSIGNED_INT,0 );
            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }

}
