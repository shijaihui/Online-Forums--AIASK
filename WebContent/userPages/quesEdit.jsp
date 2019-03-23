<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8" />

	<style>
	.head
	{
		width: 50px;
		float: left;
		margin-left: 30px;
	}
	.img
	{
		height: 50px;
		width: 50px;
	}
	.submit
	{
		width: 140px;
		height: 40px;
		font-size: 13px;
		color: white;
		background-color: #cc3300;
		border: none;
		border-radius: 5px;
		margin-left: 440px;
		margin-top: 30px;
	}
</style>
</head>
<body>
<form id="quesEdit">
	<div style="margin-top: 70px;width: 600px;">
		<div style="width: 300px;float: left;margin-left: 20px;"> 
			<textarea name="content" style="width: 500px;height:100px; "></textarea>
		</div>
	<input type="button" class="submit" id="subm" value="发布">
</div>
</form>

</body>
</html>