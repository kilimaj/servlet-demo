package dev.kilima.servletdemo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/simple-calculator")
public class SimpleCalculatorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String input1 = req.getParameter("num1");
		String input2 = req.getParameter("num2");
		String op = req.getParameter("operator");
		
		if(input1==null || input2==null || op==null) {
			resp.sendRedirect("./calculator.html");
			return;
		}
		
		try {
			double d1 = Double.parseDouble(input1);
			double d2 = Double.parseDouble(input2);
			
			double result = 0;
			
			switch(op) {
			case "Add": result = d1 + d2; break;
			case "Subtract": result = d1 - d2; break;
			case "Multiply": result = d1 * d2; break;
			case "Divide": result = d1 / d2; break;
			default:
				throw new Exception("Invalid operator");
			}
			// store request
			req.setAttribute("result", result);
			
			RequestDispatcher rd = req.getRequestDispatcher("print-result");
			rd.forward(req, resp);
		} catch (Exception e) {
			resp.sendRedirect("./calculator.html");
		}
	}

}
