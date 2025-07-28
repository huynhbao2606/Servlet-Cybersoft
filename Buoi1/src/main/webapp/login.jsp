<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@5.3.7/dist/sketchy/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <jsp:include page="includes/nav.jsp" />
</div>
<div class="container">
    <div class="d-flex flex-column justify-content-center align-items-center mt-5">
        <form action="login" method="GET" class="w-25">
            <h1 class="text-center mb-4">Login</h1>
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email">
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>

            <label for="exampleInputPassword1" class="form-label mt-3">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" autocomplete="off" name="password">

            <button type="submit" class="btn btn-primary mt-4 w-100">Submit</button>
        </form>

        <%
            request.setAttribute("message", request.getAttribute("alertMessage"));
        %>

        <c:if test="${not empty message}">
            <div class="alert alert-dismissible alert-success w-25 mt-3 text-center">
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    ${message}
            </div>
        </c:if>



    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>