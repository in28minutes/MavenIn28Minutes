package com.in28minutes.servletjsp.web.servlet.todo;

import static com.in28minutes.servletjsp.web.util.Views.ERROR_PAGE;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.in28minutes.domain.TodoItem;
import com.in28minutes.service.api.TodoService;

@WebServlet(name = "DeleteTodoServlet", urlPatterns = "/todos/delete.do")
public class DeleteTodoServlet extends HttpServlet {

	private static final long serialVersionUID = 3396052782113907433L;

	private TodoService todoService;

	private ResourceBundle resourceBundle;

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		ApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletConfig.getServletContext());
		todoService = applicationContext.getBean(TodoService.class);
		resourceBundle = ResourceBundle.getBundle("todolist");
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		final String id = request.getParameter("todoId");
		try {
			long todoId = Long.parseLong(id);
			TodoItem todoItem = todoService.getTodoById(todoId);
			if (todoItem != null) {
				todoService.remove(todoItem);
				request.getRequestDispatcher("/todos").forward(request,
						response);
			} else {
				redirectToErrorPage(request, response, id);
			}
		} catch (NumberFormatException e) {
			redirectToErrorPage(request, response, id);
		}
	}

	private void redirectToErrorPage(HttpServletRequest request,
			HttpServletResponse response, String todoId)
			throws ServletException, IOException {
		request.setAttribute("error", MessageFormat.format(
				resourceBundle.getString("no.such.todo"), todoId));
		request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
	}

}
