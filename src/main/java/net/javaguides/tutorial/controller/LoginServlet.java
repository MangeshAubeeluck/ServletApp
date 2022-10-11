package net.javaguides.tutorial.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.tutorial.login.Admin;
import net.javaguides.tutorial.login.LoginService;

@WebServlet(urlPatterns = { "/Login" })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Logger log = Logger.getLogger(LoginService.class.getName());

	private LoginService service = new LoginService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("admin");
		String password = req.getParameter("password");

		boolean loginSucceful = service.validate(new Admin(name, password));
		
		log.info("Login ok?: " + loginSucceful);
		req.getRequestDispatcher("/Clients").forward(req, resp);
	}

}
