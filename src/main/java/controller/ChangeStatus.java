package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Bankdao;
import DTO.BankAccount;

@WebServlet("/changestatus")
public class ChangeStatus extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		long accno=Long.parseLong(req.getParameter("accountno"));
		
		Bankdao dao=new Bankdao();
		BankAccount account=dao.find(accno);
		
		if(account.isStatus())
		{
			account.setStatus(false);
		}else {
			account.setStatus(true);
		}
		dao.update(account);
		resp.getWriter().print("<h1>Status updated successfully</h1>");
		req.setAttribute("list",dao.fetchAll());
		
		req.getRequestDispatcher("AdminHome.jsp").include(req, resp);
		
		}
}
