<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 	<meta charset="utf-8"> -->
<!--     <meta http-equiv="X-UA-Compatible" content="IE=edge"> -->
<!--     <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!--     The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<!--     <meta name="description" content=""> -->
<!--     <meta name="author" content=""> -->
<!--     <link rel="icon" href="../../favicon.ico"> -->

<title>Insert title here</title>
	<!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/css/dashboard.css" rel="stylesheet">

</head>
<body>
	<%@ include file="/header.jsp" %>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
        	<%@ include file="/left.jsp" %> 
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        
        
<!--                      게시판 이름 &nbsp;&nbsp;&nbsp;<input type="text">&nbsp;&nbsp; &nbsp; -->
<!--           <select> -->
<!--           	<option>사용</option> -->
<!--           	<option>미사용</option> -->
<!--           </select>&nbsp;&nbsp;&nbsp; -->
<!--           <button type="button"> -->
<!-- 			 생성         	 -->
<!--           </button> -->
          
		 <form action="${pageContext.request.contextPath }/updateBoard" method="get">
          <table class="table table-striped style="text-align: center; border: 1px solid #dddddd">
		    <thead>
		     <tr>
		      <th style="background-color: #eeeeee; text-align: center; ">게시판 이름 </th>
		      <th style="background-color: #eeeeee; text-align: center; "><input id="boardname" name="boardname" type="text"></th>
		      <th style="background-color: #eeeeee; text-align: center; ">
			      <select id="sel" name="sel">
		          	<option>사용</option>
		          	<option>미사용</option>
		          </select>
	          </th>
		      <th style="background-color: #eeeeee; text-align: center; ">
			      <button type="submit">
					 생성         	
		          </button>
		      </th>
		     </tr>
		    </thead>
		    </table>
		    </form>
	
		     <c:forEach items="${blist }" var="study"> 
		    <form action="${pageContext.request.contextPath }/updateBoard2" method="get">
		    <table class="table table-striped style="text-align: center; border: 1px solid #dddddd">
		    <tbody>
		     	<tr style="text-align: center;">
		     	  <td>게시판 이름</td>
			      <td>
			      <input type="text" id="boardnameup" name="boardnameup" value="${study.board_name }">
			      <input type="hidden" id="hid" name="hid" value="${study.board_num }">
			      </td>
			      <td>
			      	<c:choose>
			      		<c:when test="${study.board_use == '사용' }">
					      <select id="selup" name="selup">
				          	<option selected="selected">사용</option>
				          	<option>미사용</option>
			          	  </select>
			          	</c:when>
			          	
			      		<c:when test="${study.board_use == '미사용' }">
					      <select id="selup" name="selup">
				          	<option>사용</option>
				          	<option selected="selected">미사용</option>
			          	  </select>
			          	</c:when>
			        </c:choose>
			      </td>
			      <td>
				      <button type="submit" id="btnup" name="btnup">
						 수정         	
			          </button>
				  </td>
		     	</tr>
		    </tbody>
		  </table>
		 </form>
		     </c:forEach>
          
          
          
        </div>
      </div>
    </div>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
	
</body>
</html>