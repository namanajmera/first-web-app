<%@ include file="Common/header.jspf" %>
<%@ include file="Common/navigation.jspf" %>
<div class="container">
    <h1>Your Todos</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done?</th>
            <th>Action To Delete</th>
            <th>Action To Update</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
                <td><a href="delete-todo?id=${todo.id}" class="btn bg-warning text-black">Delete</a></td>
                <td><a href="update-todo?id=${todo.id}" class="btn bg-primary text-white">Update</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="add-todo" class="btn bg-success text-white">Add Todo</a>

</div>
<%@ include file="Common/footer.jspf" %>