package br.com.pipolaris.wishlists.controller.form;

import javax.validation.constraints.NotNull;

import br.com.pipolaris.wishlists.model.Friend;
import br.com.pipolaris.wishlists.model.User;
import br.com.pipolaris.wishlists.repository.FriendRepository;

public class FriendForm {

	@NotNull
	private Long friendsOf;
	@NotNull
	private Long friend;

	public Long getFriendsOf() {
		return friendsOf;
	}

	public void setFriendsOf(Long friendsOf) {
		this.friendsOf = friendsOf;
	}

	public Long getFriend() {
		return friend;
	}

	public void setFriend(Long friend) {
		this.friend = friend;
	}

	public Friend create(FriendRepository friendRepository) {
		User friendsOf = friendRepository.getOne(this.friendsOf).getFriendsOf();
		User friends = friendRepository.getOne(this.friend).getFriends();

		Friend friend = new Friend(friendsOf, friends);
		return friend;
	}
}
