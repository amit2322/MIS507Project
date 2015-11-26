package mainproject;

public class ObserverPatternMain {
    public static void main(String[] args) {
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
    }
}

