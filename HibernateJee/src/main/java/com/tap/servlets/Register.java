package com.tap.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoimpl.StudentDAOImpl;
import com.tap.entity.Student;


@WebServlet("/register")
public class Register extends HttpServlet
{
	int i;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String password = req.getParameter("password");
		String cpassword = req.getParameter("cpassword");
		
		if(password.equals(cpassword))
		{
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String mobile = req.getParameter("mobile");
			
			Student student = new Student(name, email, mobile, password);
			
			StudentDAOImpl sdaoi = new StudentDAOImpl();
			
			i = sdaoi.add(student);
			
			if(i != 0)
			{
				resp.sendRedirect("sucess.html");
			}
			else
			{
				resp.sendRedirect("failureregister.html");
			}
		}
		else
		{
			resp.sendRedirect("failure.html");
		}

	}
	

}
