package workshop.account.exception;

/*
 * Account의 잔액(balance)이 부족할때 사용되는 사용자정의 Exception 클래스입니다. * 
 */
public class InsufficientBalanceException extends Exception {
	private int currentBalance;
	
	public InsufficientBalanceException(String errMessage, int currentBalance) {
		super(errMessage);
		this.currentBalance = currentBalance;
	}
	
	public int getCurrentBalance() {
		return currentBalance;
	}
}
