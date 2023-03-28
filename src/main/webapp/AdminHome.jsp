<%@page import="DTO.BankAccount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Admin</title>
<script src="https://kit.fontawesome.com/d803ed20a9.js" crossorigin="anonymous"></script>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

th {
  background-color: #4CAF50;
  color: white;
}
tr{
 border:1px solid black;
}

.bulb-icon {
  font-size: 1.25rem;
}

.status-true {
  color: green;
  text-shadow: 0 0 5px rgba(0,255,0,0.5);
}

.status-false {
	
  color: red;
   text-shadow: 0 0 5px rgba(0,255,0,0.5);
}
button{
color:white;
background-color: green;
border-radius: 10px;
border:none;
height: 25px;
cursor: pointer;
}
button[type="submit"]{
position: absolute;
top:10px;
right:10px;
width:75px;
height: 35px;
}
</style>
</head>
<body>
<center>
<% List<BankAccount> list=(List<BankAccount>)request.getAttribute("list");%>
    <table>
        <tr>
          <th>Account Number</th>
          <th>Account type</th>
          <th>Customer Name</th>
          <th>Customer ID</th>
          <th>Status</th>
          <th>Current Status</th>
          <th>Change Status</th>
         </tr>
         <%for(BankAccount account:list){ %>
          <tr>
          <td><%= account.getAccountno() %></td>
          <td><%= account.getType() %></td>
          <td><%= account.getCustomer().getName() %></td>
          <td><%= account.getCustomer().getCustomer_id() %></td>
          <td>
            <%if(account.isStatus()){ %>
              <i class="fas fa-lightbulb status-true bulb-icon"></i>
            <%} else { %>
              <i class="far fa-lightbulb status-false bulb-icon"></i>
            <%}%>
          </td>
          <td><%= account.isStatus() %></td>
          <td><a href="changestatus?accountno=<%=account.getAccountno()%>"><button>Change Status</button></a></td>
         </tr>
         <%} %>
    </table>
    <a href="HomePage.html"><button type="submit">Logout</button></a>
    </center>
</body>
</html>