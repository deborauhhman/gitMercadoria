package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrincipalServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8087258929231352398L;
	
	protected void controleChamada(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		try{
			request.getRequestDispatcher("../index.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	controleChamada(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	controleChamada(request, response);
    }
	
}
