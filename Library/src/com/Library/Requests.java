package com.Library;

import java.util.ArrayList;
import java.util.HashSet;

public class Requests implements RequestSubject{

	private HashSet<String> mediaRequests = new HashSet<String>();
	private ArrayList<RequestObserver> observers = new ArrayList<RequestObserver>();
	@Override
	public void addUser(RequestObserver observer) {
		observers.add(observer);
		
	}

	@Override
	public void removeUser(RequestObserver observer) {
		observers.remove(observer);
		
	}

	@Override
	public void notifyAllUsers() {
		for(RequestObserver ob : observers) {
			System.out.println("Notifying subcribers");
			ob.update(this.viewRequests());
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
