package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Bankdao;
import DTO.BankAccount;
import DTO.BankTransaction;
import DTO.Customer;

@WebServlet("/deposit")
public class Deposit extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Customer cust=(Customer)req.getSession().getAttribute("cust");
		 if(cust==null)
		 {
		 resp.getWriter().print("<h1>session expired kindly login again</h1>");
		 req.getRequestDispatcher("Login.html").include(req, resp);
		 }else{
		double amt=Double.parseDouble(req.getParameter("amount"));
		long accno=(long)req.getSession().getAttribute("Account_no");
		Bankdao dao=new Bankdao();
		BankAccount account=dao.find(accno);
		account.setAmount(account.getAmount()+amt);
		
		BankTransaction transact=new BankTransaction();
		transact.setDeposit(amt);
		transact.setWithdraw(0);
		transact.setBalance(account.getAmount());
		transact.setDateTime(LocalDateTime.now());
		
		List<BankTransaction> list=account.getTransactions();
		list.add(transact);
		
		account.setTransactions(list);
		
		
		dao.update(account);
		resp.getWriter().print("<h1>amount deposited successfully</h1>");
		req.getRequestDispatcher("AccountHome.html").include(req, resp);
		 }
		
	}
}
