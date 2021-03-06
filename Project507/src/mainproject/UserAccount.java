
package mainproject;

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
    private boolean isReceivable;
    private String emailbody;

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
   
    public boolean isReceivable() {
  		return isReceivable;
  	}

  	public void setReceivable(boolean isReceivable) {
  		this.isReceivable = isReceivable;
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

	
	
	public void update(String notification) {
		if(!isReceivable()){
			emailbody = "Hello " +getUserFirstName() +",\n"+"You owe "+getPayableTo()+" $"+getAmountOwed();
			EmailNotification.sendEmail(getUserEmail(),"Payment Details",emailbody );
		}
	      
	      
	    }

	public void add(String notification) {
	      emailbody = "Hello "+getUserFirstName()+"\n"+
	                     "You have been added to the group "+notification+"\n";
	      EmailNotification.sendEmail(getUserEmail(),"Addition to Group",emailbody );
	    }

	public void remind(String notification) {
	      emailbody = "Hello "+getUserFirstName()+"\n"+
	                     "You owe "+getPayableTo()+" $"+getAmountOwed()+"\n";
	      EmailNotification.sendEmail(getUserEmail(),"Gentle Reminder to pay",emailbody );
	    }

	public void paysuccess(String notification) {
		if(!isReceivable()){
	      emailbody = "Hello "+getUserFirstName()+"\n"+
	                     "Your payment to "+getPayableTo()+"of $"+getAmountOwed()+" is successful "+"\n";
         EmailNotification.sendEmail(getUserEmail(),"Payment Success",emailbody );
		}
	    }
    
}
