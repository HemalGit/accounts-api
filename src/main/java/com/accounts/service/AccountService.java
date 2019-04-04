/**
 * 
 */
package com.accounts.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.accounts.model.Account;
import com.accounts.model.Transaction;

/**
 * @author Hp
 *
 */
@Component
public class AccountService {

	private static List<Account> accounts = new ArrayList<Account>();
	
	static {
		DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
		
		Transaction transaction1 = new Transaction("10001", LocalDate.parse("20150120", formatter), "AUD", null, new BigDecimal("1202.50"), "Credit", null);
		
		Transaction transaction2 = new Transaction("10002", LocalDate.parse("20000410", formatter), "SGD", null, new BigDecimal("690.20"), "Credit", null);
		
		Transaction transaction3 = new Transaction("10003", LocalDate.parse("20180922", formatter), "AUD", null, new BigDecimal("3042.30"), "Credit", null);
		
		Transaction transaction4 = new Transaction("10004", LocalDate.parse("20141215", formatter), "SGD", null, new BigDecimal("132.50"), "Credit", null);
		
		Transaction transaction5 = new Transaction("10005", LocalDate.parse("20190323", formatter), "SGD", null, new BigDecimal("446.00"), "Credit", null);
		
		Account account1 = new Account("U001", "1023-4343-444", "AUSavings100", "Savings", LocalDate.now(), "AUD" , new BigDecimal("23003.30"), new ArrayList<Transaction>(Arrays.asList(transaction1, transaction3)));
		
		Account account2 = new Account("U001", "5453-6756-202", "SGSavings400", "Savings", LocalDate.now(), "SGD" , new BigDecimal("43223.50"), new ArrayList<Transaction>(Arrays.asList(transaction2, transaction4)));
		
		Account account3 = new Account("U002", "5656-9098-334", "SGCurrentW32", "Current", LocalDate.now(), "SGD" , new BigDecimal("6060.40"), new ArrayList<Transaction>(Arrays.asList(transaction5)));
		
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
	}
	
	public List<Account> retrieveAllAccounts() {
		return accounts;
	}
	
	public List<Account> retrieveAccounts(String userId) {
		List<Account> userAccounts = new ArrayList<Account>();
		
		for (Account account: accounts) {
			if (account.getUserId().equals(userId)) {
				userAccounts.add(account);
			}
		}
		
		return userAccounts;
	}
	
	public Account retrieveAccount(String accounNo) {
		
		for (Account account: accounts) {
			if (account.getAccountNo().equals(accounNo)) {
				return account;
			}
		}
		
		return null;
	}
	
	public List<Transaction> retrieveTransactions(String accountNo) {
		Account account = retrieveAccount(accountNo);
		
		if (account == null) {
			return null;
		}
		
		return account.getTransactions();
	}
	
}
