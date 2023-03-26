<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
 <%@page import="choco.web.model.*" %>
  <%@page import="choco.web.dao.*" %>
  <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<%
 User auth=(User)request.getSession().getAttribute("auth");
 if(auth!=null){
	 request.setAttribute("auth",auth);
	 
 }%>
<body>
<%@include file="navbar.jsp" %>
<div class="container-fluid">
<div class="row p-5">
<div class="col-md-4 offset-md-4">
<div card="card-body">
<div class="text-center">
<h5> Add Product</h5>
</div>

<form action="CustomOrder" >
  <div class="form-group">
    <label > Name for Chocolate</label>
    <input type="text" class="form-control" placeholder="Product Name" name="pname">
  </div>
    <label >Chocolate Type:</label>
  <div class="input-group mb-3">
 
  <div class="input-group-prepend">
    <label class="input-group-text" >Type</label>
  </div>
  
  <select class="custom-select" id="inputGroupSelect01" name="type">
    
    <option value="White Chocolate">White Chocolate</option>
    <option value="Dark Chocolate">Dark Chocolate</option>
    <option value="Milk Chocolate">Milk Chocolate</option>
  </select>
</div>
  <label>Filling</label>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <label class="input-group-text" for="inputGroupSelect01" >Filling</label>
  </div>
  <select class="custom-select" id="inputGroupSelect01" name="filling">

    <option value="Caramel">Caramel</option>
    <option value="Coconut">Coconut</option>
    <option value="Roasted Peanuts">Roasted Peanuts</option>
    <option value="Dry Fruits">Dry fruits</option>
    <option value="Candy Filling">Candy filling</option>
    <option value="Fruit Filling">Fruit filling</option>
    <option value="Jelly Filling">Jelly filling</option>
 
  </select>
</div>

 <label >Price:</label>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <label class="input-group-text" for="inputGroupSelect01" >Price by size</label>
  </div>
  <select class="custom-select" id="inputGroupSelect01" name="price">

    <option value="100">50gm-Rs100</option>
    <option value="200">100gm-Rs200</option>
    <option value="650">Celebration box(500gm)-650</option>
   
 
  </select>
  
</div>
<div class="form-group">
    <label > Quantity</label>
    <input type="number" class="form-control" placeholder="Quantity" name="quantity">
  </div>

  <button type="submit" class="btn btn-primary">Submit</button>
</form>

</div>
</div>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>