<html>
<head>
    <title>Authorization</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/Authorization" autocomplete="off">
    <p>Name : </p>
    <input name="name" type="text" size="40">
    <p>Password : </p>
    <input name="password" type="password" size="40">
    <br>
    <button type="submit">Ok</button><br>
    <a href="${pageContext.request.contextPath}/Menu">Main page</a><br>
</form>
</body>
</html>