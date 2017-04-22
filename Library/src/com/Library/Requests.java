package com.Library;

import java.util.ArrayList;
import java.util.HashSet;

public class Requests implements RequestSubject{

	private HashSet<String> mediaRequests = new HashSet<String>();
	private ArrayList<User> observers = new ArrayList<User>();
	@Override
	public void addUser(User user) {
		observers.add(user);
		
	}

	@Override
	public void removeUser(User user) {
		observers.remove(user);
		
	}

	@Override
	public void notifyAllUsers() {
		// TODO Auto-generated method stub
		
	}

	public HashSet<String> getMediaRequests() {
		return mediaRequests;
	}

	public void addMediaRequests() {
		//todo
	}

}
