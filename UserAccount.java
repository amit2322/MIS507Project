/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

import java.util.Scanner;

/**
 *
 * @author Amit
 */
public class UserAccount implements Observer{

    public int userId;
    public String userFirstName;
    public String userLastName;
    public String userEmail;
    public double amountOwed;
    public double amountReceivable;
    public String payableTo;
    public String receivableBy;

    public UserAccount(int userId, String userFirstName, String userLastName, String userEmail, double amountOwed, double amountReceivable, String payableTo, String receivableBy) {
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
    
    public void update(String notification) {
  System.out.println("E-mailing " +getUserEmail());
  System.out.println("Hello "+getUserFirstName());
  System.out.println("You owe "+getPayableTo()+" $"+getAmountOwed());
  System.out.println(getReceivableBy()+" owes you $"+amountReceivable+"\n");
    }
}
