<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Indy Winners</title>
</head>
<body>
    <h2>Indy Winners</h2>
    <table border="1">
        <tr>
            <th>Year</th>
            <th>Winner</th>
            <th>Car</th>
        </tr>
        <c:forEach var="winner" items="${winners}">
            <tr>
                <td>${winner.year}</td>
                <td>${winner.winnerName}</td>
                <td>${winner.car}</td>
            </tr>
        </c:forEach>
    </table>

    <c:if test="${currentPage > 1}">
        <a href="?page=${currentPage - 1}">Previous</a>
    </c:if>
    <c:if test="${currentPage < totalPages}">
        <a href="?page=${currentPage + 1}">Next</a>
    </c:if>
</body>
</html>
