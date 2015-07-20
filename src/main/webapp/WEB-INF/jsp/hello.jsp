<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
Hello ${name} (${age})

<c:set var="color" scope="session" value="green"/>
<c:if test="${age > 25}">
   <c:set var="color" scope="session" value="red"/>
</c:if>

<br/> <font color="<c:out value="${color}"/>"> ${message} </font>

<table>
<c:forEach items="${topic}" var="item">
  <tr>
    <td>${item.id}</td>
    <td>${item.topic}</td>
    <td>${item.name}</td>
  </tr>
</c:forEach>
</table>