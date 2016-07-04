package com.cg.demo.service;

import com.cg.demo.beans.Account;
import com.cg.demo.exceptions.InsufficientBalanceException;
import com.cg.demo.exceptions.InsufficientInitialAmountException;
import com.cg.demo.exceptions.InvalidAccountException;

public interface AccountService {
	Account createAccount(double balance) throws InsufficientInitialAmountException;
	
	
	Account showBalance(int accountNumber) throws InvalidAccountException;
	Account withdraw(int accountNumber, double amount)throws InvalidAccountException,InsufficientBalanceException; 
	Account deposit(int accountNumber, double amount)throws InvalidAccountException;
}

