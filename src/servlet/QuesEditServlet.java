package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.*;
import dao.*;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class QuesEditServlet
 */
@WebServlet("/QuesEditServlet")
public class QuesEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuesEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String content = request.getParameter("content");
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("uid");
		System.out.println(content+uid);
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String subTime = sdf.format(d);
		QuestionDAO quesI = new QuestionDAO();
		ResultSet res = quesI.insertQues(content, subTime);
		//
		String responseText ="";
		if(res != null){
			try {
				res.next();
				int qid = res.getInt("qid");
				QuestionDAO release = new QuestionDAO();
				boolean rs = release.insertItem(uid, qid);
				if(rs){
					UserQuesBean ques = new UserQuesBean();
					
					ques.setQid(qid);
					ques.setUid(uid);
					ques.setSubTime(subTime);
					ques.setText(content);
					ques.setFollow(0);
					ques.setClickNum(0);
					ques.setIs_top(0);
					
					UserDAO ud = new UserDAO();
					ArrayList<UserBean> usrs = ud.searchById(uid);
					ques.setAccount(usrs.get(0).getAccount());
					ques.setSchool(usrs.get(0).getSchool());

			        JSONObject json = JSONObject.fromObject(ques);
			        responseText = json.toString();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 response.setContentType("application/json;charset=utf-8");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out =response.getWriter() ;
		 out.write(responseText);
		 out.close();
	}
}