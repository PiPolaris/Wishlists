package br.com.pipolaris.wishlists.model;

public class Friend {

	private User friendsOf;
	private User friends;

	public Friend(User friendsOf, User friends) {
		super();
		this.friendsOf = friendsOf;
		this.friends = friends;
	}

	public User getFriendsOf() {
		return friendsOf;
	}

	public void setFriendsOf(User friendsOf) {
		this.friendsOf = friendsOf;
	}

	public User getFriends() {
		return friends;
	}

	public void setFriends(User friends) {
		this.friends = friends;
	}

	public Friend() {

	}

}