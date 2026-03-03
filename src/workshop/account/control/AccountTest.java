package workshop.account.control;

import workshop.account.entity.Account;

public class AccountTest {
	public static void main(String[] args) {
		// Account °´Ã¼ »ı¼º
		Account account = new Account();
		// °í°´ ¹øÈ£: A1100, °èÁÂ¹øÈ£: 221-22-3477, ÀÜ¾×: 100,000
		account.setCustId("A1100");
		account.setAcctId("221-22-3477");
		account.deposit(100000);
		
		System.out.println("°í°´¹øÈ£: " + account.getCustId());
		System.out.println("°èÁÂ¹øÈ£: " + account.getAcctId());
		System.out.println("ÀÜ¾×: " + account.getBalance());
	}
}
