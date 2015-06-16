<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<title>Bank Details</title>  
</head>  
<body>  
<h1>List of Bank Details</h1>  
<h3><a href="add.html">Add Bank Details</a></h3>  
  
<c:if test="${!empty bankDetails}">  
 <table align="left" border="1">  
  <tr>  
   <th>Name</th>  
   <th>Card Number</th>  
   <th>Expiry Date</th> 
  </tr>  
  
  <c:forEach items="${bankDetails}" var="bankDetails">  
   <tr>  
    <td><c:out value="${bankDetails.bank}"/>, <c:out value="${bankDetails.bank}"/></td>  
    <td><c:out value="${bankDetails.cardNumber}"/></td>  
    <td><c:out value="${bankDetails.expiryDate}"/></td> 
    <td align="center"><a href="edit.html?id=${bankDetails.id}">Edit</a></td> 
   </tr>  
  </c:forEach>  
 </table>  
</c:if>  
</body>  
</html> 