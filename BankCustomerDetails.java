package com.bank.model;

import java.time.LocalDate;

public class BankCustomerDetails {
	private int id;
	private String firstname;
	private String lastname;
	private String emailid;
	private String  password;
	private long mobilenumber;
	private long aadharnumber;
	private String gender;
	private String address;
	private double amount;
	private long accountnumber;
	private LocalDate dateofbirth;
	public BankCustomerDetails() {
		
	}
	
	public BankCustomerDetails(int id, String firstname, String lastname, String emailid, String password,
			long mobilenumber, long aadharnumber, String gender, String address, double amount, long accountnumber,
			LocalDate dateofbirth) {

		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailid = emailid;
		this.password = password;
		this.mobilenumber = mobilenumber;
		this.aadharnumber = aadharnumber;
		this.gender = gender;
		this.address = address;
		this.amount = amount;
		this.accountnumber = accountnumber;
		this.dateofbirth = dateofbirth;
	}
	@Override
	public String toString() {
		return "BankCustomerDetails [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", emailid="
				+ emailid + ", password=" + password + ", mobilenumber=" + mobilenumber + ", aadharnumber="
				+ aadharnumber + ", gender=" + gender + ", address=" + address + ", amount=" + amount
				+ ", accountnumber=" + accountnumber + ", dateofbirth=" + dateofbirth + "]";
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmailid() {
		return emailid;
	}


	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public long getMobilenumber() {
		return mobilenumber;
	}


	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}


	public long getAadharnumber() {
		return aadharnumber;
	}


	public void setAadharnumber(long aadharnumber) {
		this.aadharnumber = aadharnumber;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public long getAccountnumber() {
		return accountnumber;
	}


	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}


	public LocalDate getDateofbirth() {
		return dateofbirth;
	}


	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	
	
	
	
	

}
