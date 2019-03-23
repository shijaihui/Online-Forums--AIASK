<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>九九乘法表</title>
</head>
<body>
	<table border="0">
      		<%
      			for(int i = 1; i <=9; i++){ //行
            %>     	
      				<tr>
      		<%
      				for(int j = 1; j <=9; j++){ //列
      		%>
      					<td style="border:1.5px solid black;padding:2px ;color:red">
      						<%=i*j%>
      					</td>
      		<%			
      					
      				}
      		%>
      				</tr>
      		<%
      			}
      		%>
      </table>

</body>
</html>