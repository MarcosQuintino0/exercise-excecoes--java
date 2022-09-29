package model.entities;

import model.exception.DomainException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) throws DomainException {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
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

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public void deposit(Double amount) {
		amount += balance;
	}

	public void withdraw(Double amount) throws DomainException {
		validateWithdraw(amount); //antes de efetuar o saque eu chamo a validação se passar tudo bem se nao passar lanca exeção
		balance -= amount;
	}

	private void validateWithdraw(Double amount) throws DomainException {
		if (amount > getWithdrawLimit()) {
			throw new DomainException("Erro de saque: A quantia excede o limite de saque");
		} 
		if (amount > getBalance()) {
			throw new DomainException("Erro de saque: Saldo insuficiente");
		}
	}

}
