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
public class Venmo extends Payment {
    public void  initPaymentType () {
	System.out.println("Intializing Venmo\n");
    }
    public void payUsingSelectedPaymentType(String payerName, String payeeName, String paymentAmount) {
	System.out.println("Logging into " +payerName+"'s Venmo Account\n");
        System.out.println("Intiating transfer");
        System.out.println("Transferring $" +paymentAmount +" to " +payeeName);
	System.out.println("Payment successfully made via Venmo\n");
    }
}
