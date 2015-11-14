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
abstract class Payment {
    abstract public void initPaymentType ();
    abstract public void payUsingSelectedPaymentType(String payerName, String payeeName, String paymentAmount);
}
