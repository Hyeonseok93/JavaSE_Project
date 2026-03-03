package workshop.account.entity;

public class Account {
	private String custId;
	private String acctId;
	private int balance;
	
	//setter method (멤버변수 값 변경)
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
//	public void setBalance(int balance) {
//		this.balance = balance;
//	}
		
	//getter method (멤버변수 값 조회)
	public String getCustId() {
		return custId;
	}
	public String getAcctId() {
		return acctId;
	}
	public int getBalance() {
		return balance;
	}
	
	// 입금
	public void deposit(int amount) {
		// this.balance = this.balance + amount;
		this.balance += balance;
	}
	
	// 출금
	public void withdraw(int amount) {
		if(amount > balance) {
			System.out.println("잔액 부족");
		}
		this.balance -= amount;
	}
}
