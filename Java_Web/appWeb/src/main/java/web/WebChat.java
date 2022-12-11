package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.apache.tomcat.jni.File;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 * Servlet implementation class WebChat
 */
@WebServlet(name = "WebChat", urlPatterns = {"/WebChat"})
public class WebChat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebChat() {
        super();
        // TODO Auto-generated constructor stub
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
		    out.println("BONJOURE!");
		    out.println("</body></html>");
	    }
    }
    
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String dateBirth = request.getParameter("dateBirth");

//		Part filePart = request.getPart("file");//image
//		InputStream fileContent = filePart.getInputStream();
		
//		byte[] imageBytes = new byte[fileContent.available()];
//		fileContent.read(imageBytes, 0, imageBytes.length);
//		fileContent.close();
		
//		String imageStr = Base64.encodeBase64String(imageBytes);
				
//		request.getParameter("user");
//		request.getParameter("password");
//		request.getParameter("email");
//		request.getParameter("dateBirth");
//		
		request.getRequestDispatcher("View.jsp").forward(request, response);;
		
		
	   // response.setContentType("text/html;charset=UTF-8");
	   // response.sendRedirect(getServletInfo());
	    
//		try (PrintWriter out = response.getWriter()) {
//			out.println("<!DOCTYPE html>");
//			out.println("<html>");
//			out.println("<head><title>User Servlet</title></head>");
//			out.println("<body>");
//			out.println("User: " + user + "<br>");
//			out.println("Pass: " + password + "<br>");
//			out.println("email: " + email + "<br>");
//			out.println("Birth Date: " + dateBirth + "<br>");
//			//out.println("<img src=\"data:image/jpeg;base64, " + imageStr + "\"/>");
//			out.println("</body></html>");
//		}
		
		//doGet(request, response);
	}
	
	

}
