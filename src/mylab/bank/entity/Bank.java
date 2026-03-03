package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;
import mylab.bank.exception.*;

public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1000;
    }

    public void createSavingsAccount(String ownerName, double balance, double interestRate) {
        String accNo = "AC" + nextAccountNumber++;
        accounts.add(new SavingsAccount(accNo, ownerName, balance, interestRate));
        System.out.println("Saving(저축) 계좌가 생성되었습니다: 계좌번호: " + accNo + ", 소유자: " + ownerName + ", 잔액: " + balance + "원, 이자율: " + interestRate + "%");
    }

    public void createCheckingAccount(String ownerName, double balance, double withdrawalLimit) {
        String accNo = "AC" + nextAccountNumber++;
        accounts.add(new CheckingAccount(accNo, ownerName, balance, withdrawalLimit));
        System.out.println("체킹 계좌가 생성되었습니다: 계좌번호: " + accNo + ", 소유자: " + ownerName + ", 잔액: " + balance + "원, 출금 한도 : " + withdrawalLimit + "원");
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) return acc;
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }

    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        findAccount(accountNumber).deposit(amount);
    }

    public void withdraw(String accountNumber, double amount) 
            throws AccountNotFoundException, InsufficientBalanceException {
        findAccount(accountNumber).withdraw(amount);
    }

    public void transfer(String fromAccNo, String toAccNo, double amount) 
            throws AccountNotFoundException, InsufficientBalanceException {
        Account from = findAccount(fromAccNo);
        Account to = findAccount(toAccNo);
        // 출금과 입금 시 각각의 메시지가 출력됩니다.
        from.withdraw(amount);
        to.deposit(amount);
        System.out.println(amount + "원이 " + fromAccNo + "에서 " + toAccNo + "로 송금되었습니다.");
    }

    public void showAllAccounts() {
        for (Account acc : accounts) {
            System.out.println(acc);
        }
    }
}