<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/2/2026
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/san-pham/tim-kiem">
    <p>ten: <input type="text" name="ten"></p>
    <button type="submit">tim kiem</button>
</form>

<form action="/san-pham/add" method="post">
<%--    <p>id: <input type="text" name="id"></p>--%>
    <p>ma: <input type="text" name="ma"></p>
    <p>ten: <input type="text" name="ten"></p>
    <p>mo ta: <input type="text" name="moTa"></p>
    <p>loai
        <select name="loai">
            <c:forEach items="${listLSP}" var="lsp">
                <option value="${lsp.id}">
                        ${lsp.ten}
                </option>
            </c:forEach>
        </select>
    </p>
    <button type="submit">add</button>
</form>

<table>
    <thead>
    <tr>
        <td>id</td>
        <td>ma</td>
        <td>ten</td>
        <td>mo ta</td>
        <td>ma loai</td>
        <td>ten loai</td>
        <td>hanh dong</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listSP}" var="sp">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.ma}</td>
            <td>${sp.ten}</td>
            <td>${sp.moTa}</td>
            <td>${sp.loaiSP.ma}</td>
            <td>${sp.loaiSP.ten}</td>
            <td>
                <a href="/san-pham/detail?id=${sp.id}">detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
