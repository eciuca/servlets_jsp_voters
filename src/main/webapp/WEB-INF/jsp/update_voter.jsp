<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Voter</title>
</head>
<body>
   <div>
       <form method="post" action="<c:url value="/jsp/update"/>">
           <input type="hidden" name="voterIndex" value="${param.voterIndex}" />
           <label for="first-name">First Name</label>
           <input type="text" id="first-name" name="voterFirstName" value="${param.firstName}"/>
           <label for="last-name">Last Name</label>
           <input type="text" id="last-name" name="voterLastName" value="${param.lastName}" />
           <input type="submit" value="Update"/>
       </form>
   </div>
</body>
</html>