public class dataBase {
	
	public  account myAccount1 = new account("5525", "txwr243%", 80000);
	public  account myAccount2 = new account("5432", "wxyz123&", 45000);
	public  account myAccount3 = new account("5678", "opqr456*", 60000);
	public  account myAccounts[] = new account[3];
	//predefined bank accounts
	
	public dataBase() {
		myAccounts[0] = myAccount1;
		myAccounts[1] = myAccount2;
		myAccounts[2] = myAccount3;
		
	}
}