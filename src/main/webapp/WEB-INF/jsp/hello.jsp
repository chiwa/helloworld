<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='cx'%>
Hello ${name} (${age})

<cx:set var="color" scope="session" value="green"/>
<cx:if test="${age > 25}">
   <cx:set var="color" scope="session" value="red"/>
</cx:if>

<br/> <font color="<cx:out value="${color}"/>"> ${message} </font>