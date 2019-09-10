<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户登录</title>
</head>
<script src="/task-mgr/static/js/jquery-1.11.0.min.js"></script>
<link href="/task-mgr/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="/task-mgr/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<body>
	<form class="form-horizontal" id="login_form">
	  <div class="form-group">
	    <label class="col-sm-2 control-label">用户名</label>
	    <div class="col-sm-3" >
	      <input type="text" class="form-control" name="username" placeholder="用户名">
	    </div>
	  </div>
	  <div class="form-group">
	    <label  class="col-sm-2 control-label">密码</label>
	    <div class="col-sm-3">
	      <input type="password" class="form-control" name="password" placeholder="密码">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button class="btn btn-default" type="button" id="login_btn">登录</button>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-1">
	      <button class="btn btn-default" type="button" id="register_btn">注册</button>
	    </div>
	  </div>
	</form>
	<script type="text/javascript">
		$(function(){
			$("#login_btn").click(function(){
				$.ajax({
					async:false,
					url:"/task-mgr/user/login",
					type:"POST",
					data:$("#login_form").serialize(),
					success:function(result){
						console.log(result);
						window.location.href="/task-mgr/task/listTasks";
					},
					error:function(){
						alert("用户名或密码错误");
					}
				});
			});
			
			$("#register_btn").click(function(){
				window.location.href="/task-mgr/user/register";
			});
		});
	</script>
</body>
</html>
