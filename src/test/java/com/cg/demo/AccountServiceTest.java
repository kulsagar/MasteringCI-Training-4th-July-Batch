package com.cg.demo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import com.cg.demo.beans.Account;
import com.cg.demo.exceptions.InsufficientInitialAmountException;
import com.cg.demo.service.AccountService;
import com.cg.demo.service.AccountServiceImpl;

import co.cg.demo.repo.AccountRepo;


public class AccountServiceTest{

	//1. if valid amount is passed then system should create account successfully
	//2. System should show error if amount passed is less than 500.
	
	private AccountService service;
	@Mock private AccountRepo repo;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		service = new AccountServiceImpl(repo);
	}

	@Test
	public void accountShouldBeCreatedSuccessfullyWhenValidAmountIsPassed() throws InsufficientInitialAmountException{
		
		when(repo.save(new Account(1))).thenReturn(true);
		
		
		
		Account newAccount = service.createAccount(5000);
		assertEquals(5000.0+"", newAccount.getBalance()+"");
	}
}
