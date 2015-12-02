
package mainproject;

public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
    public void addObservers();
    public void remindObservers();
    public void paymentSuccess();
}

