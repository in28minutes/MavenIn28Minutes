package com.in28minutes.servletjsp.web.servlet.todo;

import static com.in28minutes.servletjsp.web.util.Views.ERROR_PAGE;
import static com.in28minutes.servletjsp.web.util.Views.UPDATE_TODO_PAGE;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.in28minutes.domain.Priority;
import com.in28minutes.domain.TodoItem;
import com.in28minutes.service.api.TodoService;

@WebServlet(name = "UpdateTodoServlet", urlPatterns = { "/todos/update",
		"/todos/update.do" })
public class UpdateTodoServlet extends HttpServlet {

	private static final long serialVersionUID = 377355125874696239L;

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
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		final String id = request.getParameter("todoId");

		try {
			long todoId = Long.parseLong(id);
			TodoItem todoItem = todoService.getTodoById(todoId);
			request.setAttribute("todo", todoItem);
			request.getRequestDispatcher(UPDATE_TODO_PAGE).forward(request,
					response);
		} catch (NumberFormatException e) {
			request.setAttribute(
					"error",
					MessageFormat.format(
							resourceBundle.getString("no.such.todo"), id));
			request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		long todoId = Long.parseLong(request.getParameter("todoId"));

		TodoItem todoItem = todoService.getTodoById(todoId);

		todoItem.setTitle(request.getParameter("title"));
		todoItem.setDueDate(new Date(request.getParameter("dueDate")));
		todoItem.setDone(Boolean.valueOf(request.getParameter("status")));
		todoItem.setPriority(Priority.valueOf(request.getParameter("priority")));

		todoService.update(todoItem);

		request.getRequestDispatcher("/todos").forward(request, response);

	}

}
