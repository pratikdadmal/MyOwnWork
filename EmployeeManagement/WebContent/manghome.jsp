<%@page import="com.pk.entity.ViewEmployee"%>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <title>Employee Dashboard</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <!--  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">-->
  
</head>
<body>

<div class="container-fluid">

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">



 <!--  <form class="form-inline" action="viewEmployee">-->
    <!-- <input class="form-control mr-sm-2" type="text" placeholder="Search"> -->
    
     <a class="navbar-brand" href="getProfile?id=<%=session.getAttribute("id")%>"><%=session.getAttribute("username")%></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
       </button>
    
    <a href="viewEmployee"><button class="btn btn-success" type="submit">ViewEmployee</button></a>&nbsp;&nbsp;
    
    <a href="addEmployee.jsp"><button class="btn btn-success" type="submit">AddEmployee</button></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    
    <a href="LogoutServlet?logout=<%=session.getAttribute("username")%>"><button class="btn btn-warning" type="submit">Logout</button></a>
   </form> 
  
</nav>
<br>

<div class="container">
  <div class="row">
  <div class="col-12 col-sm-12 col-md-12 col-lg-12">
  <h3>Manager Dashboard</h3>
  <p>Employee Details</p> 
  
  <!-- Delete Message -->
<%--   <%
    String str = (String)request.getAttribute("deleteMsg");
     if(str!=null)
     {
 
  %>
  
   <b style="color:red;"><%=str%></b>
         <%
         }
         %> --%>
  
 <table border="0px" class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">UserName</th>
      <th scope="col">Password</th>
      <th scope="col">Email</th>
      <th scope="col">Role</th>
      <th scope="col">Action Status</th>
      <th scope="col">Task</th>
      <th scope="col">Manager Name</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
 
 <c:forEach items="${employees}" var="emp">
 
 <tr>
   <td><c:out value="${emp.id}"></c:out></td>
   <td><c:out value="${emp.username}"></c:out></td>
   <td><c:out value="${emp.password}"></c:out></td>
   <td><c:out value="${emp.email}"></c:out></td>
   <td><c:out value="${emp.role}"></c:out></td>
   <td><c:out value="${emp.active_status}"></c:out></td>
   <td><c:out value="${emp.task}"></c:out></td>
   <td><c:out value="${emp.manager_name}"></c:out></td>
   
   <td><a href="DeleteServelet?id=${emp.id}"><button class="btn btn-danger" type="submit">Delete</button></a>
   <td><a href="UpdatedEmployee.jsp?id=${emp.id}"><button class="btn btn-primary" type="submit">Update</button></a> 
 </tr>
 
 </c:forEach>
 
  </table>
 </form>
</div>
</div>
</div>

</div>

</body>
</html>
