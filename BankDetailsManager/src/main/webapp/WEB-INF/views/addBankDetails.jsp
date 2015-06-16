<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Bank Details</title>
	</head>
	<body>
		<h2>Add Bank Details</h2>
		<form:form method="POST" action="${pageContext.request.contextPath}/save.html" >
	   		<table>
			    <td><form:label path="id">ID:</form:label></td>
			    <td><form:input path="id" value="${bankDetail.id}" readonly="true"/></td>
			     
			    <tr>
			        <td><form:label path="bank">Bank Name:</form:label></td>
			        <td><form:input path="bank" value="${bankDetail.bank}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="cardNumber">Card Number:</form:label></td>
			        <td><form:input path="cardNumber" value="${bankDetail.cardNumber}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="expiryDate">ExpiryDate:</form:label></td>
			        <td><form:input path="expiryDate" value="${bankDetail.expiryDate}"/></td>
			    </tr>
			    
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
		
<c:if test="${!empty bankDetails}">  
<h2>Bank Detail List</h2>
 <table align="left" border="1">  
  <tr>  
   <th>Name</th>  
   <th>CardNumber</th>  
   <th>ExpiryDate</th> 
  </tr>  
  
  <c:forEach items="${bankDetails}" var="bankDetails">  
   <tr>  
    <td><c:out value="${bankDetails.bank}"/></td>  
    <td><c:out value="${bankDetails.cardNumber}"/></td>  
    <td><c:out value="${bankDetails.expiryDate}"/></td> 
   </tr>  
  </c:forEach>  
 </table>  
</c:if>  
	</body>
</html>