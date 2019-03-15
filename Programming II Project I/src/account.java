
public class account{
	
	private String cardNumber;
	private String password;
	private double balance;
	
	public account(String cardNumber, String password, double balance) {
		this.cardNumber = cardNumber;
		this.password = password;
		this.balance = balance;
	}
	
	public boolean validate(String n, String p) {
		if (n.equals(cardNumber) && p.equals(password))
			return true;
		else
			return false;
	}
	
	public String getBalance() {
		return Double.toString(balance);
	}
	
	public void setBalance(double amount) {
		balance-=amount;
	}

	public void withdraw(String amount) {
		balance -= Double.parseDouble(amount);
	}

	public void deposit(String amount) {
		balance += Double.parseDouble(amount);
	}
}
