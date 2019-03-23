<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8" />
<html>
<head>
	<meta charset="utf-8" />

	<style>
	.part
	{
		font-size: 20px;
		width:380px;
		height: 30px;
		margin-left: 10px;
		margin-top: 40px;
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
		margin-left: 120px;
		margin-top: 80px;
	}
</style>
</head>
<body>
<div>
	<form id="RegisterF" >
		<div id="part" class="part"> 
			<h>用户名</h>
			<input id="id" name="id" style="height: 28px;width: 263px;margin-left: 30px;" placeholder="请输入邮箱"></input>
		</div>
		<div id="" class="part"> 
			<h>密码</h>
			<input id="psd" name="psd" style="height: 28px;width: 263px;margin-left: 50px;"placeholder="请输入6-14位密码"></input>
		</div>
		<div id="" class="part" > 
			<h>确认密码</h>
			<input id="psd2" name="psd2" style="height: 28px;width: 263px;margin-left: 10px;" placeholder="请确认密码"></input>
		</div>
		<input type="submit" class="submit" id="submit" value="立即注册">
	</form>
</div>
<script type="text/javascript">
	function form_confirm()
{
    var id=document.getElementById("id").value
    var psd=document.getElementById("psd").value
    var psd2=document.getElementById("psd2").value
     var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
     if(!myreg.test(id))
     {
     	alert('用户名请输入有效的邮箱！');
		return false;
     }
    if(psd.length<6)
    {
        alert("密码长度不能小于6位");
        return false; 
    }
    if(psd.length>14)
    {
        alert("密码长度不能大于14位");
        return false; 
    }
    if(psd!=psd2) 
	{ 
	alert("密码不一致");
	return flase;
	} 
}

</script>
</body>
</html>