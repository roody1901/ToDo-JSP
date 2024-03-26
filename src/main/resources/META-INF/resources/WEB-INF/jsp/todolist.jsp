<%--<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
--%>
<html>
<head>
    <title> Todo Page</title>
</head>
<body>
<h1>CHeck your all todo items</h1>
${todoList}

<a href="add-todo" >Add Todo</a>
<div>
    <table>
        <thead>
            <td>Id</td>
            <td>Username</td>
            <td>description</td>
            <td>Date</td>
            <td>Done</td>
        </thead>
        <tbody>
        <%--<c:forEach items="${todoList}" var="todos">
            <tr>
                <td>${todos.id}</td>
                <td>${todos.userName}</td>
                <td>${todos.description}</td>
                <td>${todos.targetDate}</td>
                <td>${todos.done}</td>
            </tr>
        </c:forEach>--%>
        </tbody>
    </table>
</div>
<a href="delete-todo?id=${todo.id}">Delete</a>
<a href="update-todo?id=${todo.id}">Update</a>
</body>
</html>