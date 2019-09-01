package br.com.pipolaris.wishlists.controller.form;

import javax.validation.constraints.NotNull;

import br.com.pipolaris.wishlists.model.User;
import br.com.pipolaris.wishlists.model.Wishlist;
import br.com.pipolaris.wishlists.repository.UserRepository;

public class WishlistForm {
	@NotNull
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Wishlist convert(UserRepository userRepository) {
		User user = userRepository.getOne(userId);
		return new Wishlist(user);
	}
}
