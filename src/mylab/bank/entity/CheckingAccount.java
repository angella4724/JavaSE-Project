package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account{
	private double withdrawalLimit;
	
	public CheckingAccount(String acNum, String ownName, double balance, double withLim) {
		super(acNum, ownName, balance);
		this.withdrawalLimit = withLim;
	}
	
	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}
	
	public void withdraw(double withdrawM) throws InsufficientBalanceException{
		if(withdrawM > this.withdrawalLimit) {
			//Exception을 강제로 발생시킴
			throw new WithdrawalLimitExceededException("출금 한도를 초과했습니다. 한도: " + this.withdrawalLimit); 
		}
		super.withdraw(withdrawM);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", 출금 한도: " + withdrawalLimit + "원";
	}
		
	
}
