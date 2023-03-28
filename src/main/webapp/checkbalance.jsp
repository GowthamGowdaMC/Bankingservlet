<%@page import="DTO.Customer"%>
<%@page import="DTO.BankAccount"%>
<%@page import="DAO.Bankdao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

body {
  font-family: Arial, sans-serif;
  background-color: #f2f2f2;
}

h1 {
  font-size: 36px;
  margin-top: 50px;
}

p {
  font-size: 24px;
  margin-top: 20px;
}

button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  border-radius: 4px;
  cursor: pointer;
  margin-top: 20px;
}

button:hover {
  background-color: #3e8e41;
}

.center {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  flex-direction: column;
}
</style>
</head>
<body>
<center class="center">
<%Customer cust=(Customer)request.getSession().getAttribute("cust");
		 if(cust==null)
		 {
		 response.getWriter().print("<h1>session expired kindly login again</h1>");
		 request.getRequestDispatcher("Login.html").include(request, response);
		 }else{%>

	<%long accno=(long)request.getSession().getAttribute("Account_no");
	Bankdao dao=new Bankdao();
	BankAccount account=dao.find(accno);
	Customer cust1=account.getCustomer();
	%>
	<h1>hello <%if(cust1.getGender().equals("male")){%> Mr.<%}else{ %>Ms.<%} %> <%=cust1.getName() %> </h1><br>
	<h1>your <%=account.getType() %>account balance is <%=account.getAmount() %></h1>
	<br><br>
	<a href="AccountHome.html"><button>Back</button></a>
</center>
<%} %>
</body>
</html>