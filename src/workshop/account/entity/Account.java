package workshop.account.entity;

public class Account {
	private String custId;
	private String acctId;
	private int balance;
	
	// Default Constructor
	public Account() {
		System.out.println(this.getClass().getName() + " 기본 생성자 호출됨");
	}
	
	// Constructor Overloading 중복 정의
	public Account(String custId, String acctId) {
//		this.custId = custId;
//		this.acctId = acctId;
		setCustId(custId);
		setAcctId(acctId);
	}
	
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
		this.balance += amount;
	}
	
	// 출금
	public void withdraw(int amount) {
		if(amount > balance) {
			System.out.println("잔액 부족");
			return;
		}
		this.balance -= amount;
	}
}
