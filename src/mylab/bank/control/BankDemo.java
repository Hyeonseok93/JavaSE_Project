package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        BankDemo demo = new BankDemo();
        demo.run();
    }

    public void run() {
        Bank bank = new Bank();

        System.out.println("=== 계좌 생성 ===");
        bank.createSavingsAccount("홍길동", 10000.0, 3.0);
        bank.createCheckingAccount("김철수", 20000.0, 5000.0);
        bank.createSavingsAccount("이영희", 30000.0, 2.0);

        System.out.println("\n=== 모든 계좌 목록 ===");
        bank.showAllAccounts();
        System.out.println("===================\n");

        System.out.println("=== 입금/출금 테스트 ===");
        executeDeposit(bank, "AC1000", 5000.0);
        executeWithdraw(bank, "AC1001", 3000.0);
        
        System.out.println("\n=== 이자 적용 테스트 ===");
        executeApplyInterest(bank, "AC1000");

        System.out.println("\n=== 계좌 이체 테스트 ===");
        executeTransfer(bank, "AC1002", "AC1001", 5000.0);
        
        System.out.println("\n=== 모든 계좌 목록 ===");
        bank.showAllAccounts();
        System.out.println("===================");

        System.out.println("\n=== 예외 발생 테스트 ===");
        executeWithdraw(bank, "AC1001", 10000.0);
        executeWithdraw(bank, "AC1001", 20000.0);
        executeFindAccount(bank, "AC9999"); 
    }

    private void executeWithdraw(Bank bank, String accNo, double amount) {
        try {
            bank.withdraw(accNo, amount);
        } catch (WithdrawalLimitExceededException e) {
            System.out.println("예외 발생: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }

    private void executeDeposit(Bank bank, String accNo, double amount) {
        try {
            bank.deposit(accNo, amount);
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }

    private void executeTransfer(Bank bank, String from, String to, double amount) {
        try {
            bank.transfer(from, to, amount);
        } catch (InsufficientBalanceException | AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }

    private void executeApplyInterest(Bank bank, String accNo) {
        try {
            Account acc = bank.findAccount(accNo);
            if (acc instanceof SavingsAccount) {
                ((SavingsAccount) acc).applyInterest();
            }
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }

    private void executeFindAccount(Bank bank, String accNo) {
        try {
            bank.findAccount(accNo);
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}