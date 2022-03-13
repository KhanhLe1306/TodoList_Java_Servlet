<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>

</head>
<body>

<a href="/ServletDemo/addTodo.jsp"><button>Add Todo</button></a>

<ol>
	
		<c:forEach var="todo" items="${todos}"> 
		
			<li> ${todo.title} : ${todo.done} </li> 
		
		
		</c:forEach>
</ol>
</body>

</html>