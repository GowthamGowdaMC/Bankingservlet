package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Bankdao;
import DTO.BankAccount;

@WebServlet("/setaccount")
public class SetAccount extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long accno=Long.parseLong(req.getParameter("Account_no"));
		
		req.getSession().setAttribute("Account_no", accno);
		req.getRequestDispatcher("AccountHome.html").include(req, resp);
	}
}
