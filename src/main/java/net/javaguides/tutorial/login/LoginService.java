package net.javaguides.tutorial.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class LoginService {
	static Logger log = Logger.getLogger(LoginService.class.getName());

	public boolean validate(Admin Admin) {
		boolean status = false;
		try {
			Connection conn = connect();
			PreparedStatement ps = conn
					.prepareStatement("select * from administrators  where AdminName=? and AdminPassword=?");

			ps.setString(1, Admin.getAdminName());
			ps.setString(2, Admin.getAdminPassword());

			ResultSet rs = ps.executeQuery();
			status = rs.next();
		} catch (Exception e) {
			System.out.println(e);

		}
		return status;
	}

	public  Connection connect() {
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
