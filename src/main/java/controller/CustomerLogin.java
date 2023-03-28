package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Customerdao;
import DTO.Customer;

@WebServlet("/customerlogin")
public class CustomerLogin extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int custid=Integer.parseInt(req.getParameter("userid"));
		String password=req.getParameter("password");
		
		Customerdao dao=new Customerdao();
		Customer cust=dao.login(custid);
		
		if(cust==null)
		{
			resp.getWriter().print("<html><head><body><center><h1>Invalid customer_id</h1></center></body></head></html>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}else if(cust.getPassword().equals(password))
		{
			req.getSession().setAttribute("cust", cust);
			resp.getWriter().print("<html><head><body><center><h1>Login success welcome!! "+cust.getName()+"</h1></center></body></head></html>");
			req.getRequestDispatcher("CustomerHome.html").include(req, resp);
		}else {
			resp.getWriter().print("<html><head><body><center><h1>oops!! Invalid password</h1></center></body></head></html>");

			req.getRequestDispatcher("Login.html").include(req, resp);

		}
	}
}
