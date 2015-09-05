package com.in28minutes.servletjsp.web.filter;

import static com.in28minutes.servletjsp.web.util.Views.LOGIN_PAGE;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.in28minutes.domain.User;
import com.in28minutes.web.common.util.TodoListUtils;

@WebFilter(filterName = "SessionCheckFilter", urlPatterns = { "/user/*", "/todos/*" })
public class SessionCheckFilter implements Filter {

	public void init(FilterConfig config) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException, IOException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		User user = (User) session.getAttribute(TodoListUtils.SESSION_USER);

		if (user != null) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
		}

	}

	public void destroy() {
	}

}
