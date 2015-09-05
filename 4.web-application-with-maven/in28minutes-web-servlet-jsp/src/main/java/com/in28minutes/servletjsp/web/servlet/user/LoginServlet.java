package com.in28minutes.servletjsp.web.servlet.user;

import static com.in28minutes.servletjsp.web.util.Views.LOGIN_PAGE;
import static com.in28minutes.servletjsp.web.util.Views.REDIRECT_HOME_PAGE;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.in28minutes.domain.User;
import com.in28minutes.service.api.UserService;
import com.in28minutes.web.common.form.LoginForm;
import com.in28minutes.web.common.util.TodoListUtils;

@WebServlet(name = "LoginServlet", urlPatterns = { "/", "/login", "/login.do" })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -4269917868939108463L;

	private UserService userService;

	private ResourceBundle resourceBundle;

	private Validator validator;

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {

		// initialize Spring user service
		ApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletConfig.getServletContext());

		userService = applicationContext.getBean(UserService.class);

		// initialize JSR 303 validator
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		validator = factory.getValidator();

		resourceBundle = ResourceBundle.getBundle("todolist");
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("loginTabStyle", "active");

		if (doesValidSessionExist(request)) {
			request.getRequestDispatcher(REDIRECT_HOME_PAGE).forward(request,
					response);
			return;
		}

		request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);

	}

	private boolean doesValidSessionExist(HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {

			User user = (User) session.getAttribute(TodoListUtils.SESSION_USER);

			if (user != null) {
				return true;
			}

		}
		return false;
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		LoginForm loginForm = new LoginForm();
		loginForm.setEmail(email);
		loginForm.setPassword(password);

		validateCredentials(request, loginForm);

		if (isInvalid(request)) {
			request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
			return;
		}

		if (isValidUser(email, password)) {
			request.setAttribute("error",
					resourceBundle.getString("login.form.invalid.credentials"));
			request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
			return;
		}

		HttpSession session = request.getSession(true);// create session
		User user = userService.getUserByEmail(email);
		session.setAttribute(TodoListUtils.SESSION_USER, user);
		request.getRequestDispatcher(REDIRECT_HOME_PAGE).forward(request,
				response);
	}

	private void validateCredentials(HttpServletRequest request,
			LoginForm loginForm) {
		validateEmail(request, loginForm);

		validatePassword(request, loginForm);
	}

	private boolean isValidUser(String email, String password) {
		return !userService.isValidUser(email, password);
	}

	private void validatePassword(HttpServletRequest request,
			LoginForm loginForm) {
		Set<ConstraintViolation<LoginForm>> constraintViolations = validator
				.validateProperty(loginForm, "password");
		if (!constraintViolations.isEmpty()) {
			request.setAttribute("errorPassword", constraintViolations
					.iterator().next().getMessage());
			addGlobalLoginErrorAttribute(request);
		}
	}

	private void validateEmail(HttpServletRequest request, LoginForm loginForm) {
		Set<ConstraintViolation<LoginForm>> constraintViolations = validator
				.validateProperty(loginForm, "email");
		if (!constraintViolations.isEmpty()) {
			request.setAttribute("errorEmail", constraintViolations.iterator()
					.next().getMessage());
			addGlobalLoginErrorAttribute(request);
		}
	}

	private void addGlobalLoginErrorAttribute(HttpServletRequest request) {
		request.setAttribute("error",
				resourceBundle.getString("login.form.incomplete.details"));
	}

	private boolean isInvalid(HttpServletRequest request) {
		return request.getAttribute("error") != null;
	}

}
