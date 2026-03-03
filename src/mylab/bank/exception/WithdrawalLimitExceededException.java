package mylab.bank.exception;

public class WithdrawalLimitExceededException extends InsufficientBalanceException {
	private static final long serialVersionUID = 1L;

	public WithdrawalLimitExceededException(String message) {
        super(message);
    }
}