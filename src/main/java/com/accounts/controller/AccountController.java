/**
 * 
 */
package com.accounts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.model.Account;
import com.accounts.model.Transaction;
import com.accounts.service.AccountService;

/**
 * @author Hp
 *
 */
@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("/accounts/{userId}")
	public List<Account> retrieveAccountsForUser(@PathVariable String userId) {
		return accountService.retrieveAccounts(userId);
	}
	
	@GetMapping("/account/{accountId}/transactions")
	public List<Transaction> retrieveTransactionsForAccount(@PathVariable String accountId) {
		return accountService.retrieveTransactions(accountId);
	}
}
