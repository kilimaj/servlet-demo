package dev.kilima.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/print-result")
public class PrintResultServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		RequestDispatcher rd = req.getRequestDispatcher("./calculator.html");
		rd.include(req, resp);
		
		Object obj = req.getAttribute("result");
		if(obj != null ) {
			double result = Double.parseDouble(obj.toString());
			out.println("<p>Result of "+ req.getParameter("operator") + " operation is " + result);
			out.close();
		}
	}
}
