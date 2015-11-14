/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

import com.sun.javafx.applet.Splash;
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

    public void mypay (Payment mypaymethod, String payerName, String payeeName, String paymentAmount) {
	mypaymethod.initPaymentType();
	mypaymethod.payUsingSelectedPaymentType(payerName, payeeName, paymentAmount);
    }
    public static void main(String[] args) {
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
        
        //Strategy Design pattern begins
        String payerName, payeeName, selectedPaymentMode, paymentAmount;
        Payment p1, p2; 
        SplitwiseDemo objDemo = new SplitwiseDemo();
        Scanner in = new Scanner(System.in);
        System.out.println("Payments................\n");
        System.out.println("Enter payer name:");
        payerName = in.nextLine();
        System.out.println("Enter payee name:");
        payeeName = in.nextLine();
        System.out.println("Enter payment amount:");
        paymentAmount = in.nextLine();
        System.out.println("Choose payment mode:\n 1. P for Paypal\n2. V for Venmo\n");
        selectedPaymentMode = in.nextLine();
	p1 = objDemo.selectPay(selectedPaymentMode.toLowerCase());
	
	objDemo.mypay(p1, payerName, payeeName, paymentAmount);
    }
}
