//upload.jsp用于更新数据库的值
<%@page import="utils.*"%>
<%@page import="dao.*"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<%!// 字符处理函数 换行符变成<br>
	public String turn(String str) {

		while (str.indexOf("\n") != -1) {
			str = str.substring(0, str.indexOf("\n")) + "<br>" + str.substring(str.indexOf("\n") + 1);
		}
		while (str.indexOf(" ") != -1) {
			str = str.substring(0, str.indexOf(" ")) + "&nbsp" + str.substring(str.indexOf(" ") + 1);
		}
		return str;
	}%>
	<%
		request.setCharacterEncoding("utf-8");
		String text = request.getParameter("textName");
		String textbr = turn(text);
		String strq_id = request.getParameter("q_id");
		String stru_id = request.getParameter("u_id");
		String date = request.getParameter("date");
		int u_id = Integer.parseInt(stru_id);
		int q_id = Integer.parseInt(strq_id);
		String driverClass = DBConn.getDRI();
		String url = DBConn.getURL();//存到数据库不会乱码
		String user = DBConn.getUsr();
		String password = DBConn.getPWD();
		Connection conn;
		int i = 0;
		Class.forName(driverClass).newInstance();
		conn = DriverManager.getConnection(url, user, password);
		String sql = "insert into qiuwen_quesanswer (q_id,u_id,a_text,ans_time) " + "values(?,?,?,?)";
		QuestionDAO qd = new QuestionDAO();
		qd.updateFollow(q_id);
		PreparedStatement pstmt;
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setInt(1, q_id);
		pstmt.setInt(2, u_id);
		pstmt.setString(3, textbr);
		pstmt.setString(4, date);

		i = pstmt.executeUpdate();
		conn.close();
		pstmt.close();
	%>
	<jsp:forward page="problemDetails.jsp">
		<jsp:param name="q_id" value="<%=q_id%>" />
	</jsp:forward>
</body>
</html>