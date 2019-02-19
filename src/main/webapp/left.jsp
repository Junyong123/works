<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<ul class="nav nav-sidebar">
	<li id="create" class="create"><a href="<%=request.getContextPath()%>/createBoard">게시판 생성</a></li>
</ul>

<ul class="nav nav-sidebar">
	<c:forEach items="${sessionScope.blist}" var="blist">
		<c:if test="${blist.board_use == '사용'}">
			<li id="creates" class="creates"><a href="${pageContext.request.contextPath}/board?board_name=${blist.board_name }">${blist.board_name }</a></li>
		</c:if>
	</c:forEach>
</ul>