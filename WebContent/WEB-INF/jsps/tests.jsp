<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" action="${pageContext.request.contextPath}/tests" commandName="search">
	<label id="tcid">TC_ID</label><form:input class="control" path="tc_id" type="text"></form:input>
	<input class="control" type="submit" value="Search"></input>
</form:form>	
	<table>
		<tr>
			<th>TC_ID</th>
			<th>TC_Name</th>
			<th>Execute</th>
		</tr>
		<c:forEach var="test" items="${tests}">
			<tr>
				<td><c:out value="${test.tc_id}"></c:out></td>
				<td><c:out value="${test.tc_name}"></c:out></td>
				<td><c:out value="${test.execute}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>