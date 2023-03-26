<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="choco.web.model.*" %>
  <%@page import="choco.web.dao.*" %>
  <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<%
 User auth=(User)request.getSession().getAttribute("auth");
String pname=request.getParameter("pname");
String type=request.getParameter("type");
String filling=request.getParameter("filling");


int Price=Integer.parseInt(request.getParameter("price"));
int quant=Integer.parseInt(request.getParameter("quantity"));
int total=Price*quant;
 if(auth!=null){
	 request.setAttribute("auth",auth);
	 
 }%>
<title>Custom Order</title>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container ">
<div class="card text-center">
  <div class="card-header my-6">
    Your Customized Order
  </div>
  <div class="card-body">
    <h5 class="card-title"><%=request.getParameter("pname") %></h5>
    <p class="card-text"><%=request.getParameter("type") %> with <%=request.getParameter("filling") %></p>
     <p class="card-text"><%=request.getParameter("quantity") %> </p>
      <p class="card-text">Rs<%=total%> </p>
   
  </div>
  <div class="card-footer text-muted">
    <%= (new java.util.Date()).toLocaleString()%>
  </div>
</div>
</div>
</body>
</html>