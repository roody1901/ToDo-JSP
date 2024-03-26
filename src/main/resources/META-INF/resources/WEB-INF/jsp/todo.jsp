<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title> Add Page</title>
</head>
<body>
<h1 style="color: brown">Add new todo here!</h1>

<form:form method="post" modelAttribute="todo">
    Description:<input type="text" placeholder="Enter description" name="description" >
    <input type="submit">
</form:form>
</body>
</html>