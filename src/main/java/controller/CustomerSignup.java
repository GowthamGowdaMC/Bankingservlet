package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Customerdao;
import DTO.Customer;

@WebServlet("/customersignup")
public class CustomerSignup extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customerdao dao=new Customerdao();
		String name=req.getParameter("name");
		String mob=req.getParameter("mobile");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		
		String dob=req.getParameter("dob");
		
		Date date=Date.valueOf(dob);
		int age=Period.between(date.toLocalDate(),LocalDate.now()).getYears();
		if(age<18)
		{
			resp.getWriter().print("<html><body><center><h1>you have to be 18+ to create an bank account</h1></center></body></html>");
			req.getRequestDispatcher("Signup.html").include(req, resp);
		}else 
			if(dao.check(mob).isEmpty()&&dao.check(email).isEmpty())
			{
			Customer cust=new Customer();
			cust.setName(name);
			cust.setPassword(password);
			cust.setGender(gender);
			cust.setDob(date);
			cust.setMobile(Long.parseLong(mob));
			cust.setEmail(email);
			
			dao.save(cust);
			
			resp.getWriter().print("<html><body><center><h1>account created successfully</h1></center></body></html>");
			if(cust.getGender().endsWith("female"))
			{
				resp.getWriter().print("<html><body><center><h1>hello ma'am </h1></center></body></html>");
				resp.getWriter().print("<html><body><center><h1>your customer_id is"+cust.getCustomer_id()+"</h1></center></body></html>");
				req.getRequestDispatcher("HomePage.html").include(req, resp);
			}else {
				resp.getWriter().print("<html><body><center><h1>hello sir </h1></center></body></html>");
				resp.getWriter().print("<html><body><center><h1>your customer_id is"+cust.getCustomer_id()+"</h1></center></body></html>");
				req.getRequestDispatcher("HomePage.html").include(req, resp);
			}
			
			
			}else {
			   resp.getWriter().print("<h1>email or phone already exists</h1>");
			   req.getRequestDispatcher("Signup.html").include(req, resp);
		}
		
	}
}
