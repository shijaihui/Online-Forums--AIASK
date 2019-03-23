package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.*;
import dao.*;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if(session != null){

			if(session.getAttribute("uid") != null){
				int uid = (int) session.getAttribute("uid");
				System.out.println(uid);
				UserDAO isok = new UserDAO();
				ResultSet res = isok.selectIsOk(uid);
				try {
					if(res.next()){
						if(res.getInt("is_ok")==1){
							request.setAttribute("isOk", "is");
						}else{
							request.setAttribute("isOk", "not");
						}
					}
					request.setAttribute("login", "ok");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				request.setAttribute("login", "fail");
				request.setAttribute("isOk", "not");
			}
		}
	
		UserQuesDAO test1 = new UserQuesDAO();
		ArrayList<UserQuesBean> topItems = test1.selectLinkUserTopQues();
		ArrayList<UserQuesBean> unTopItems = test1.selectLinkUserUnTopQues();
		
		request.setAttribute("feed", unTopItems);
		request.setAttribute("feedTop", topItems);

		request.getRequestDispatcher("userPages/home.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
