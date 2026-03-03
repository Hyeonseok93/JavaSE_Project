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

        try {
            System.out.println("=== 입금/출금 테스트 ===");
            bank.deposit("AC1000", 5000.0);
            bank.withdraw("AC1001", 3000.0);
            
            System.out.println("\n=== 이자 적용 테스트 ===");
            Account acc = bank.findAccount("AC1000");
            if (acc instanceof SavingsAccount) {
                ((SavingsAccount) acc).applyInterest();
            }

            System.out.println("\n=== 계좌 이체 테스트 ===");
            bank.transfer("AC1002", "AC1001", 5000.0);
            
            System.out.println("\n=== 모든 계좌 목록 ===");
            bank.showAllAccounts();
            System.out.println("===================");

            System.out.println("\n=== 예외 발생 테스트 ===");
            // 중복된 한도 초과 테스트는 Sample Run에 맞춰 2번 수행할 수 있습니다.
            bank.withdraw("AC1001", 10000.0); 
            
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.withdraw("AC1001", 10000.0); 
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999");
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}