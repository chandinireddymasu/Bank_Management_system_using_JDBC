package com.bank.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class BankStatementDetails {
	private int id;
	private LocalDate dateoftransaction;
	private  LocalTime timeoftransaction;
	private  double transactionamount;
	private  double balanceamount;
	private long accountnumber;
	
	
	public BankStatementDetails() {
	
		
	}
	public BankStatementDetails(int id, LocalDate dateoftransaction, LocalTime timeoftransaction,
			double transactionAmount, double balanceamount, long accountnumber) {
		super();
		this.id = id;
		this.dateoftransaction = dateoftransaction;
		this.timeoftransaction = timeoftransaction;
		this.transactionamount = transactionamount;
		this.balanceamount = balanceamount;
		this.accountnumber = accountnumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDateoftransaction() {
		return dateoftransaction;
	}
	public void setDateoftransaction(LocalDate dateoftransaction) {
		this.dateoftransaction = dateoftransaction;
	}
	public LocalTime getTimeoftransaction() {
		return timeoftransaction;
	}
	public void setTimeoftransaction(LocalTime timeoftransaction) {
		this.timeoftransaction = timeoftransaction;
	}
	public double getTransactionAmount() {
		return transactionamount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionamount = transactionAmount;
	}
	public double getBalanceamount() {
		return balanceamount;
	}
	public void setBalanceamount(double balanceamount) {
		this.balanceamount = balanceamount;
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	
	

}
