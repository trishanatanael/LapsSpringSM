<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<body>
	<h3>
		<spring:message code="${title.leaveApplicationDetails}" />
	</h3>
	<c:forEach var="entry" items="${pendinghistory}">
		<c:if test="${fn:length(entry.value) gt 0}">
			<spring:message code="fieldLabel.name" /> : <c:out
				value="${entry.key.name}" />
			<br />
			<table style="cellspacing: 2; cellpadding: 2; border: 1;">
				<tr class="listHeading">
					<th><spring:message code="fieldLabel.applicationId" /></th>
					<th><spring:message code="fieldLabel.name" /></th>
					<th><spring:message code="fieldLabel.startDate" /></th>
					<th><spring:message code="fieldLabel.endDate" /></th>
					<th><spring:message code="fieldLabel.leaveType" /></th>
					<th><spring:message code="title.leaveDetails" /></th>
					<th><spring:message code="fieldLabel.status" /></th>
				</tr>
				<c:forEach var="leave" items="${entry.value}">
					<tr class="listRecord">
						<td>${leave.applicationId}</td>
						<td>${leave.employeeId}</td>
						<td>${leave.fromDate}</td>
						<td>${leave.toDate}</td>
						<td>${leave.leaveType}</td>
						<td>${leave.leaveDetails}</td>
						<td>${leave.status}</td>
						<td><c:url
								value="/manager/course/display/${course.courseId}.html" var="d" />
							<a href="${d}"><spring:message code="caption.detail" /></a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</c:forEach>
</body>
</html>