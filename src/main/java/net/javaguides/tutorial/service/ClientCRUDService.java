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

public class ClientCRUDService {

	static Logger log = Logger.getLogger(ClientService.class.getName());

	public List<Client> selectClients() {
		String sql = "SELECT * FROM clientData"; // sql query saved in the variable sql
		List<Client> clients = new ArrayList<Client>(); // list being saved in the variable clients
		try (Connection conn = ClientCRUDService.connect(); //
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				Client client = new Client();
				client.setId(rs.getLong("id")); // s
				client.setFirstName(rs.getString("firstName"));
				client.setLastName(rs.getString("lastName"));
				client.setEmail(rs.getString("email"));
				client.setAmountDue(rs.getBigDecimal("amountDue"));// setting the amount due of the client
				clients.add(client);// appending the client object to the list of clients

			}
			conn.close();
		} catch (SQLException e) {
			log.severe(e.getMessage());
		}

		return clients;

	}

	public static Client getRecordById(long id) {
		Client client = null;
		try {
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement("select * from clientData where id=?");
			ps.setLong(1, (long) id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				client = new Client();
				client.setId(rs.getLong("id"));
				client.setFirstName(rs.getString("firstName"));
				client.setLastName(rs.getString("lastName"));
				client.setEmail(rs.getString("email"));
				client.setAmountDue(rs.getBigDecimal("amountDue"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return client;
	}

	public static int delete(Client client) {
		int status = 0;
		try {
			Connection conn = ClientCRUDService.connect();
			PreparedStatement ps = conn.prepareStatement("delete from clientData where id=?");
			ps.setFloat(1, client.getId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public static int save(Client client) {
		int status = 0;
		try {
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement(
					"insert into clientData(id,firstName,lastName,emnail,amountDue) values(?,?,?,?,?)");
			ps.setLong(1, client.getId());
			ps.setString(2, client.getFirstName());
//	        ps.setString(3,client.getLastName();  
//	        ps.setString(4,u.getSex());  
//	        ps.setString(5,u.getCountry());  
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int update(Client client) {
		int status = 0;
		try {
			Connection conn = connect();
			PreparedStatement ps = conn
					.prepareStatement("update clientData set firstName=?,lastName=?,email=?,amountDue=? where id=?");
			ps.setString(1, client.getFirstName());
			ps.setString(2, client.getLastName());
			ps.setString(3, client.getEmail());
			ps.setBigDecimal(4, client.getAmountDue());
			ps.setLong(5, client.getId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			log.severe(e.getMessage());
		}
		return status;
	}

	public static Connection connect() {
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
