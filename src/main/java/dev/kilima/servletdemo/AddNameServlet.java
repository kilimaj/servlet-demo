package dev.kilima.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add-name")
public class AddNameServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String friendName = req.getParameter("friend_name");

		if (friendName == null || friendName.trim().length() == 0) {
			resp.sendRedirect("./add-name.html");
			return;
		}

		HttpSession session = req.getSession();
		List<String> names = (List<String>) session.getAttribute("nameList");
		if (names == null) {
			names = new ArrayList<String>();
			names.add(friendName);
			session.setAttribute("nameList", names);
		}

		names.add(friendName);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		req.getRequestDispatcher("add-name.html").include(req, resp);
		out.println("<h3>" + friendName + " added to your friend list.</h3>");
		out.close();

	}

}
