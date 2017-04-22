package com.Library;

public interface RequestSubject {
	public void addUser(User user);
	public void removeUser(User user);
	public void notifyAllUsers();
}
