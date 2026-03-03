package workshop.account.control;

import workshop.account.entity.Account;

public class AccountTest {
	public static void main(String[] args) {
		// Account 객체 생성
		Account account = new Account();
		// 고객 번호: A1100, 계좌번호: 221-22-3477, 잔액: 100,000
		account.setCustId("A1100");
		account.setAcctId("221-22-3477");
		account.deposit(100000);
		
		System.out.println("고객번호: " + account.getCustId());
		System.out.println("계좌번호: " + account.getAcctId());
		System.out.println("잔액: " + account.getBalance());
		
		Account account2 = new Account("A1200", "321-22-3477");
		account.deposit(15000);
		account.withdraw(10000);
		
		System.out.println(account2);
		
		// Account의 부모 클래스인 Object 클래스의 toString() 메서드 호출
		System.out.println(account2.toString());
	}
}
