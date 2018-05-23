<%@ page import="controller.MembersController" %>
<%@ page import="controller.MemberRepository" %><%--
  Created by IntelliJ IDEA.
  User: Dell i5
  Date: 16/05/2016
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Family Management</title>
</head>
<body>
<%
  MemberRepository repo = new MemberRepository();
  MembersController ctrl = new MembersController(repo);
  for (String record : ctrl.getMemberEvolution("Alex")) { %>
<tr>
  <td><%=record%></td>
</tr>
<% }
%>
</body>
</html>
