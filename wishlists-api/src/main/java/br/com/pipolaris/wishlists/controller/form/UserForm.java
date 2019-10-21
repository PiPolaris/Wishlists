package br.com.pipolaris.wishlists.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.pipolaris.wishlists.model.User;

public class UserForm {
	
	private String name;
	@NotNull
	@NotEmpty
	@Length(min = 5)
	private String email;
	@NotNull
	@NotEmpty
	@Length(min = 5)
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User create(UserForm userForm) {
		User user = new User(userForm.name, userForm.email, userForm.password);
		return user;
	}
}
