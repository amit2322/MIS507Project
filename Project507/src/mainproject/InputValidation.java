package mainproject;

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
	
}
