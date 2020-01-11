<html>
<head>
    <title>Add new mobile</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/AddMobile" autocomplete="off">
        <p>Model : </p>
        <input name="model" type="text" size="40">
        <p>Price : </p>
        <input name="price" type="number" size="40">
        <br>
        <button type="submit">Add</button>
    </form>
</body>
</html>