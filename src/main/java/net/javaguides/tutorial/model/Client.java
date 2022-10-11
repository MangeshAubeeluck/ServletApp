package net.javaguides.tutorial.model;

import java.math.BigDecimal;
import java.util.List;

public class Client {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private BigDecimal amountDue;

	@Override
	public String toString() {
		return "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", amountDue=" + amountDue + "]";
	}

	public Client(long id, String firstName, String lastName, String email, BigDecimal amountDue) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.amountDue = amountDue;
	}

	public Client(long id, String firstName, String lastName, String email, String amountDue) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.amountDue = new BigDecimal(amountDue);
	}

	public Client() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(BigDecimal amountDue) {
		this.amountDue = amountDue;
	}
	
	public void setAmountDue(String amountDue) {
		this.amountDue = new BigDecimal(amountDue);
	}

	public static List<Client> list() {
		// TODO Auto-generated method stub
		return null;
	}
}
