/**
 * 
 */
package com.accounts.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.accounts.model.Account;
import com.accounts.model.Transaction;
import com.accounts.service.AccountService;

/**
 * @author Hp
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = AccountController.class)
public class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AccountService accountService;
	
	DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
	
	Transaction mockTransaction1 = new Transaction("10001", LocalDate.parse("20150120", formatter), "AUD", null, new BigDecimal("1202.50"), "Credit", null);
	
	Transaction mockTransaction2 = new Transaction("10002", LocalDate.parse("20000410", formatter), "SGD", null, new BigDecimal("690.20"), "Credit", null);
	
	Transaction mockTransaction3 = new Transaction("10003", LocalDate.parse("20180922", formatter), "AUD", null, new BigDecimal("3042.30"), "Credit", null);
	
	Transaction mockTransaction4 = new Transaction("10004", LocalDate.parse("20141215", formatter), "SGD", null, new BigDecimal("132.50"), "Credit", null);
	
	Transaction mockTransaction5 = new Transaction("10005", LocalDate.parse("20190323", formatter), "SGD", null, new BigDecimal("446.00"), "Credit", null);
	
	Account mockAccount1 = new Account("U001", "1023-4343-444", "AUSavings100", "Savings", LocalDate.now(), "AUD" , new BigDecimal("23003.30"), new ArrayList<Transaction>(Arrays.asList(mockTransaction1, mockTransaction3)));
	Account mockAccount2 = new Account("U001", "5453-6756-202", "SGSavings400", "Savings", LocalDate.now(), "SGD" , new BigDecimal("43223.50"), new ArrayList<Transaction>(Arrays.asList(mockTransaction2, mockTransaction4)));
	
	List<Account> mockAccounts = new ArrayList<Account>(Arrays.asList(mockAccount1, mockAccount2));
	
	List<Transaction> mockTransactions = new ArrayList<Transaction>(Arrays.asList(mockTransaction1, mockTransaction3));
	
	@Test
	public void retrieveAccountsForUser() throws Exception {

		Mockito.when(
				accountService.retrieveAccounts(Mockito.anyString())).thenReturn(mockAccounts);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/accounts/U001").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "[{\"userId\":\"U001\",\"accountNo\":\"1023-4343-444\",\"accountName\":\"AUSavings100\",\"accountType\":\"Savings\",\"balanceDate\":\"2019-04-04\",\"currency\":\"AUD\",\"availableBalance\":23003.30,\"transactions\":[{\"transactionId\":\"10001\",\"transactionDate\":\"2015-01-20\",\"currency\":\"AUD\",\"debitAmount\":null,\"creditAmount\":1202.50,\"transactionType\":\"Credit\",\"narrative\":null},{\"transactionId\":\"10003\",\"transactionDate\":\"2018-09-22\",\"currency\":\"AUD\",\"debitAmount\":null,\"creditAmount\":3042.30,\"transactionType\":\"Credit\",\"narrative\":null}]},{\"userId\":\"U001\",\"accountNo\":\"5453-6756-202\",\"accountName\":\"SGSavings400\",\"accountType\":\"Savings\",\"balanceDate\":\"2019-04-04\",\"currency\":\"SGD\",\"availableBalance\":43223.50,\"transactions\":[{\"transactionId\":\"10002\",\"transactionDate\":\"2000-04-10\",\"currency\":\"SGD\",\"debitAmount\":null,\"creditAmount\":690.20,\"transactionType\":\"Credit\",\"narrative\":null},{\"transactionId\":\"10004\",\"transactionDate\":\"2014-12-15\",\"currency\":\"SGD\",\"debitAmount\":null,\"creditAmount\":132.50,\"transactionType\":\"Credit\",\"narrative\":null}]}]";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void retrieveTransactionsForAccount() throws Exception {

		Mockito.when(
				accountService.retrieveTransactions(Mockito.anyString())).thenReturn(mockTransactions);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/account/1023-4343-444/transactions").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "[{\"transactionId\":\"10001\",\"transactionDate\":\"2015-01-20\",\"currency\":\"AUD\",\"debitAmount\":null,\"creditAmount\":1202.50,\"transactionType\":\"Credit\",\"narrative\":null},{\"transactionId\":\"10003\",\"transactionDate\":\"2018-09-22\",\"currency\":\"AUD\",\"debitAmount\":null,\"creditAmount\":3042.30,\"transactionType\":\"Credit\",\"narrative\":null}]";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
}
