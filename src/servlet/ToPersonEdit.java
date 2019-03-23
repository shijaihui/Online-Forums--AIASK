package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import entity.UserBean;
import dao.UserDAO;

/**
 * Servlet implementation class ToPersonServlet
 */
@WebServlet("/ToPersonEdit")
public class ToPersonEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToPersonEdit() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int u_id = -1;
		if(session != null){
			if(session.getAttribute("uid")!= null){
				u_id =(int)session.getAttribute("uid");
			}
		}
	
		UserDAO qd = new UserDAO();
		ArrayList<UserBean> users = qd.searchById(u_id);

		request.setAttribute("QuesUserAll", users);
		request.getRequestDispatcher("userPages/personal_edit.jsp").forward(request, response);

	}

}