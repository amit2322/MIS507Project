
package mainproject;

public class Venmo extends Payment {
    public String venmoUserName;
    public String venmoPassword;
    private static Venmo instance;

    public String getVenmoUserName() {
        return venmoUserName;
    }

    public void setVenmoUserName(String venmoUserName) {
        this.venmoUserName = venmoUserName;
    }

    public String getVenmoPassword() {
        return venmoPassword;
    }

    public void setVenmoPassword(String venmoPassword) {
        this.venmoPassword = venmoPassword;
    }
    
    public void  initPaymentType () {
	System.out.println("Intializing Venmo\n");
    }
    public void payUsingSelectedPaymentType(String payerName, String payeeName, String paymentAmount) {
	System.out.println("Logging into " +payerName+"'s Venmo Account\n");
        System.out.println("Intiating transfer");
        System.out.println("Transferring $" +paymentAmount +" to " +payeeName);
	System.out.println("Payment successfully made via Venmo\n");
    }
    public static Venmo getInstance(){
        if(instance == null){
            instance = new Venmo();
        }
        return instance;
    }
}
