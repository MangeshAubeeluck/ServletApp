package net.javaguides.tutorial.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import net.javaguides.tutorial.model.Client;

public class ClientService {
	Logger log = Logger.getLogger(ClientService.class.getName());

	public List<Client> selectClients() {
		String sql = "SELECT * FROM clientData"; // sql query saved in the variable sql
		List<Client> clients = new ArrayList<Client>(); // list being saved in the variable clients
		try (Connection conn = this.connect(); //
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				Client cli = new Client();
				cli.setId(rs.getLong("id")); // s
				cli.setFirstName(rs.getString("firstName"));
				cli.setLastName(rs.getString("lastName"));
				cli.setEmail(rs.getString("email"));
				cli.setAmountDue(rs.getBigDecimal("amountDue"));// setting the amount due of the client
				clients.add(cli);// appending the client object to the list of clients

			}
			conn.close();
		} catch (SQLException e) {
			log.severe(e.getMessage());
		}

		return clients;

	}

	public void insertClients(Client client) {

		String sql = "INSERT INTO clientData(id,firstName,lastName,email,amountDue)Values (?,?,?,?,?)"; 
		try {
			Connection conn = this.connect();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, client.getId());
			pstmt.setString(2, client.getFirstName());
			pstmt.setString(3, client.getLastName());
			pstmt.setString(4, client.getEmail());
			pstmt.setBigDecimal(5, client.getAmountDue());
			int rowsAffected = pstmt.executeUpdate();
			log.info("Number of client created:" + rowsAffected);
			
			conn.close();
		} catch (SQLException e) {
			log.severe(e.getMessage());
		}

	}
	
	public void updateClients(Client client) {
		
		String sql = "UPDATE clientData set amountDUE = 400, where id =9";
		try {
			Connection conn = this.connect();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int rowsAffected = pstmt.executeUpdate();
			log.info("Number of client created:" + rowsAffected);
			conn.close();
		} catch (SQLException e) {
			log.severe(e.getMessage());
		}
	}

	private Connection connect() {
		// SQLite connection string
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC"); // load sqlite driver
			conn = DriverManager.getConnection("jdbc:sqlite:C:\\data\\mangesh.db");
		} catch (SQLException | ClassNotFoundException e) {
			log.severe(e.getMessage());
		}
		return conn;
	}

}