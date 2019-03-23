package servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;;

/**
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/SchoolUpdateServlet")
public class SchoolUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchoolUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ddfdfdfddfddf");
		String uid = request.getParameter("id");
		String text = request.getParameter("text");
		System.out.println("Update"+text);
		int quesId = Integer.parseInt(uid);
		String responseText = "";
	    UserDAO updateQ = new UserDAO();
		
	    if(updateQ.updateSchool(quesId,text)){
	    	responseText = "{ \"code\" : \"success\" , "
	    			+ "\"text\" : \""+text+"\" }";
	    }else{
	    	responseText = "{\"code\" : \"fail\" , "
	    			+ "\"text\" : \""+text+"\" }";
	    }
		
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");  
		PrintWriter writer = response.getWriter();
		writer.append(responseText); 
	}
}
