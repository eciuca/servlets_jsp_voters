<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Voter</title>
</head>
<body>
   <div>
       <form method="post" action="<c:url value="/jsp/update"/>">
           <input type="hidden" name="voterIndex" value="${param.voterIndex}" />
           <input type="text" name="voterFirstName"  value="${param.firstName}"/>
           <input type="text" name="voterLastName"  value="${param.lastName}" />
           <input type="submit" value="Update"/>
       </form>
   </div>
</body>
</html>