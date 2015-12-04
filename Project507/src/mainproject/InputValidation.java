package mainproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = 
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


	public boolean validateEmail(String email) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	private boolean verifyName(String name)
	{
		name = name.trim();

	    if(name == null || name.equals(""))
	        return false;

	    if(!name.matches("[a-zA-Z]*"))
	        return false;

	    return true;
	}
	
//	private boolean verifyEmail(String email)
//	{
//	    email = email.trim();
//
//	    if(email == null || email.equals(""))
//	        return false;
//
//	    if(!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"))
//	        return false;
//
//	    return true;
//	}
	public void checkDuplicateEntry(UserAccount[] users,String name){
        for(UserAccount user : users){
            if(user.getUserFirstName().equals(name)){
                System.out.println("Duplicate entry of user");
            }
        }
    }
  
    public void checkAmount(Double amount){
        if(amount<0.0){
            System.out.println("Amount cannot be negative");
        }
    }
  
    public void checkUsersInput(UserAccount[] users,String name){
        checkDuplicateEntry(users,name);
    }
  
  
    
    
    public void checkUserExists(UserAccount[] users,String name){
        boolean isUserExists=false;
        for(UserAccount user: users){
        	if(user.getUserFirstName().equals(name)){
                isUserExists=true;
            }
        }
        
        if(!isUserExists){
            System.out.println("User does not exist");
        }
    }

    public void checkGroup(int numberOfUsers){
        if(numberOfUsers<2){
            System.out.println("Please enter a minimum of 2 users for the group");
        }
    }
       
    public void validateOperation(int operation){
        if(operation<1 || operation>4){
        System.out.println("Please enter a valid operation between 1 and 4");
        }
    }
   
        public boolean isThisDateValid(String dateToValidate){
           
            if(dateToValidate == null){
                return false;
            }
           
            SimpleDateFormat dateFromat = new SimpleDateFormat("MM/dd/yyyy");
            dateFromat.setLenient(false);
           
            try {
               
                //if not valid, it will throw ParseException
                Date date = dateFromat.parse(dateToValidate);
                System.out.println(date);
           
            } catch (ParseException e) {
               
                e.printStackTrace();
                return false;
            }
   
        return true;
        }
       
    //    checkdateNotFuture(){
           
      //  }
       
        public void checkUserDetails (String aName, double aSpeed) {
            if (!checkName(aName)) {
              throw new IllegalArgumentException("Name is empty.");
            }
        }

        private boolean checkName(String name){
            String EMPTY_STRING = "";
            return (name != null) && (!name.trim().equals(EMPTY_STRING));
        }
       
        public static void checkForNull(Object aObject) {
            if (aObject == null) {
              throw new NullPointerException();
            }
       }
}
