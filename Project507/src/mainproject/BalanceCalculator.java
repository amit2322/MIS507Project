package mainproject;

import java.text.DecimalFormat;
import java.util.List;

public class BalanceCalculator {

	public List<UserAccount> balanceAccounts(List<UserAccount> users, Double amount){
		int totalUsers=users.size();
    	for(UserAccount user: users){
    		if(user.isReceivable()){
    			double amtRec= amount - (amount/totalUsers);
                        amtRec = FormatAmount(amtRec);
    			user.setAmountReceivable(amtRec);
    		}else{
                        double amountOwed = amount/totalUsers;
                        amountOwed = FormatAmount(amountOwed);
    			user.setAmountOwed(amountOwed);
    		}
    	}
	return users;
	}
        public double FormatAmount(double amount){
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.valueOf(df.format(amount));
        }
}
