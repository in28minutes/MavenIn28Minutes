package com.in28minutes.servletjsp.web.servlet;

import static com.in28minutes.servletjsp.web.util.Views.LEARN_MORE;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LearnMoreServlet", urlPatterns = "/learnmore")
public class LearnMoreServlet extends HttpServlet {

	private static final long serialVersionUID = 2725907234236038003L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("aboutTabStyle", "active");
		request.getRequestDispatcher(LEARN_MORE).forward(request, response);
	}

}
