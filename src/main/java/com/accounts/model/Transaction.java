/**
 * 
 */
package com.accounts.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Hp
 *
 */
public class Transaction {
	
	private String transactionId;
	private LocalDate transactionDate;
	private String currency;
	private BigDecimal debitAmount;
	private BigDecimal creditAmount;
	private String transactionType;
	private String narrative;
	
	public Transaction(String transactionId, LocalDate transactionDate,
			String currency, BigDecimal debitAmount, BigDecimal creditAmount,
			String transactionType, String narrative) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.currency = currency;
		this.debitAmount = debitAmount;
		this.creditAmount = creditAmount;
		this.transactionType = transactionType;
		this.narrative = narrative;
	}

	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the transactionDate
	 */
	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
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
	 * @return the debitAmount
	 */
	public BigDecimal getDebitAmount() {
		return debitAmount;
	}
	
	/**
	 * @param debitAmount the debitAmount to set
	 */
	public void setDebitAmount(BigDecimal debitAmount) {
		this.debitAmount = debitAmount;
	}

	/**
	 * @return the creditAmount
	 */
	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	/**
	 * @param creditAmount the creditAmount to set
	 */
	public void setCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @return the narrative
	 */
	public String getNarrative() {
		return narrative;
	}

	/**
	 * @param narrative the narrative to set
	 */
	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}

	@Override
	public String toString() {
		return String.format("Transaction [transactionId=%s, transactionDate=%s, currency=%s, debitAmount=%s, creditAmount=%s, transactionType=%s, narrative=%s]", 
				transactionId, transactionDate, currency, debitAmount, creditAmount, transactionType, narrative);
	}
}
