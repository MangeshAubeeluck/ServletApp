package net.javaguides.tutorial.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import net.javaguides.tutorial.model.Client;
import net.javaguides.tutorial.service.ClientService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(urlPatterns = { "/Clientss" })
public class ClientServlet extends HttpServlet {

	Logger log = Logger.getLogger(ClientServlet.class.getName());
	private static final long serialVersionUID = 1L;
	private ClientService service = new ClientService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientServlet() {
		super();
	}

	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { try { List<Client> products
	 * = productDAO.list(); request.setAttribute("products", products); // Will be
	 * available as ${products} in JSP
	 * request.getRequestDispatcher("/WEB-INF/clients.jsp").forward(request,
	 * response); } catch (Exception e) { throw new
	 * ServletException("Cannot obtain products from DB", e); } }
	 */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Client> clients = service.selectClients();
//		Client client = new Client();
//		service.updateClients(client);
		Gson gson = new Gson();
		String clientJSON = gson.toJson(clients);
		PrintWriter printWriter = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		printWriter.write(clientJSON);
		printWriter.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String amountDue = request.getParameter("amountDue");
		Client client = new Client(Long.parseLong(id), firstName, lastName, email, new BigDecimal(amountDue));
		service.insertClients(client);
		log.info(client.toString());
		PrintWriter printWriter = response.getWriter();
		printWriter.write(client.toString());

//		try { 
//
//			// Initialize the database 
//			 
//
//			// Create a SQL query to insert data into demo table 
//			// demo table consists of two columns, so two '?' is used 
//			Connection conn = this.connect(); //
//			Statement stmt = conn.createStatement(); 
//
//			// For the first parameter, 
//			// get the data using request object 
//			// sets the data to st pointer 
//			stmt.setInt(1, Integer.valueOf(request.getParameter("id"))); 
//
//			// Same for second parameter 
//			stmt.setString(2, request.getParameter("string")); 
//
//			// Execute the insert command using executeUpdate() 
//			// to make changes in database 
//			stmt.executeUpdate(); 
//
//			// Close all the connections 
//			stmt.close(); 
//			conn.close(); 
//
//			// Get a writer pointer 
//			// to display the successful result 
//			PrintWriter out = response.getWriter(); 
//			out.println("<html><body><b>Successfully Inserted"
//						+ "</b></body></html>"); 
//		} 
//		catch (Exception e) { 
//			e.printStackTrace(); 
//		} 
//		
	}

}
