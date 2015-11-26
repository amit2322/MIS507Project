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
 import java.io.*;
import java.util.Scanner;
 
public class UserAccount implements Observer{
    
    private int userId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private double amountOwed;
    private double amountReceivable;
    private String payableTo;
    private String receivableBy;
    private boolean isPayable;
    

//  public UserAccount(int userId, String userFirstName, String userLastName, String userEmail, double amountOwed, double amountReceivable, //String payableTo, String receivableBy) {
  public UserAccount(int userId, String userFirstName, String userLastName, String userEmail, double amountOwed, double amountReceivable, String payableTo, String receivableBy){
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.amountOwed = amountOwed;
        this.amountReceivable = amountReceivable;
        this.payableTo = payableTo;
        this.receivableBy = receivableBy;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(double amountOwed) {
        this.amountOwed = amountOwed;
    }

    public double getAmountReceivable() {
        return amountReceivable;
    }

    public void setAmountReceivable(double amountReceivable) {
        this.amountReceivable = amountReceivable;
    }

    public String getPayableTo() {
        return payableTo;
    }

    public void setPayableTo(String payableTo) {
        this.payableTo = payableTo;
    }

    public String getReceivableBy() {
        return receivableBy;
    }

    public void setReceivableBy(String receivableBy) {
        this.receivableBy = receivableBy;
    }
   
    public boolean isPayable() {
  		return isPayable;
  	}

  	public void setPayable(boolean isPayable) {
  		this.isPayable = isPayable;
  	}
  	
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        //Scanner to get user input for number of users
        System.out.println("Enter number of Users");
    
        int no_of_users = sc.nextInt();
        for(int i=0;i<no_of_users;i++){
            System.out.println("Enter First Name: ");
            String fname = sc.nextLine();   
            System.out.println("Enter Last Name: ");
            String lname  = sc.nextLine();
            System.out.println("Enter email Id Name: ");
            String email = sc.nextLine();
            UserAccount uA = new UserAccount(i, fname, lname, email,0,0,"","");        
        }
    }

	@Override
	public void update(String notification) {
		  System.out.println("E-mailing " +getUserEmail());
		  System.out.println("Hello "+getUserFirstName());
		  if(this.isPayable()){
			  System.out.println("You owe "+getPayableTo()+" $"+getAmountOwed());
		  }else{
			  System.out.println(getReceivableBy()+" owes you $"+amountReceivable+"\n");
		  }
	}
    
}
