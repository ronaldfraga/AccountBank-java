package model.entities;

import model.exceptions.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double wthLimit;
	
	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double wthLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.wthLimit = wthLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
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


	public Double getWthLimit() {
		return wthLimit;
	}

	public void setWthLimit(Double wthLimit) {
		this.wthLimit = wthLimit;
	}
	
	public void deposit(Double amount) {
		balance += amount;
	}
    
	public void withdraw(double amount) throws DomainException {
	    if (amount > wthLimit) {
	        throw new DomainException("The amount exceeds withdraw limit");
	    }

	    if (amount > balance) {
	        throw new DomainException("Not enough balance");
	    }

	    balance -= amount;
	}


	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Account Number: ").append(number).append("\n");
		sb.append("Account Holder: ").append(holder).append("\n");
		sb.append("Account Balance: ").append(String.format("%.2f", balance)).append("\n");
		sb.append("Withdraw Limit: ").append(String.format("%.2f", wthLimit)).append("\n\n");
		
		return sb.toString();
	}
	
}
