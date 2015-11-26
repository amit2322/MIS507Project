/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

/**
 *
 * @author Amit
 */
import java.util.ArrayList;
public class Group implements Subject{
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private String groupName;
    String notification;
    public Group(String groupName, String notification) {
		 super();
		 this.groupName = groupName;
		 this.notification=notification;
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
    
    public void notifyObservers() {
		 System.out.println("Notifying Subscribers");
		 System.out.println("---------------------");
		 for (Observer ob : observers) {
		     ob.update(this.notification );
		 }
    }
    
    public void registerObserver(Observer observer) {
    	observers.add(observer);
    }
    
    public void removeObserver(Observer observer) {
    	observers.remove(observer);
    }
}


