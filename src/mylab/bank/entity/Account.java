package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public class Account {
	private String accountNumber;
	private String ownerName;
	private double balance;
	
	public Account(String acNum, String ownName, double balance) {
		this.accountNumber = acNum;
		this.ownerName = ownName;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public double getBalance() {
		return balance;
	}
	
	public void deposit(double depositM) {
		this.balance += depositM;
		System.out.println(depositM+"원이 입금되었습니다. 현재 잔액: "+ balance + "원");

	}
	
	public void withdraw(double withdrawM) throws InsufficientBalanceException {
		if(withdrawM > this.balance) {
			//Exception을 강제로 발생시킴
			throw new InsufficientBalanceException("잔액이 부족합니다. 잔액: ", this.balance); 
		}
		this.balance -= withdrawM;
		System.out.println(withdrawM+"원이 출금되었습니다. 현재 잔액: "+ balance + "원");

	}
	
	@Override
	public String toString() {
		return "계좌번호: " + accountNumber + ", 소유자: " + ownerName + ", 잔액: " + balance + "원";
	}

	
}
