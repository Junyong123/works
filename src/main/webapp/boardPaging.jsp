<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Dashboard Template for Bootstrap</title>

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
          
			<h1 class="page-header">${boardName }</h1>
				<!-- userList 정보를 화면에 출력하는 로직 작성 -->
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>게시글번호</th>
								<th>제목</th>
								<th>작성자 아이디</th>
								<th>작성일지</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${bclist }" var="board" varStatus="i">
								<%-- 향상된 for문은 begin이 없어서 i값을 구할 수 없음으로 varStatus를 이용해서 구한다 --%>
								<tr class='boardTr'>
									<td>${i.index }</td>
									<td>${board.board_title }</td>
									<td>${board.board_user }</td>
									<td><fmt:formatDate value="${board.board_day }" pattern="yyyy/MM/dd"/></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<form action="${pageContext.request.contextPath }/write" method="get">
						<button type="submit" class="btn btn-default">글 작성하기</button>
					</form>
					
					<nav style="text-align: center;">
						<ul class="pagination">
							<!-- 첫번째 페이지 -->
							<c:choose>
								<c:when test="${page == 1 }">
									<li class="disabled"><a aria-label="Previous"> <span
											aria-hidden="true">&laquo;</span>
									</a></li>
								</c:when>

								<c:otherwise>
									<li><a
										href="${ pageContext.servletContext.contextPath}/board"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
								</c:otherwise>
							</c:choose>

							<!-- 페이지 -->
							<c:forEach begin="1" end="${lastPage }" var="i">

								<c:set var="active" value="" />
								
								<c:if test="${i== page }">
									<c:set var="active" value="active" />
								</c:if>

								<li class="${active }">
									<%-- var = active를 가지고 온다 --%> <a
									href="${ pageContext.servletContext.contextPath}/board?page=${i}">${i}</a>
								</li>

							</c:forEach>

							<c:choose>
								<c:when test="${page == lastPage}">
									<li class="disabled"><a aria-label="next"> <span
											aria-hidden="true">&raquo;</span>
									</a></li>
								</c:when>

								<c:otherwise>
									<li><a
										href="${ pageContext.servletContext.contextPath}/board"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</c:otherwise>
							</c:choose>

						</ul>
					</nav>



        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!-- jquery를 불러오는 주소 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
  </body>
</html>
