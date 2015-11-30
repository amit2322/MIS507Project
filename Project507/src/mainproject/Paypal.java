package mainproject;

public class Paypal extends Payment {
    public String paypalUserName;
    public String paypalPassword;

    public String getPaypalUserName() {
        return paypalUserName;
    }

    public void setPaypalUserName(String paypalUserName) {
        this.paypalUserName = paypalUserName;
    }

    public String getPaypalPassword() {
        return paypalPassword;
    }

    public void setPaypalPassword(String paypalPassword) {
        this.paypalPassword = paypalPassword;
    }
    
    private static Paypal instance;
    @Override
    public void  initPaymentType () {
	System.out.println("Intializing Paypal\n");
    }
    @Override
    public void payUsingSelectedPaymentType(String payerName, String payeeName, String paymentAmount) {
        System.out.println("Logging into " +payerName+"'s Paypal Account\n");
        System.out.println("Intiating transfer");
        System.out.println("Transferring $" +paymentAmount +" to " +payeeName);
	System.out.println("Payment successfully made via Paypal\n");
    }
    public static Paypal getInstance(){
        if(instance == null){
            instance = new Paypal();
        }
        return instance;
    }
}
