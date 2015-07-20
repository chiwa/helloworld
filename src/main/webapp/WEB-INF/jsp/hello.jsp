<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<table>
<c:forEach items="${topic}" var="item">
  <tr>
    <td>${item.id}</td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="viewtopic.html?id=${item.id}" target="_blank">${item.topic}</a></td>
    <td>[${item.name}]</td>
  </tr>
</c:forEach>
</table>
<br/><br/>

<form method="post" action="submittopic.html">
<table>
  <tr>
    <td>name</td>
    <td><input type="text" name="name" id="name" ></td>
  </tr>
   <tr>
      <td>topic</td>
      <td><input type="text" name="topic" id="topic" ></td>
    </tr>
    <tr>
          <td>content</td>
          <td><textarea name="content" id="content" cols="100" rows="5" ></textarea></td>
        </tr>
        <tr>
          <td></td>
          <td><input type="submit" value="POST" ></td>
        </tr>
</table>
</form>