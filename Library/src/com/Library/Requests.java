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
		for(User ur : observers) {
			System.out.println("Notifying subcribers");
			ur.update(this.viewRequests());
		}
		
	}

	public String viewRequests() {
		return mediaRequests.toString();
	}

	public void addMediaRequests(String medianame) {
		mediaRequests.add(medianame);
	}
	
	public void removeRequest(String medianame) {
		mediaRequests.remove(medianame);
	}

}
