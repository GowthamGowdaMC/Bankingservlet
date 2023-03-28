<%@page import="DTO.Customer"%>
<%@page import="DTO.BankTransaction"%>
<%@page import="java.util.List"%>
<%@page import="DTO.BankAccount"%>
<%@page import="DAO.Bankdao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Transactions</title>

<style>


table {
  font-family: Arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

th {
  background-color: #dddddd;
}

.back-button {
  display: inline-block;
  padding: 10px 20px;
  background-color: #4CAF50;
  color: white;
  text-align: center;
  text-decoration: none;
  font-size: 16px;
  margin-top: 20px;
  border-radius: 5px;
}

.back-button:hover {
  background-color: #3e8e41;
}
h1 {
  font-size: 24px;
  color: blue;
  justify-content: center;
}

</style>

</head>
<body>
<%Customer cust=(Customer)request.getSession().getAttribute("cust");
     if(cust==null)
     {
     response.getWriter().print("<h1>session expired kindly login again</h1>");
     request.getRequestDispatcher("Login.html").include(request, response);
     }else{%>

  <%long accno=(long)request.getSession().getAttribute("Account_no");
  Bankdao dao=new Bankdao();
  BankAccount account=dao.find(accno);
  List<BankTransaction>list=account.getTransactions();
  
  %>
  <h1>Account_Number: <%=accno %></h1>
  <h1>Account_Name: <%=account.getCustomer().getName() %></h1>
  <h1>Account_Type: <%=account.getType() %></h1><br>
  
  <table>
    <tr>
      <th>Transaction ID</th>
      <th>Deposit</th>
      <th>Withdraw</th>
      <th>Balance</th>
      <th>Date &amp; Time</th>
    </tr>
    <%for(BankTransaction transaction:list){ %>
    <tr>
      <td><%=transaction.getId() %></td>
      <td><%=transaction.getDeposit()%></td>
      <td><%=transaction.getWithdraw() %></td>
      <td><%=transaction.getBalance() %></td>
      <td><%=transaction.getDateTime() %></td>
    </tr>
    <%} %>
  </table>

  <a class="back-button" href="AccountHome.html">Back</a>

<%} %>

</body>
</html>
