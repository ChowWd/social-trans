<%@ page language="java"
	import="java.util.*,com.crowd.bean.*,com.crowd.service.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String wsPath = "ws://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>首页</title>
<style>
* {
	padding: 0;
	margin: 0;
}

body {
	background: url(img/userbg.jpg) center center fixed;
	opacity: .7;
}

.logo {
	margin-left: 130px;
	margin-top: 35px;
	width: 400px;
	height: 50px;
	text-align: center;
	font-size: 40px;
	font-weight: 700;
	text-shadow: 0px -1px 2px #408AC7;
}

ul {
	list-style: none;
}

li {
	display: inline-block;
	text-align: center;
}

ul li a {
	text-decoration: none;
}

.signin-up {
	position: absolute;
	top: 55px;
	right: 100px;
}

.signin-up ul li {
	margin-left: 20px;
	width: 100px;
	height: 30px;
	line-height: 30px;
	border-radius: 10px;
	background: rgba(255, 255, 255, .6);
}

.signin-up ul li a {
	color: #434343;
}

.user {
	margin: 70px 0 0 283px;
	width: 400px;
	height: 80px;
}

.user h3 {
	color: #7D7979;
}

.task {
	margin-left: 300px;
	width: 500px;
	height: 80px;
}

.task ul li {
	margin-left: 30px;
}

.task ul li a {
	font-size: 20px;
	font-weight: 500;
	color: #55C1F0;
}
#cancle{
	text-decoration:none;
	display:block;
	position:absolute;
	right:40px;
	top:40px;
	margin-left: 20px;
	width: 100px;
	height: 30px;
	line-height: 30px;
	border-radius: 10px;
	background: rgba(255, 255, 255, .6);
	color: #434343;
	font-size:1em;
	text-align:center;
}
</style>

</head>
<body onload="checkCookie()">
	<script type="text/javascript" src="<%=path%>/js/jquery-1.12.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/sockjs.min.js"></script>
	<div class="logo">Social-trans</div>
	<div class="signin-up">
		<ul>
			<li><a href="user/login">登录</a></li>
			<li><a href="user/register">注册</a></li>
		</ul>
	</div>
	
	<div class="user">
		<h3>
			欢迎您，<span class="accountCookie"><a href="user/userData">${cookie.accountCookie.value }</a></span>
		</h3>
		<span class="accountCookie"><a id="cancle" href="user/login">注销</a></span>
	</div>
	<div class="task">
		<ul>
			<li><a href="task/uploadTask">发布任务</a></li>
			<li><a href="task/getReceiveTaskList">我要接任务</a></li>
			
		</ul>
	</div>
	<script>
	var userName = null;
	function getCookie(accountCookie){
	var cookieName = accountCookie;
	var cookies = document.cookie.split(";");
	for (var i = 0; i < cookies.length; i++) { 
		var cookie = cookies[i];//得到某下标的cookies数组 
		if (cookie.substring(0, cookieName.length + 2).trim() == cookieName.trim() + "=") {//如果存在该cookie的话就将cookie的值拿出来 
			cookieValue = cookie.substring(cookieName.length + 2, cookie.length); 
			if(cookieValue!=null||cookieValue!=""){
				userName=cookieValue;
				console.log(userName);
				return true;
			}else{
				return false;
			}

		}
	}
	}
		function checkCookie(){
			if(!getCookie('accountCookie')){
				var ss = document.querySelector('.user');
				ss.style.visibility = "hidden";
			}
			else{
				var ss = document.querySelector('.signin-up');
				ss.style.display = "none";
			}
		
		}

		



  
  $(function(){
    //建立socket连接
    var sock;
    if ('WebSocket' in window) {
      sock = new WebSocket("<%=wsPath%>socketServer");
      } else if ('MozWebSocket' in window) {
        sock = new MozWebSocket("<%=wsPath%>socketServer");
      } else {
        sock = new SockJS("<%=basePath%>sockjs/socketServer");
      }
    sock.onopen = function (e) {
      console.log(e);
      };
      sock.onmessage = function (e) {
        console.log(e)
          $("#message").append("<p><font color='red'>"+e.data+"</font>")
      };
      sock.onerror = function (e) {
        console.log(e);
      };
      sock.onclose = function (e) {
        console.log(e);
      }
  });
  

	</script>
</body>
</html>
