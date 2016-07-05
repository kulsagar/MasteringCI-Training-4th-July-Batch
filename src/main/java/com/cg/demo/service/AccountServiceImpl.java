package com.cg.demo.service;

import com.cg.demo.beans.Account;
import com.cg.demo.exceptions.InsufficientBalanceException;
import com.cg.demo.exceptions.InsufficientInitialAmountException;
import com.cg.demo.exceptions.InvalidAccountException;

import co.cg.demo.repo.AccountRepo;

public class AccountServiceImpl implements AccountService {

	private AccountRepo repo;
	
	
	public AccountServiceImpl(AccountRepo repo) {
		super();
		this.repo = repo;
	}

	public Account createAccount(double balance) throws InsufficientInitialAmountException {
		
		if(balance < 500){
			throw new InsufficientInitialAmountException();
		}
		
		Account a = new Account(1);
		a.setBalance(balance);
		
		if(repo.save(a)){
			return a;
		}
		return null;
	}

	public Account showBalance(int accountNumber) throws InvalidAccountException {
		// TODO Auto-generated method stub
		Account a = repo.findById(accountNumber);
		if(a==null){
			throw new InvalidAccountException();
		}
		return a;
	}

	public Account withdraw(int accountNumber, double amount)
			throws InvalidAccountException, InsufficientBalanceException {
		if(amount <=0){
			throw new IllegalArgumentException();
		}
		Account a = repo.findById(accountNumber);
		if(a==null){
			throw new InvalidAccountException();
		}
		if(a.getBalance()<amount){
			throw new InsufficientBalanceException();
		}
		a.setBalance(a.getBalance()-amount);
		return a;
	}

	public Account deposit(int accountNumber, double amount) throws InvalidAccountException {
		// TODO Auto-generated method stub
		if(amount<=0){
			throw new IllegalArgumentException();
		}
		Account a = repo.findById(accountNumber);
		if(a==null){
			throw new InvalidAccountException();
		}
		a.setBalance(a.getBalance()+amount);
		return a;

	}

}
