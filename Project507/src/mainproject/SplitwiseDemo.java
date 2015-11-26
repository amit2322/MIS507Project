/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

import java.util.ArrayList;
import java.util.List;
//import com.sun.javafx.applet.Splash;
import java.util.Scanner;

/**
 *
 * @author Amit
 */
public class SplitwiseDemo {
    public Payment selectPay (String select) {
		if ("p".equals(select)) {
		    return new Paypal();
		} else {
		    return new Venmo();
		}
    }

    public void calcuateAmount(UserAccount[] users,double amount){
    	BalanceCalculator balCalc=new BalanceCalculator();
    	balCalc.balanceAccounts(users, amount);
    }
    
    public void mypay (Payment mypaymethod, String payerName, String payeeName, String paymentAmount) {
    	mypaymethod.initPaymentType();
    	mypaymethod.payUsingSelectedPaymentType(payerName, payeeName, paymentAmount);
    }
    
    public static void main(String[] args) {
        /*
    	UserAccount prashPerson=new UserAccount(1,"Prashant","Karnad","Prash1@gmail.com",0.0,25.0,"Murali","Amit");
        UserAccount akashPerson=new UserAccount(2,"Akash","Joshi","Akash1@gmail.com",0.0,25.0,"Chanpreet","Amit");
        UserAccount muraliPerson=new UserAccount(3,"Murali","Vijay","Murali1@gmail.com",0.0,25.0,"Akash","Chanpreet");
        
        Group groupMIS=new Group("GroupMIS", "Bill 1");        
 
        groupMIS.registerObserver(prashPerson);
        groupMIS.registerObserver(akashPerson);
        groupMIS.registerObserver(muraliPerson);
        
        //Final notifications after end of algorithm. The same can be used as reminder to send periodic updates
        groupMIS.setNotification("Notify");
        //If a person's balances have been settled reminders will go only to other remaining people
        groupMIS.removeObserver(muraliPerson);
        groupMIS.setNotification("Notify");
        */
        //Strategy Design pattern begins
        String firstName="", lastName="", emailId="",selectedPaymentMode="", paymentAmount="",groupName="";
        String NumberOfUsers; 
        Payment p1, p2; 
        SplitwiseDemo objDemo = new SplitwiseDemo();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter No of Users");
        NumberOfUsers = in.nextLine();
        int maxUsers=Integer.parseInt(NumberOfUsers);
        List<UserAccount> group= new ArrayList<UserAccount>();
        System.out.println("Enter Group name:");
        groupName = in.nextLine();
        for(int i=0;i<maxUsers;i++){
        	
        	  System.out.println("Enter first name:");
              firstName = in.nextLine();
              System.out.println("Enter last name:");
              lastName = in.nextLine();
              System.out.println("Enter email id:");
              emailId = in.nextLine();
              
              UserAccount userAcct=new UserAccount(i,firstName,lastName,emailId,0.0,0.0,"","");
              group.add(userAcct);
        }
       
        System.out.println("Choose payment mode:\n 1. P for Paypal\n2. V for Venmo\n");
        selectedPaymentMode = in.nextLine();

  /*
    p1 = objDemo.selectPay(selectedPaymentMode.toLowerCase());	
	objDemo.mypay(p1, payerName, payeeName, paymentAmount);
    p1 = objDemo.selectPay(selectedPaymentMode.toLowerCase());
	objDemo.mypay(p1, payerName, payeeName, paymentAmount);
  */  
    }
}
