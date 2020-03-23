package com.douzone.container.user;

import java.util.List;

public class User {
	private String name = "김지술";
	private int no = 0;
	private Friend friend;
	
	private List<String> friends;
	
	public User() {}
	
	public User(String name) {
		this.name = name;
	}
	public User(int no,String name) {
		this.no = no;
		this.name = name;
	}

	
	
	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	
	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", no=" + no + ", friend=" + friend + ", friends=" + friends + "]";
	}


	
}
