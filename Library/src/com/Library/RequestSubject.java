package com.Library;

public interface RequestSubject {
	public void addUser(RequestObserver observer);
	public void removeUser(RequestObserver observer);
	public void notifyAllUsers();
}
