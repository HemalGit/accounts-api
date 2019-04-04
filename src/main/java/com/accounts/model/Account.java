/**
 * 
 */
package com.accounts.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Hp
 *
 */
public class Account {

	private String userId;
	private String accountNo;
	private String accountName;
	private String accountType;
	private LocalDate balanceDate;
	private String currency;
	private BigDecimal availableBalance;
	private List<Transaction> transactions;
	
	public Account(String userId, String accountNo, String accountName, String accountType,
			LocalDate balanceDate, String currency, BigDecimal availableBalance,
			List<Transaction> transactions) {
		super();
		this.userId = userId;
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.accountType = accountType;
		this.balanceDate = balanceDate;
		this.currency = currency;
		this.availableBalance = availableBalance;
		this.transactions = transactions;
	}

	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}


	/**
	 * @return the accountNo
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * @param accountNo the accountNo to set
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * @return the balanceDate
	 */
	public LocalDate getBalanceDate() {
		return balanceDate;
	}

	/**
	 * @param balanceDate the balanceDate to set
	 */
	public void setBalanceDate(LocalDate balanceDate) {
		this.balanceDate = balanceDate;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the availableBalance
	 */
	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}

	/**
	 * @param availableBalance the availableBalance to set
	 */
	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}

	/**
	 * @return the transactions
	 */
	public List<Transaction> getTransactions() {
		return transactions;
	}

	/**
	 * @param transactions the transactions to set
	 */
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return String.format("Account [userId=%s, accountNo=%s, accountName=%s, accountType=%s, balanceDate=%s, currency=%s, availableBalance=%s, transactions=%s]", 
				userId, accountNo, accountName, accountType, balanceDate, currency, availableBalance, transactions);
	}
	
}
