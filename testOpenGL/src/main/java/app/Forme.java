package app;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;

public class Forme extends GLCanvas implements GLEventListener {

    public Forme(){
        this.addGLEventListener(this);
    }


    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

        GL2 gl = glAutoDrawable.getGL().getGL2();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        //gl.glClearColor(60.0f/255.0f, 179.0f/255.0f, 113.0f/255.0f, 1.0f);
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL2 gl = glAutoDrawable.getGL().getGL2();
        // Initialisation des états
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glLoadIdentity();
        // Dessin d’un triangle
        gl.glBegin(GL2.GL_TRIANGLES); // draw using triangles
        gl.glColor3f(0.9f, 0.1f, 0.1f);
        gl.glVertex3f(0.0f, 1.0f, -6.0f);
        gl.glVertex3f(-1.0f, -1.0f, -6.0f);
        gl.glVertex3f(1.0f, -1.0f, -6.0f);
        gl.glEnd();
        /*gl.glBegin(GL_TRIANGLES); // draw using triangles
        gl.glColor3f(0.1f, 0.1f, 0.9f);
        gl.glVertex3f(0.0f, -1.5f, -6.0f);
        gl.glVertex3f(-1.0f, 0.5f, -6.0f);
        gl.glVertex3f(1.0f, 0.5f, -6.0f);
        gl.glEnd();*/
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int x, int y, int width, int height) {
        GL2 gl = glAutoDrawable.getGL().getGL2();
        GLU glu = GLU.createGLU(gl);

        float aspect = (float)width / height;
        // Set the view port (display area)
        gl.glViewport(0, 0, width, height);
        // Setup perspective projection,
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0, aspect, 0.1, 100.0);
        // Enable the model-view transform
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity(); // reset

    }
}
