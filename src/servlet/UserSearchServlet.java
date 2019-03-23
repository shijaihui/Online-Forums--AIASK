package servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.UserBean;
import dao.UserDAO;

/**
 * Servlet implementation class UserManageServlet
 */
@WebServlet("/UserSearchServlet")

public class UserSearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html; charset=UTF-8");
		String id = request.getParameter("id");
		int usrId = Integer.parseInt(id);
		
		UserDAO ud = new UserDAO();
		ArrayList<UserBean> users = ud.searchById(usrId);
		
		request.setAttribute("UserAll", users);
		request.getRequestDispatcher("adminPages/UserSR.jsp").forward(request, response);
	}
}