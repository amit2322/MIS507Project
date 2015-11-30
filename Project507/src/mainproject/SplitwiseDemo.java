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
    
    public void mypay (Payment mypaymethod, String payerName, String payeeName, String paymentAmount) {
    	mypaymethod.initPaymentType();
    	mypaymethod.payUsingSelectedPaymentType(payerName, payeeName, paymentAmount);
    }
    
    public void ShowAccountsSummary(List<UserAccount> groupDetails){
        System.out.println("FirstName\t "
                + "LastName\t "
                + "Email\t\t"
                + "AmountOwed\t "
                + "AmountReceivable\t "
                + "PayableTo\t "
                + "ReceivableBy\n");
        for (int i = 0; i < groupDetails.size(); i++) {
            System.out.println(groupDetails.get(i).getUserFirstName()+"\t\t"+
                    groupDetails.get(i).getUserLastName()+"\t\t"+
                    groupDetails.get(i).getUserEmail()+"\t\t"+
                    groupDetails.get(i).getAmountOwed()+"\t\t"+
                    groupDetails.get(i).getAmountReceivable()+"\t\t"+
                    groupDetails.get(i).getPayableTo()+"\t\t"+
                    groupDetails.get(i).getReceivableBy()+"\t\t"                    
                    );            
        }
        System.out.println("\n");
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
        SplitwiseDemo objDemo = new SplitwiseDemo();
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the design patterns demo !!");
        System.out.println("Enter Group name:");       
        groupName = in.nextLine();
        System.out.println("Enter No of Users to be added to the group:");
        NumberOfUsers = in.nextLine();
        int maxUsers = Integer.parseInt(NumberOfUsers);
        List<UserAccount> group= new ArrayList<UserAccount>(); 
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
        
        for(UserAccount userAcct: group){
        if(userAcct.getUserFirstName().equals(amountPaidBy)){
                  userAcct.setPayable(true);
              }
        else{
            userAcct.setPayableTo(amountPaidBy);
        }
        }
        objDemo.calcuateAmount(group,amountContributed);
        objDemo.ShowAccountsSummary(group);
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
