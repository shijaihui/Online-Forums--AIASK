package servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.QuestionBean;
import dao.QuestionDAO;

/**
 * Servlet implementation class UserManageServlet
 */
@WebServlet("/QuestionSearchServlet")

public class QuestionSearchServlet extends HttpServlet {

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
		int quesId = Integer.parseInt(id);
		
		QuestionDAO qd = new QuestionDAO();
		ArrayList<QuestionBean> questions = qd.searchById(quesId);

		request.setAttribute("QuestionAll", questions);
		request.getRequestDispatcher("adminPages/QuestionSR.jsp").forward(request, response);
	}
}