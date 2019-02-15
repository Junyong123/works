<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body {
	font-family: "맑은 고딕";
	font-size: 0.75em;
	color: #333;
}

#login-form {
	width: 200px;
	margin: 100px auto;
	border: 1px solid gray;
	border-radius: 5px;
	padding: 15px;
}

/* inline이였던 요소들을 block으로 바꿈 */
#login-form input, #login-form label {
	display: block;
}

#login-form label {
	margin-top: 10px;
}

#login-form input {
	margin-top: 5px;
}

/* 애트리뷰트 선택자 */
#login-form input[type='image'] {
	margin: 10px auto;
}
</style>

<body>

	<form action="${pageContext.request.contextPath }/login" id="login-form" method="post">
		<label class="legend">아이디</label> 
		<input id="userId" name="userId" type="text">
		<label class="legend">패스워드</label> 
		<input id="password" name="password"type="password">
		<input type="image" src="images/login.png" value="로그인">
	</form>
</body>



</html>