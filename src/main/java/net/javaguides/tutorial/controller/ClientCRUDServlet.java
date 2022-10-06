package net.javaguides.tutorial.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.tutorial.model.Client;
import net.javaguides.tutorial.service.ClientCRUDService;

/**
 * Servlet implementation class CliServlet
 */
@WebServlet(urlPatterns = { "/Clients" })
public class ClientCRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClientCRUDService ClientCRUD;

	public ClientCRUDServlet() {
		super();
	}

	public void init() {
		ClientCRUD = new ClientCRUDService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			List<Client> clients = ClientCRUD.selectClients();
			request.setAttribute("clients", clients); // Will be available as ${products} in JSP
			request.getRequestDispatcher("/client.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException("Cannot obtain products from DB", e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
