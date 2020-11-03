package com.fdmgroup.Stratagem.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
   
    private String username;
   
    @Column(name = "USER_PASSWORD")
    private String password;
   
    @Id
    @Column(name = "USER_EMAIL" ,unique = true)
    private String email;
   
    @Column(name = "USER_FIRST_NAME")
    private String firstName;
   
    @Column(name = "USER_LAST_NAME")
    private String lastName;
   
    @Column(name = "USER_ROLE")
    private String role;

	public User(long id, String username, String password, String email, String firstName, String lastName,
			String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	public User() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
    
}
