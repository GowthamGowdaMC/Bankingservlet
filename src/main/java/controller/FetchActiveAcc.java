package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.BankAccount;
import DTO.Customer;

@WebServlet("/fetchactiveacc")
public class FetchActiveAcc extends HttpServlet

{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer cust=(Customer)req.getSession().getAttribute("cust");
		List<BankAccount>list=cust.getAccounts();
		List<BankAccount>list2=new ArrayList<>();
		for(BankAccount account:list)
		{
			if(account.isStatus())
			{
				list2.add(account);
			}
		}
		req.setAttribute("list2", list2);
		req.getRequestDispatcher("ActiveAccounts.jsp").include(req, resp);
		
	}
}
