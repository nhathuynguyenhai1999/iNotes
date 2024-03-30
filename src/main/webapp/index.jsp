<%@ page import="com.cg.inotes.Model.Note" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
  <title>Danh sách Ghi chú</title>
</head>
<body>
<h1>Danh sách Ghi chú</h1>
<a href="notes?action=add">Thêm Ghi chú mới</a>
<table>
  <tr>
    <th>ID</th>
    <th>Tiêu đề</th>
    <th>Nội dung</th>
    <th>Loại</th>
    <th>Thao tác</th>
  </tr>
  <% Note[] notes = new com.cg.inotes.Model.Note[0];
    for (Note note : notes) { %>
  <tr>
    <td><%= note.getId() %></td>
    <td><%= note.getTitle() %></td>
    <td><%= note.getContent() %></td>
    <td><%= note.getTypeId() %></td>
    <td>
      <a href="notes?action=delete&id=<%= note.getId() %>">Xóa</a>
    </td>
  </tr>
  <% } %>
</table>
</body>
</html>