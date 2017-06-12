<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul>
	<li>
		<spring:url value="/manager/pending" var="pending" htmlEscape="true" /> 
		<a href="${pending}"> <spring:message code="menu.leaveForApproval" /></a>
	</li>
					
	<li>
		<spring:url value="/manager/shistory" var="shistory" htmlEscape="true" /> 
		<a href="${shistory}"><spring:message code="menu.subordinateHistory" /></a>
	</li>
</ul>