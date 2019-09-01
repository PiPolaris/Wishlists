package br.com.pipolaris.wishlists.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.pipolaris.wishlists.model.User;
import br.com.pipolaris.wishlists.repository.UserRepository;

public class UpdateUserForm {
	@NotNull
	@NotEmpty
	@Length(min = 5)
	private String name;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User update(Long id, UserRepository userRepository) {
		User user = userRepository.getOne(id);
		user.setName(this.name);
		user.setPassword(this.password);
		return user;
	}
}
