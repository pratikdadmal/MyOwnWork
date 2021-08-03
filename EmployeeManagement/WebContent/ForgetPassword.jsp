<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!------ Include the above in your HEAD tag ---------->
</head>


<div class="container-fluid">
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
 <!--  <form class="form-inline" action="viewEmployee">-->
    <!-- <input class="form-control mr-sm-2" type="text" placeholder="Search"> -->
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
       </button>
    
    <a href="index.jsp"><button class="btn btn-warning" type="submit">Go To Login</button></a>
   </form> 
  
</nav>
<br>
<form action="changePassword" method="post">

<h1>Change Password!</h1>

<%
String str = (String) request.getAttribute("msg");
if(str!=null)
{
%>
<b style="color:red;"><%=str%></b>
<%
}
%>
  <label>
    <p class="label-txt">USERNAME</b></p>
    <input type="text" class="input" name="username">
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  
  <label>
    <p class="label-txt">NEW PASSWORD<b style="color:red;">*</b></p>
    <input type="password" class="input" name="password" required>
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  
 <label>
    <p class="label-txt">CONFIRM PASSWORD<b style="color:red;">*</b></p>
    <input type="password" class="input" name="password" required>
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  
  <button type="submit">Change Password</button>

</form>


<style>


body {
  background: #C5E1A5 url(images/skyimg.jpg);
}
form {
  width: 40%;
  margin: 40px auto;
  background: #efefef;
  padding: 60px 120px 80px 120px;
  text-align: center;
  -webkit-box-shadow: 2px 2px 3px rgba(0,0,0,0.1);
  box-shadow: 2px 2px 3px rgba(0,0,0,0.1);
}
label {
  display: block;
  position: relative;
  margin: 40px 0px;
}
.label-txt {
  position: absolute;
  top: -1.6em;
  padding: 10px;
  font-family: sans-serif;
  font-size: .8em;
  letter-spacing: 1px;
  color: rgb(120,120,120);
  transition: ease .3s;
}
.input {
  width: 100%;
  padding: 10px;
  background: transparent;
  border: none;
  outline: none;
}

.line-box {
  position: relative;
  width: 100%;
  height: 2px;
  background: #BCBCBC;
}

.line {
  position: absolute;
  width: 0%;
  height: 2px;
  top: 0px;
  left: 50%;
  transform: translateX(-50%);
  background: #8BC34A;
  transition: ease .6s;
}

.input:focus + .line-box .line {
  width: 100%;
}

.label-active {
  top: -3em;
}

button {
  display: inline-block;
  padding: 12px 24px;
  background: rgb(220,220,220);
  font-weight: bold;
  color: rgb(120,120,120);
  border: none;
  outline: none;
  border-radius: 3px;
  cursor: pointer;
  transition: ease .3s;
}

button:hover {
  background: #8BC34A;
  color: #ffffff;
}

</style>