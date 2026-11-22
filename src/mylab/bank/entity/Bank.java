package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class Bank {
	private List<Account> accounts = new ArrayList<>();
	private int nextAccountNumber = 1000;
	
	public Bank() {
		
	}
	
	public String createSavingsAccount(String ownName, double balance, double interest) {
		String acNum = "AC" + nextAccountNumber;
		SavingsAccount saveAc = new SavingsAccount(acNum, ownName, balance, interest);
		nextAccountNumber += 1;
		
		accounts.add(saveAc);
		// saveAc만해도 toString 자동 호출 
		System.out.println("저축 계좌가 생성되었습니다: " + saveAc);
		return acNum;		
	}
	
	public String createCheckingAccount(String ownName, double balance, double limit) {
		String acNum = "AC" + nextAccountNumber;
		CheckingAccount checkAc = new CheckingAccount(acNum, ownName, balance, limit);
		nextAccountNumber += 1;
		
		accounts.add(checkAc);
		System.out.println("체킹 계좌가 생성되었습니다: " + checkAc);
		return acNum;
		
	}
	
	public Account findAccount(String ac) throws AccountNotFoundException{
		for (Account a : accounts) {
			if (a.getAccountNumber().equals(ac))  {
				return a;
			}
		}
		throw new AccountNotFoundException("계좌번호 " + ac +"에 해당하는 계좌를 찾을 수 없습니다.");
	}
	
	public void deposit(String ac, double amount) throws AccountNotFoundException{
		for (Account a: accounts) {
			if (a.getAccountNumber().equals(ac)) {
				a.deposit(amount);
				return;
			}
		}
		throw new AccountNotFoundException("계좌번호 " + ac +"에 해당하는 계좌를 찾을 수 없습니다.");
	}
	
	public void withdraw(String ac, double amount) throws AccountNotFoundException, InsufficientBalanceException{
		for (Account a: accounts) {
			if (a.getAccountNumber().equals(ac)) {
				a.withdraw(amount);
				return;
			}
		}
		throw new AccountNotFoundException("계좌번호 " + ac +"에 해당하는 계좌를 찾을 수 없습니다.");
	}
	
	public void transfer(String acnum1, String acnum2, double amount) throws AccountNotFoundException, InsufficientBalanceException{
		Account ac1 = findAccount(acnum1);
		Account ac2 = findAccount(acnum2);
		
		ac1.withdraw(amount);
		ac2.deposit(amount);
		
		System.out.println(amount+"원이 " + acnum1+"에서 " + acnum2 + "로 송금되었습니다.");
	}
	
	public void printAllAccounts() {
		System.out.println("=== 모든 계좌 목록 ===");
		for (Account a: accounts) {
			System.out.println(a);
		}
		System.out.println("===================");
	}
	
	
	
}
