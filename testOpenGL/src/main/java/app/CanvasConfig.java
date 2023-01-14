package app;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.awt.GLCanvas;

public class CanvasConfig extends GLCanvas {

    GL2 testConfig;

    public CanvasConfig(){
        super();
    }

    public void setCanvasConfig(Canvas newCanvas){
        setColor(0.9f,0.1f,0.1f);
        setVertex();
    }

    private void setColor(float v,float v1,float v2){
        testConfig.glColor3f(v, v1, v2);
    }
    private void setVertex(){
        testConfig.glVertex3f(0.0f, 1.0f, -6.0f);
        testConfig.glVertex3f(-1.0f, -1.0f, -6.0f);
        testConfig.glVertex3f(1.0f, -1.0f, -6.0f);
    }

    private GL2 getColor(){
        testConfig = this.testConfig;
        return testConfig;
    }

}
