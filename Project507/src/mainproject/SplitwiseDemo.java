package mainproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitwiseDemo {
    public Payment selectPay (String select) {
		return Payment.getInstance(select);
    }

    public void calcuateAmount(List<UserAccount> users,double amount){
    	BalanceCalculator balCalc=new BalanceCalculator();
    	balCalc.balanceAccounts(users, amount);
    }
    
    public boolean mypay (Payment mypaymethod, String payerName, String payeeName, String paymentAmount) 
    {
        boolean paymentStatus;
    	mypaymethod.initPaymentType();
    	paymentStatus = mypaymethod.payUsingSelectedPaymentType(payerName, payeeName, paymentAmount);
        return paymentStatus;
    }
    
    public void ShowAccountsSummary(List<UserAccount> groupDetails){
        System.out.println("FirstName\t "
                + "LastName\t "
                
                + "AmountOwed\t "
                + "AmountReceivable\t "
                + "PayableTo\t"
                + "Email\n");
               // + "ReceivableBy\n");
        for (int i = 0; i < groupDetails.size(); i++) {
            System.out.println(groupDetails.get(i).getUserFirstName()+"\t\t"+
                    groupDetails.get(i).getUserLastName()+"\t\t"+
                   
                    groupDetails.get(i).getAmountOwed()+"\t\t"+
                    groupDetails.get(i).getAmountReceivable()+"\t\t"+
                    groupDetails.get(i).getPayableTo()+"\t\t"+
                    groupDetails.get(i).getUserEmail()+"\t\t"
                   // groupDetails.get(i).getReceivableBy()+"\t\t"                    
                    );            
        }
        System.out.println("\n");
    }
    
    public void SendAccountsSummary(Group groupMIS){
    
    	groupMIS.setNotification("Notify");

    }
    
    public void SendPaymentNotification(Group groupMIS){
        
    	groupMIS.paymentSuccess();

    }
    
    public boolean MakeAPayment(List<UserAccount> groupDetails)
    {
        Scanner in = new Scanner(System.in);
        String payerName;
        String payeeName;
        String selectedPaymentMode="";
        double paymentAmount;
        Payment p1, p2; 
        boolean paymentStatus;
        boolean isPayerValid;
        boolean isPayeeValid;
        boolean isPaymentAmountValid;
        System.out.println("Payments................\n");
        System.out.println("Enter payer name:");
        payerName = in.nextLine();
        isPayerValid = ValidatePayerName(groupDetails, payerName);
        if(!isPayerValid)
        {
            System.out.println("Invalid payer name");
            System.out.println("Re - Enter payer name:");
            payerName = in.nextLine();
        }
        System.out.println("Enter payee name:");
        payeeName = in.nextLine();
        isPayeeValid = ValidatePayerName(groupDetails, payeeName);
        if(!isPayeeValid || (payeeName == payerName))
        {
            System.out.println("Invalid payee name");
            System.out.println("Re - Enter payee name:");
            payeeName = in.nextLine();
        }        
        System.out.println("Enter payment amount:");
        paymentAmount = new Double(in.nextLine());
        isPaymentAmountValid = ValidatePaymentAmount(groupDetails, paymentAmount);
        if(!isPaymentAmountValid)
        {
            System.out.println("Invalid payment amount");
            System.out.println("Re - Enter payment amount:");
            paymentAmount = new Double(in.nextLine());
        }
        System.out.println("Choose payment mode:\n "
                + "1. P for Paypal\n"
                + "2. V for Venmo\n"
                + "3. C for Credit Card");
        selectedPaymentMode = in.nextLine();
	p1 = selectPay(selectedPaymentMode.toLowerCase());
        paymentStatus = mypay(p1, payerName, payeeName, String.valueOf(paymentAmount));
        return paymentStatus;
    }
    
    public boolean ValidatePayerName(List<UserAccount> groupDetails, String payerName)
    {
        boolean IsValid = false;
        for (int i = 0; i < groupDetails.size(); i++) 
        {
            if(groupDetails.get(i).getUserFirstName().equals(payerName))
            {                
                IsValid = true;
            }
        }
        return IsValid;
    }
    
    public boolean ValidatePaymentAmount(List<UserAccount> groupDetails, double paymentAmount)
    {
        boolean IsValid = false;
        for (int i = 0; i < groupDetails.size(); i++) 
        {
            if(groupDetails.get(i).getAmountOwed() >= paymentAmount)
            {                
                IsValid = true;
            }
        }
        return IsValid;
    }
    public static void main(String[] args) {
        
        //Strategy Design pattern begins
        String firstName="";
        String lastName="";
        String emailId="";
        String selectedPaymentMode="";
        String paymentAmount="";
        String groupName="";
        String NumberOfUsers; 
        String payerName;
        String payeeName;
        Payment p1, p2; 
        boolean paymentStatus;
        SplitwiseDemo objDemo = new SplitwiseDemo();
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the design patterns demo !!");
        System.out.println("Enter Group name:");       
        groupName = in.nextLine();
        System.out.println("Enter No of Users to be added to the group:");
        NumberOfUsers = in.nextLine();
        int maxUsers = Integer.parseInt(NumberOfUsers);
        List<UserAccount> group= new ArrayList<UserAccount>(); 

        Group groupMIS=new Group("GroupMIS", "Bill 1");
        for(int i=0;i<maxUsers;i++){
              System.out.println("User number " + (i+1) + " details");
              System.out.println("Enter first name:");
              firstName = in.nextLine();
              System.out.println("Enter last name:");
              lastName = in.nextLine();
              System.out.println("Enter email id:");
              emailId = in.nextLine();
              
              UserAccount userAcct=new UserAccount(i,firstName,lastName,emailId,0.0,0.0,"","");
              
              group.add(userAcct);  
              
              
              //adding people to the group
              groupMIS.registerObserver(userAcct);
              groupMIS.setWelcome("GroupMIS");
              
        }
        String amountPaidBy;
        double amountContributed;
        System.out.println("All users successfully added to the group:" + groupName);
        objDemo.ShowAccountsSummary(group); 
       
        System.out.println("Record a transaction....");
        System.out.println("Amount paid by:");        
        amountPaidBy = in.nextLine();
        System.out.println("Enter amount you contributed:");
        amountContributed = new Double(in.nextLine());
        
        for(UserAccount userAcct: group)
        {
            if(userAcct.getUserFirstName().equals(amountPaidBy))
            {
                userAcct.setReceivable(true);
            }
            else
            {
                userAcct.setPayableTo(amountPaidBy);
            }
        }
        objDemo.calcuateAmount(group,amountContributed);
        objDemo.ShowAccountsSummary(group);
        objDemo.SendAccountsSummary(groupMIS);
        paymentStatus = objDemo.MakeAPayment(group);
        if(paymentStatus == true)
        {   
        	objDemo.SendPaymentNotification(groupMIS);
            System.out.println("Payment Successful");
        }
        else
        {
            System.out.println("Payment failed");
        }
    }
}