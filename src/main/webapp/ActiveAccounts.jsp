<%@page import="java.util.List"%>
<%@page import="DTO.BankAccount"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Active Accounts</title>
<style>
body {
  font-family: Arial, sans-serif;
  background-color: #f2f2f2;
  padding: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

h1 {
  color: #333333;
  text-align: center;
  margin-bottom: 20px;
}

table {
  margin: 0 auto;
  border-collapse: collapse;
  width: 80%;
}

th {
  background-color: #4CAF50;
  color: white;
  font-weight: bold;
  padding: 8px;
  text-align: center;
}

td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: center;
}

button.select-button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 8px 16px;
  text-align: center;
  text-decoration: none;
  display: block;
  font-size: 14px;
  margin: 10px auto;
  cursor: pointer;
}

a {
  text-decoration: none;
  display: inline-block;
}

a:hover {
  text-decoration: underline;
}
</style>
</head>
<body>
	<%List<BankAccount>list=(List<BankAccount>)request.getAttribute("list2"); 
	if(list.isEmpty()) {%>
		<h1>No active accounts found. Kindly wait for approval!</h1>
	<%} else {%>
	 	<h1>Select Bank Account</h1>
	 	<table>
	 		<thead>
	 			<tr>
	 				<th>Account Type</th>
	 				<th>Account Number</th>
	 				<th></th>
	 			</tr>
	 		</thead>
	 		<tbody>
	 			<% for(BankAccount account:list) { %>
	 				<tr>
	 					<td><%= account.getType() %></td>
	 					<td><%= account.getAccountno() %></td>
	 					<td><a href="setaccount?Account_no=<%= account.getAccountno() %>"><button class="select-button">Select</button></a></td>
	 				</tr>
	 			<% } %>
	 		</tbody>
	 	</table>
	<% } %>
	<a href="CustomerHome.html"><button>Back</button></a>
</body>
</html>
