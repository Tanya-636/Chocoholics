<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="choco.web.model.*" %>
  <%@page import="choco.web.dao.*" %>
  <%@page import="java.util.*" %>
  
 <%
 User auth=(User)request.getSession().getAttribute("auth");
 if(auth!=null){
	 request.setAttribute("auth",auth);
	 
 }
 ProductDAO pd=new ProductDAO();
 List<Product> products=pd.getAllProducts();
 ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
 if (cart_list != null) {
 	request.setAttribute("cart_list", cart_list);
 }
 %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
 *{
    padding:0;
    margin:0;
    box-sizing:border-box;
    }
    body{
    background:#FBFFB1;
    }
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>
<%@include file="navbar.jsp" %>

<div class="container">
<div class="card-header my-3">
All Products
</div>

<div class="row">
<%
if(!products.isEmpty()){
	for(Product p:products){
		

%>
<div class="col-md-3">
<div class="card w-100" style="width: 18rem;">
  <img class="card-img-top" src="images/<%=p.getImage()%>" alt="Card image cap">

  <div class="card-body">
    <h5 class="card-title"><%=p.getName() %></h5>
    <h6 class="price">Price:<%=p.getPrice() %></h6>
    <h6 class="category"><%=p.getType()+" " %>with <%=p.getFilling() %></h6>
   <div class="mt-3 d-flex justify-content-between">
   <a class="btn btn-primary" href="add-to-cart?id=<%=p.getId()%>"> Add to Cart</a>
   
   <a  class="btn btn-primary" href="order-now?quantity=1&id=<%=p.getId()%>"> Buy Now</a>
   </div>
    
  </div>
</div>
</div>
<%
}
}%>
</div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>