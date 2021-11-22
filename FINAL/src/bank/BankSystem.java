package bank;

public class BankSystem {
	
	// Data Fields
	private String bankName;
	private String bankLicense;
	private double bankMoney;
	
	
	
	// Methods
	public BankSystem(){
	}
	
	public BankSystem(String givenName){
		setName(givenName);
	}
	
	
	
	// Setters and Getters
	public void setName(String givenName) {
		bankName = givenName;
	}
	
	public String getName() {
		return bankName;
	}
}
