package supercube;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL30;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.GL_FLOAT;

public class Vecteurs {
    public float[] vecteurs;
    public  int[] indices;


    public Vecteurs(){
        super();
    }

    public Vecteurs createStandardVecteurs(){

        this.vecteurs = standardVecteurs();
        this.indices = standardIndices();


        return this;
    }

    private int[] standardIndices(){

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

        return indices;
    }
    private float[] standardVecteurs(){

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
        GL30.glBindBuffer(GL30.GL_ARRAY_BUFFER,vboID); // set id buffer créé pour plus tard modifier attributs vecteur (attributs = color/position/texture...)

        //set data to specific buffer , ici data = position vecteur , GL_STATIC_DRAW = glBindBufferdata (position), fixe la position du vecteur non modifiable à l'avenir
        GL30.glBufferData(GL30.GL_ARRAY_BUFFER,vboBuffer,GL30.GL_STATIC_DRAW);

        //glVertexAttribPointer = pointeur vers attributs(data)
        //buffer(0 = premier attributs par vecteur, nb attributs (ici vecteurs(x,y) => 2 data (x et y) par attribut),type data = GL_FLOAT,false,nb bytes par attributs(data),"position" vers quel attribut(data) (ici = 0)
        GL30.glVertexAttribPointer(0,positionElementCount,GL_FLOAT,false,positionElementCount * Float.BYTES,0);
        GL30.glEnableVertexAttribArray(0);

        return vecteurs;
    }
}
