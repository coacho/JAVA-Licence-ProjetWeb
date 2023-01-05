package supercube;

import org.lwjgl.opengl.GL30;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Shader {

    public String vertexShader;
    public String fragmentShader;

    public Shader(){
        super();
    }

    public Shader createShader(){

        int programID = GL30.glCreateProgram();
        int vertShaderObj = GL30.glCreateShader(GL30.GL_VERTEX_SHADER);
        int fragShaderObj = GL30.glCreateShader(GL30.GL_FRAGMENT_SHADER);

        this.vertexShader = setVertexShader(programID,vertShaderObj);
        this.fragmentShader = setFragmentShader(programID,fragShaderObj);

        GL30.glLinkProgram(programID);
        GL30.glValidateProgram(programID);
        GL30.glUseProgram(programID);

        return this;
    }

    private String setVertexShader(int programID, int vertShaderObj){

        String vertexShader = parseShaderFromFile("src/main/java/supercube/shader/frag.shader.glsl");

        GL30.glShaderSource(vertShaderObj, vertexShader);
        GL30.glCompileShader(vertShaderObj);
        GL30.glAttachShader(programID, vertShaderObj);

        return vertexShader;
    }
    private String setFragmentShader(int programID,int fragShaderObj){

        String fragmentShader = parseShaderFromFile("src/main/java/supercube/shader/frag.shader.glsl");

        GL30.glShaderSource(fragShaderObj, fragmentShader);
        GL30.glCompileShader(fragShaderObj);
        GL30.glAttachShader(programID, fragShaderObj);

        return fragmentShader;
    }

    private static String parseShaderFromFile(String filePath){
        StringBuilder data = new StringBuilder();
        String line = "";
        try{
            InputStream inputStream = new ByteArrayInputStream(filePath.getBytes());
            InputStreamReader input = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(input);
            //BufferedReader reader = new BufferedReader(new InputStreamReader(App.class.getResourceAsStream(filePath)));

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
