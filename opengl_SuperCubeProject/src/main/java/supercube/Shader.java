package supercube;

import org.lwjgl.opengl.GL30;

import java.io.*;
import java.util.Objects;

public class Shader {

    public int vertexShader;
    public int fragmentShader;

    public int ShaderId;

    public Shader(){
        super();
    }

    public Shader createShader(){

        int programShaderID = GL30.glCreateProgram();
        int vertShaderObj = GL30.glCreateShader(GL30.GL_VERTEX_SHADER);
        int fragShaderObj = GL30.glCreateShader(GL30.GL_FRAGMENT_SHADER);

        vertexShader = setVertexShader(programShaderID,vertShaderObj);
        fragmentShader = setFragmentShader(programShaderID,fragShaderObj);
        ShaderId = programShaderID;

        GL30.glLinkProgram(programShaderID);
        GL30.glValidateProgram(programShaderID);
        GL30.glUseProgram(programShaderID);

        // int vertexColorLocation = GL30.glGetUniformLocation(programShaderID,"outColor");
        //GL30.glUniform4f(vertexColorLocation,0.0f,1.0f,0.0f,1.0f);
        // GL30.glBindVertexArray();

        return this;
    }

    private int setVertexShader(int programID, int vertShaderObj){

        String vertexShaderLink = parseShaderFromFile("vert.shader.glsl");

        GL30.glShaderSource(vertShaderObj, vertexShaderLink);
        GL30.glCompileShader(vertShaderObj);
        GL30.glAttachShader(programID, vertShaderObj);

        return vertShaderObj;
    }
    private int setFragmentShader(int programID,int fragShaderObj){

        String fragmentShaderLink = parseShaderFromFile("frag.shader.glsl");

        GL30.glShaderSource(fragShaderObj, fragmentShaderLink);
        GL30.glCompileShader(fragShaderObj);
        GL30.glAttachShader(programID, fragShaderObj);

        return fragShaderObj;
    }

    private static String parseShaderFromFile(String filePath){
        StringBuilder data = new StringBuilder();
        String line = "";
        try{
            //fichiers frag.shader.glsl et vert.shader.glsl || situées dans java/ressource (Maven)
            BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(App.class.getClassLoader().getResourceAsStream(filePath))));

            line = reader.readLine();
            while(line !=null)
            {
                data.append(line);
                data.append("\n");
                line = reader.readLine();
            }
        }catch (Exception e){
            throw new IllegalArgumentException("Shader failed miserably, sorry, it happend here: "+ filePath,e);
        }

        return data.toString();

    }

}
