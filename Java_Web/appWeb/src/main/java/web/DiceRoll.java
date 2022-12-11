package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class DiceRoll
 */
@WebServlet(name = "DiceRoll", urlPatterns = {"/DiceRoll"})
public class DiceRoll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DiceRoll() {
        super();
    }

    protected void doGet(
    	    HttpServletRequest request,
    	    HttpServletResponse response)
    	    throws ServletException , IOException
    	    {
    	    response.setContentType("text/html;charset=UTF-8");
    	    try (PrintWriter out = response.getWriter())
    	    {
    		    out.println("<!DOCTYPE html>");
    		    out.println("<html>");
    		    out.println("<body>");	
    		    
    		    ArrayList<Integer> value = new ArrayList<Integer>();
    		    int[] limit = {1,6};
    		    int dice = (int)(Math.random()*limit[1])+limit[0];
    		    value.add(dice);
    		    
    		    out.println("random int :");
    		    out.println(value.get(0));
    		    out.println("</body></html>");
    	    }
        }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
