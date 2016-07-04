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
		return null;
	}

	public Account withdraw(int accountNumber, double amount)
			throws InvalidAccountException, InsufficientBalanceException {
		// TODO Auto-generated method stub
		return null;
	}

	public Account deposit(int accountNumber, double amount) throws InvalidAccountException {
		// TODO Auto-generated method stub
		return null;
	}

}
