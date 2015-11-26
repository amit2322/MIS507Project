package mainproject;

public class BalanceCalculator {

	public UserAccount[] balanceAccounts(UserAccount[] users, Double amount){
		int totalUsers=users.length;
    	for(UserAccount user: users){
    		if(user.isPayable()){
    			double amtRec= amount - (amount/totalUsers);
    			user.setAmountReceivable(amtRec);
    		}else{
    			user.setAmountOwed(amount/totalUsers);
    		}
    	}
	return users;
	}
}
