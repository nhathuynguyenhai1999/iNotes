<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30/03/2024
  Time: 5:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thêm Ghi chú mới</title>
</head>
<body>
<h1>Thêm Ghi chú mới</h1>
<form action="notes" method="post">
    <input type="hidden" name="action" value="add">
    <label for="title">Tiêu đề:</label>
    <input type="text" name="title" id="title" required><br>
    <label for="content">Nội dung:</label>
    <textarea name="content" id="content" rows="5" required></textarea><br>
    <label for="typeId">Loại:</label>
    <select name="typeId" id="typeId">
        <option value="1">Personal</option>
        <option value="2">Work</option>
        <option value="3">Study</option>
    </select><br>
    <input type="submit" value="Lưu">
</form>
</body>
</html>