package modes.entites;

import modes.exceptions.DomainException;

public class Account {
	Integer number;
	String holder;
	Double balance = 0.0;
	Double withdrawLimit;
	
	public Account(int number, String holder, double balance, double withdrawLimit) {
		this.number  = number;
		this.holder = holder;
		this.deposit(balance);
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit (double amount) {
		this.balance += amount;
	}
	
	public void withdraw (double amount){
		if (this.withdrawLimit < amount) {
			throw new DomainException("Exceeded withdraw limit!!");
		}else if (this.balance < amount) {
			throw new DomainException("Insufficent funds!!");
		}else {
			this.balance -= amount;
		}
	}
		
	@Override
	public String toString() {
		return "New balance:  " + this.balance;
	}
	
}
