<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>JSP - Product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@5.3.7/dist/sketchy/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <jsp:include page="includes/nav.jsp" />
</div>
<div class="container">
    <h1 class="text-center mb-4">Product</h1>
    <table class="table table-hover">
        <thead class="table-dark">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="products" items="${products}">
                <tr>
                    <td>${products.id}</td>
                    <td>${products.name}</td>
                    <td>${products.price}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
