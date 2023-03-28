package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Bankdao;
import DAO.Customerdao;
import DTO.BankAccount;
import DTO.Customer;

@WebServlet("/createbankaccount")
public class CreateBankAccount extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String banktype=req.getParameter("banktype");
		Customer customer=(Customer)req.getSession().getAttribute("cust");
		
		List<BankAccount> list=customer.getAccounts();
		boolean flag=true;
		for(BankAccount account:list)
		{
			if(account.getType().equals(banktype))
			{
				flag=false;
				break;
				
			}
		}
		if(flag)
		{
		BankAccount account=new BankAccount();
		account.setType(banktype);
		if(banktype.equals("saving"))
		{
			account.setAcc_limit(10000);
		}else {
			account.setAcc_limit(50000);
		}
		
		
		account.setCustomer(customer);
		Bankdao dao=new Bankdao();
		dao.save(account);
		
		List<BankAccount> list2=list;
		list2.add(account);
		customer.setAccounts(list2);
		
		Customerdao cdao=new Customerdao();
		cdao.update(customer);
		
		resp.getWriter().print("<h1>Account created successfully kindly wait for management to  approve your account</h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);
		}else {
			resp.getWriter().print("<h1>"+banktype+"Account already exists</h1>");
			req.getRequestDispatcher("CustomerHome.html").include(req, resp);
		}
	}
}
