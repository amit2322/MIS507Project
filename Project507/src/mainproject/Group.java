package mainproject;

import java.util.ArrayList;

public class Group implements Subject {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private String groupName;
	String notification;

	public Group(String groupName, String notification) {
		super();
		this.groupName = groupName;
		this.notification = notification;
	}

	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setgroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
		notifyObservers();
	}

	public void setWelcome(String welcome) {
		this.notification = welcome;
		addObservers();
	}

	public void setReminder(String reminder) {
		this.notification = reminder;
		remindObservers();
	}

	public void paymentSuccess(String success) {
		this.notification = success;
		paymentSuccess();
	}

	public void notifyObservers() {
		System.out.println("Notifying Subscribers");
		System.out.println("---------------------");
		for (Observer ob : observers) {
			ob.update(this.notification);
		}
	}

	public void addObservers() {
		System.out.println("Adding Subscribers");
		System.out.println("---------------------");
		for (Observer ob : observers) {
			ob.add(this.notification);
		}
	}

	public void paymentSuccess() {
		System.out.println("Payment Success");
		System.out.println("---------------------");
		for (Observer ob : observers) {
			ob.paysuccess(this.notification);
		}
	}

	public void remindObservers() {
		System.out.println("Reminding Subscribers");
		System.out.println("---------------------");
		for (Observer ob : observers) {
			ob.remind(this.notification);
		}
	}

	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
}
