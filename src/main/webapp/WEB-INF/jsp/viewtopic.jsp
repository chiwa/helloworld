<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

TOPIC
<table border="1">
   <tr>
    <td>${topic.topic} &nbsp; [${topic.name}]</td>
    </tr>
    <tr>
    <td>${topic.content}</td>
  </tr>
</table>

<hr>
comment
<hr>

<c:forEach items="${reply}" var="reply">
<table border="1">
  <tr>
    <td>${reply.comment} : [${reply.name}]</td>
  </tr>
</table>
<br/>
</c:forEach>



<hr>
<form method="post" action="reply.html?id=${topic.id}">
<table>
  <tr>
    <td>name</td>
    <td><input type="text" name="name" id="name" ></td>
  </tr>
    <tr>
          <td>content</td>
          <td><textarea name="comment" id="content" cols="100" rows="5" ></textarea></td>
        </tr>
        <tr>
          <td></td>
          <td><input type="submit" value="REPLY" ></td>
        </tr>
</table>
</form>
