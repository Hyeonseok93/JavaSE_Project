package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * (interestRate / 100);
        // deposit()을 호출하면 입금 메시지가 먼저 출력됩니다.
        deposit(interest);
        System.out.println("이자 " + interest + "원이 적용되었습니다. 현재 잔액: " + getBalance() + "원");
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > getBalance()) {
            throw new InsufficientBalanceException("잔액이 부족합니다.");
        }
        setBalance(getBalance() - amount);
        System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + getBalance() + "원");
    }

    @Override
    public String toString() {
        return super.toString() + ", 이자율: " + interestRate + "%";
    }
}