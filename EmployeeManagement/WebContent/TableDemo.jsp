<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
</head>
<body>

<table class="table" id="demo">
  <thead>
    <tr>
      <th scope="col">id</th>
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
      <tr>
      <td>1</td>
      <td>pratik</td>
      <td>praitk@123</td>
      <td>pratik@gmail.com</td>
      <td>developer</td>
      <td>1</td>
      <td>coding</td>
      <td>jbk</td>
      <td><a href="DeleteServelet?id=${emp.id}"><button class="btn btn-red" type="submit">Delete</button></a>
      <%-- <td><a href="DeleteServelet?id=${emp.id}"><button class="btn btn-red" type="submit">Update</button></a> --%>
      
      </tr>
    
  </tbody>
 </table>
 
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">

$(document).ready( function () {
    $('#demo').DataTable();
} );

</script>

</body>
</html>