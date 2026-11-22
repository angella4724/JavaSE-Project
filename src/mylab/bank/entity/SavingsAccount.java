package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public class SavingsAccount extends Account{
	private double interest;
	
	public SavingsAccount(String acNum, String ownName, double balance, double interest) {
		super(acNum, ownName, balance);
		this.interest = interest;
	}
	
	public double getInterestRate() {
		return interest;
	}
	
	public void applyInterest(){
		double balance = super.getBalance();
		super.deposit(balance*interest) ;
		System.out.println("이자 "+balance*interest + "원이 적용되었습니다. 현재 잔액: "+ super.getBalance() + "원");

	}
	
	@Override
	public String toString() {
		return super.toString() + ", 이자율: " + interest*100 + "%";
	}
		
	
}
