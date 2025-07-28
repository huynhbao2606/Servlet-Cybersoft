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
    <div class="container mt-5">
        <h1 class="text-center mb-4 bold">QUẢN LÝ SẢN PHẨM</h1>

        <form action="product" method="POST" class="mb-4">
            <div class="mb-3">
                <label for="name" class="form-label">Tên sản phẩm</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Nhập tên sản phẩm" required>
            </div>
            <div class="mb-3">
                <label for="quantity" class="form-label">Số lượng:</label>
                <input type="number" class="form-control" id="quantity" name="quantity" placeholder="Nhập số lượng" required>
            </div>
            <div class="mb-3">
                <label for="price" class="form-label">Giá bán:</label>
                <input type="number" class="form-control" id="price" name="price" placeholder="Nhập giá bán" required>
            </div>
            <button type="submit" class="btn btn-primary">Lưu lại</button>
        </form>

        <table class="table table-hover">
            <thead class="table-dark text-center">
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Tên Sản Phẩm</th>
                <th scope="col">Số Lượng</th>
                <th scope="col">Giá Bán</th>
            </tr>
            </thead>
            <tbody class="table-light">
            <c:forEach var="p" items="${productList}" varStatus="loop">
                <tr class="text-center">
                    <td>${loop.index + 1}</td>
                    <td>${p.name}</td>
                    <td>${p.quantity}</td>
                    <td>${p.price}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
