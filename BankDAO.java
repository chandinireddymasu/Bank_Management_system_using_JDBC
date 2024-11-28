package com.bank.DAO;

import java.util.List;

import com.bank.model.BankCustomerDetails;

public interface BankDAO {
	
	List<BankCustomerDetails> getAllBankCustomerDetails();
	 int insertBankCustomerDetails(BankCustomerDetails bankCustomerDetails);
	 BankCustomerDetails getUserDetailsByUsingEmailOrMobileNumberAndPassword(String emailidorphonenumber,String password);
		int updateAmountUsingAccounNumber(double amount,long accountnumber);

}
