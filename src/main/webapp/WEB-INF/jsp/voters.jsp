<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Voters List</title>
</head>
<body>
<h1>Voters cu JSP (JavaServer Pages) si EL (Expression Language)</h1>
<h2>Total voters: ${voters.size()}</h2>

<%@include file="choose_view_type.jspf" %>

<c:choose>
    <c:when test="${cookie.viewType.value == 'scriptlet'}">
        <%@include file="voters_unordered_list.jspf" %>
    </c:when>

    <c:when test="${cookie.viewType.value == 'el'}">
        <%@include file="voters_ordered_list.jspf" %>
    </c:when>
</c:choose>

<%@include file="add_voter_form.jspf" %>

</body>
</html>