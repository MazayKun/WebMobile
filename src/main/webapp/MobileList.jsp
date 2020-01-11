<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>model</th>
        <th>price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="mobile" items="${mobiles}">
        <tr>
            <td scope="row">${mobile.id}</td>
            <td>${mobile.model}</td>
            <td>${mobile.price}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>
<a href="${pageContext.request.contextPath}/Menu">Main page</a>