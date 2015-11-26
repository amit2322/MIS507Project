package mainproject;

public class Paypal extends Payment {
    public void  initPaymentType () {
	System.out.println("Intializing Paypal\n");
    }
    public void payUsingSelectedPaymentType(String payerName, String payeeName, String paymentAmount) {
        System.out.println("Logging into " +payerName+"'s Paypal Account\n");
        System.out.println("Intiating transfer");
        System.out.println("Transferring $" +paymentAmount +" to " +payeeName);
	System.out.println("Payment successfully made via Paypal\n");
    }
}
