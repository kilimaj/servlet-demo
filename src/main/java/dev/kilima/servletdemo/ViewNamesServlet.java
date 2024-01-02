package dev.kilima.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/view-names")
public class ViewNamesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		req.getRequestDispatcher("add-name.html").include(req, resp);

		HttpSession session = req.getSession();
		List<String> names = (List<String>) session.getAttribute("nameList");

		if (names == null || names.size() == 0) {
			out.println("<h3> There are no names in your friendlist </h3>");
		} else {
			out.println("<h3>These are youre friends:</h3>");
			out.println("<ul>");
			for (String name : names) {
				out.println("<li>" + name + "</li>");
			}
			out.println("</ul>");
		}
		ServletContext context = getServletContext();
		List<String> contextNames = (List<String>) context.getAttribute("nameList");
		if (contextNames != null) {
			out.println("<h3> Friend names added by all users: </h3>");
			out.println("<ul>");
			for (String name : contextNames) {
				out.println("<li>" + name + "</li>");
			}
			out.println("</ul>");
		}
		out.close();
	}

}
