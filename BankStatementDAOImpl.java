package com.bank.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import com.bank.DAO.BankStatementDAO;
import com.bank.model.BankStatementDetails;

public class BankStatementDAOImpl implements BankStatementDAO {
	private static final String url="jdbc:mysql://localhost:3306/teca62projects?user=root&password=root";
	@Override
	public int insertBankStatement(BankStatementDetails bankStatementDetails) {
		String insert="insert into bank_statement(Date_Of_Transaction, Time_Of_Transcation, Transaction_Amount, Balance_Amount, Account_Number)values(?,?,?,?,?)";
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(insert);
			preparedStatement.setDate(1, Date.valueOf(LocalDate.now()));
			preparedStatement.setTime(2, Time.valueOf(LocalTime.now()));
			
			preparedStatement.setDouble(3, bankStatementDetails.getTransactionAmount());
			preparedStatement.setDouble(4, bankStatementDetails.getBalanceamount());
			preparedStatement.setLong(5, bankStatementDetails.getAccountnumber());
			
			return preparedStatement.executeUpdate();
			//return 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
			
		}
	}

}
