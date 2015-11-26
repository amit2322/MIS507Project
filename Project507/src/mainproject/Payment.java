package mainproject;

abstract class Payment {
    abstract public void initPaymentType ();
    abstract public void payUsingSelectedPaymentType(String payerName, String payeeName, String paymentAmount);
}
