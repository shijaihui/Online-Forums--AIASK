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
@WebServlet("/QuestionManageServlet")

public class QuestionManageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		QuestionDAO quesManage = new QuestionDAO();
		ArrayList<QuestionBean> questions = quesManage.selectAll();

		request.setAttribute("QuestionAll", questions);
		request.getRequestDispatcher("adminPages/adminQuestion.jsp").forward(request, response);
	}
}




