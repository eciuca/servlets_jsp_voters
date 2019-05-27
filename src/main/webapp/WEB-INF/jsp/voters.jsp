<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.sda.grupa5.servlet.votare.model.Person" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Voters List</title>
</head>
<body>
    <h1>Voters cu JSP (JavaServer Pages) si EL (Expression Language): ${voters.size()}</h1>
    <ul>
        <h2>Scriptlet</h2>
        <% for (Person voter : ((List<Person>) request.getAttribute("voters"))) {%>
            <li><%=voter.getFirstName()%> <%=voter.getLastName()%></li>
        <% } %>

        <h2>Expression Language</h2>
        <c:forEach items="${voters}" var="voter" varStatus="iterator">
            <li>
                <span>${voter.firstName} ${voter.lastName}</span>

                <form method="post" action="<c:url value="/jsp/delete"/>">
                    <input type="hidden" name="voterLastName" value="${voter.lastName}">
                    <input type="submit" value="Delete">
                </form>

                <form method="get" action="<c:url value="/jsp/update"/>">
                    <input type="hidden" name="voterIndex" value="${iterator.index}"/>
                    <input type="hidden" name="firstName" value="${voter.firstName}"/>
                    <input type="hidden" name="lastName" value="${voter.lastName}"/>
                    <input type="submit" value="Edit">
                </form>
            </li>
        </c:forEach>
    </ul>

    <h2>Add voter</h2>
    <div>
        <form method="post" action="<c:url value="/jsp"/>">
            <input type="text" id="first-name" name="firstName" />
            <input type="text" id="last-name" name="lastName" />
            <input type="submit" value="Add" />
        </form>
    </div>

</body>
</html>