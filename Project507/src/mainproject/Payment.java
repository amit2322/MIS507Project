package mainproject;

abstract class Payment 
{
    private static Payment instance;
    abstract public void initPaymentType ();
    abstract public boolean payUsingSelectedPaymentType(String payerName, String payeeName, String paymentAmount);
    public static Payment getInstance(String selectedPaymentMode)
    {
        if ("p".equals(selectedPaymentMode)) 
        {
            instance = Paypal.getInstance();
        } 
        else if("v".equals(selectedPaymentMode))
        {
            instance = Venmo.getInstance();
        }
        else
        {
            instance = CreditCard.getInstance();
        }
        return instance;
    }    
}