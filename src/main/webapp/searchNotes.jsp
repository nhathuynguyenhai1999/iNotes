<%@ page import="com.cg.inotes.Model.Note" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30/03/2024
  Time: 5:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Kết quả tìm kiếm Ghi chú</title>
</head>
<body>
<h1>Kết quả tìm kiếm Ghi chú</h1>

<a href="notes">Quay lại</a>

<table>
    <tr>
        <th>ID</th>
        <th>Tiêu đề</th>
        <th>Nội dung</th>
        <th>Loại</th>
    </tr>

    <% Note[] notes = new com.cg.inotes.Model.Note[0];
        for (Note note : notes) { %>
    <tr>
        <td><%= note.getId() %></td>
        <td><%= note.getTitle() %></td>
        <td><%= note.getContent() %></td>
        <td><%= note.getTypeId() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>