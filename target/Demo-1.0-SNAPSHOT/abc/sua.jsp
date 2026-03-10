<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/2/2026
  Time: 9:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/san-pham/sua" method="post">
    <p>id: <input type="number" name="id" readonly value="${sp.id}"></p>
    <p>ma: <input type="text" name="ma" value="${sp.ma}"></p>
    <p>ten: <input type="text" name="ten" value="${sp.ten}"></p>
    <p>mo ta: <input type="text" name="moTa" value="${sp.moTa}"></p>
    <p>loai
        <select name="loai">
            <c:forEach items="${listLSP}" var="lsp">
                <option value="${lsp.id}" <c:if test="${lsp.id == sp.loaiSP.id}">selected</c:if>>
                        ${lsp.ten}
                </option>
            </c:forEach>
        </select>
    </p>
    <button type="submit">sua</button>
</form>
</body>
</html>
