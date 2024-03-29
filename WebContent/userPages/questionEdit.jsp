<%@ page import="utils.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.sql.*" import="java.text.*" import="java.util.Calendar"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	//获取发帖时间，用户以及问题的id
	int i = 0;
	int u_id = -1;
	HttpSession session1 = request.getSession();
	if(session1 != null){
		if(session1.getAttribute("uid")!=null){
			u_id = (int) session1.getAttribute("uid");
		}
	}
	
	String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
	String strId = request.getParameter("q_id");
	int q_id = Integer.parseInt(strId);

	Class.forName(DBConn.getDRI());
	Connection conn = DriverManager.getConnection(DBConn.getURL(), DBConn.getUsr(), DBConn.getPWD());
	Statement stmt = conn.createStatement();

	//从数据库获取问题
	ResultSet rs = stmt.executeQuery("select * from qiuwen_question where q_id=" + q_id);
%>


<!DOCTYPE html >

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="description"
	content="Basic HTML5 App generated by MyEclipse Mobile Tools" />
<!--引入Bootstrap-->
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="bootstrap3.3.7/js/bootstrap.js"></script>
<link href="bootstrap3.3.7/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="jquery.cookie.js"></script>
<script type="text/javascript" src="task.js"></script>
<script type="text/javascript" src="tongji.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<link href="bootstrap3.3.7/css/bootstrap.css" rel="stylesheet">
<!--引入jquery-->

<!-- 引入layer -->
<!-- 引入外部css-->
<link href="css/qiuwen.css" rel="stylesheet">
<title>questionEdit</title>
<style>
</style>
<script type="text/javascript">
	$(document).ready(function() {

		$("button#answer").click(function() {
			window.location.href = "userPages/questionEdit.jsp";
		});

		$("button.login").click(function() {
			/* Act on the event */
			layer.open({
				type : 2,
				title : '登陆',
				shadeClose : true,
				shade : 0.8,
				area : [ '400px', '480px' ],
				content : 'login.html',
			// success: function(layero,index)
			// {
			// 	 var subm = layer.getChildFrame('#subm',index);
			// 	 subm.click(function(event) {
			// 	 layer.closeAll();
			// 	 });
			// }
			});

		});

		$("button.zhuce").click(function() {
			/* Act on the event */
			layer.open({
				type : 2,
				title : '注册',
				shadeClose : true,
				shade : 0.8,
				area : [ '400px', '480px' ],
				content : 'sign.html',
				success : function(layero, index) {
					// layer.msg('注册成功')；
				}

			});

		});

		$("button.ask").click(function() {
			/* Act on the event */
			layer.open({
				type : 2,
				title : '问题编辑',
				shadeClose : true,
				shade : 0.8,
				area : [ '700px', '350px' ],
				content : 'edit.html',
				success : function(layero, index) {

					// layer.msg('提交成功')
				}
			});

		});
	});
	//提交文本框的值
	function upload() {
		document.getElementById("text").value = document
				.getElementById("content").value;
		document.getElementById("formid").submit();
	}
</script>

</head>
<body style="background-image: url(images/back.jpg)">
	<%
		if (rs.next()) {
	%>
	<div class="header" id="header">
		<nav class="navbar" role="navigation">
			<div class="navbar-header">
				<img class="tubiao" src="images/biao.jpg" width="100" height="100"
					alt="图标" v-on:click="test">
			</div>

		</nav>
	</div>
	<div class="container body">
		<div class="row top"></div>
		<div class="row">
			<div class="container feed">
				<div class="row block">

					<div class="col-md-10 block-content">
						<div class="row rightCol">
							<div class="col-sm-8 rightOner">
								<h2>
									<b> <%=rs.getString("q_text")%>
									</b>
								</h2>
							</div>
						</div>
						<div class="row rightCol"></div>
						<div class="row rightCol">
							<div class="col-md-2">
								<div class="row">
									<div class="col-md-12">请在下方编辑答案</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--row-->
		<div class="row">
			<div class="container feed">
				<div class="row block4"></div>
			</div>
		</div>
		<!--row-->
		<div class="row">
			<div class="container feed">
				<div class="row block2">
					<p>
						<button type="button" class="btn btn-default">
							<span class="glyphicon glyphicon-font"></span>
						</button>
						<button type="button" class="btn btn-default">
							<span class="glyphicon glyphicon-bold"></span>
						</button>
						<button type="button" class="btn btn-default">
							<span class="glyphicon glyphicon-picture"></span>
						</button>
						<button type="button" class="btn btn-default">
							<span class="glyphicon glyphicon-expand"></span>
						</button>
					</p>
					<div class="form-group">
						<!-- 提交各个字段的值给upload。jsp -->
						<form method="post" action="userPages/upload.jsp" id="formid">
							<input type="hidden" id="text" name="textName" />
							<textarea class="form-control" rows="32" id="content"></textarea>
							<input type="hidden" name="q_id" value="<%=q_id%>"> <input
								type="hidden" name="u_id" value="<%= u_id %>"> <input
								type="hidden" name="date" value="<%=date%>">

						</form>
					</div>
				</div>
			</div>
		</div>
		<!--row-->
		<div class="row">
			<div class="container feed">
				<div class="row block3">
					<button class="button1 btn btn-primary" type="button"
						onclick="upload();">提交回答</button>
					</a>
				</div>
			</div>
		</div>
		<!--row-->
	</div>
	<script>
		$("button.button1").click(function() {
			layer.msg('提交成功');
		});
	</script>
	<%
		}
	%>
</body>

</html>