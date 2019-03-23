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
@WebServlet("/UserManageServlet")

public class UserManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		UserDAO userManage = new UserDAO();
		ArrayList<UserBean> users = userManage.selectAll();
		request.setAttribute("UserAll", users);
		request.getRequestDispatcher("adminPages/adminUser.jsp").forward(request, response);
	}
}