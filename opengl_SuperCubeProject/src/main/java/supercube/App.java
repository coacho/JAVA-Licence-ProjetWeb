package supercube;

import org.lwjgl.BufferUtils;
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
        window = glfwCreateWindow(960, 960,"JAUNE!", NULL, NULL);
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
            //xPositionEcran = tailleEcranUser - tailleWindow/2
            //yPositionEcran = hauteurEcranUser - HauteurWindow/2)
            //centreEcranUser(x,y) = centreEcranUSer(xPositionEcran, yPositionEcran)
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

        float[] vecteurs = new float[]{
                -0.5f,  0.5f,  // vecteur 0
                -0.5f, -0.5f,  // vecteur 1
                0.5f, -0.5f,   // vecteur 2
                0.5f,  0.5f    // vecteur 3
        };

        //VBO (vertex Buffer Object) || Espace Memoire Tampon des Vecteurs
        FloatBuffer vboBuffer = BufferUtils.createFloatBuffer(vecteurs.length);
        for(float unVecteur : vecteurs){
            vboBuffer.put(unVecteur);
        }
        //method flip voir -->
        //https://stackoverflow.com/questions/29397407/gldrawbuffers-should-have-flipped-intbuffer
        vboBuffer.flip();

        // pass data to GPU
        int positionElementCount = vecteurs.length / 4; //count nombre de vecteurs (ici = carré = 4)
        int vboID = GL30.glGenBuffers(); //Cree espace memoire où stocker info vecteurs || return Id chaque vecteur
        GL30.glBindBuffer(GL30.GL_ARRAY_BUFFER,vboID); // set id buffer créé pour plus tard modifier attributs vecteur (attributs = color/position/texture..)
        //set data to specific buffer || ici data = position vecteur || GL_STATIC_DRAW = data (position), fixe la position du vecteur non modifiable à l'avenir
        GL30.glBufferData(GL30.GL_ARRAY_BUFFER,vboBuffer,GL30.GL_STATIC_DRAW);
        //glVertexAttribPointer = pointeur vers attributs(data)
        //buffer(0 = premier attributs par vecteur, nb attributs (ici vecteurs(x,y) => 2 data (x et y) par attributs),type data = GL_FLOAT,false,nb bytes par attributs(data),"position" vers quel attribut(data) || ici = 0
        GL30.glVertexAttribPointer(0,positionElementCount,GL_FLOAT,false,positionElementCount * Float.BYTES,0);
        GL30.glEnableVertexAttribArray(0);


        //Indices
        //data sens inverse dans le tab int
        int[] indices = new int[]{
                0,1,2,
                2,3,0
        };

        IntBuffer iboBuffer = BufferUtils.createIntBuffer(indices.length);
        for(int index : indices){
            iboBuffer.put(index);
        }
        iboBuffer.flip();

        int iboID = GL30.glGenBuffers();
        GL30.glBindBuffer(GL30.GL_ELEMENT_ARRAY_BUFFER, iboID);
        GL30.glBufferData(GL30.GL_ELEMENT_ARRAY_BUFFER, iboBuffer,GL30.GL_STATIC_DRAW);



        //run window tant que glfwWindowShouldClose == false
        while(!glfwWindowShouldClose(window)){
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            // draw carre
            GL30.glDrawElements(GL30.GL_TRIANGLES, indices.length,GL_UNSIGNED_INT,0 );
            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }

    public static void main(String[] args){
        new App().run();
    }

}
