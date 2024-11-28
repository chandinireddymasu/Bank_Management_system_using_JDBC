package com.bank.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.BankCustomerDetails;

public class BankDAOImpl implements BankDAO {
	private Connection connection;
	private static final String url="jdbc:mysql://localhost:3306/teca62projects?user=root&password=root";
	private static final String select="select * from bank_customer_Details";
	public static final String insert="insert into bank_customer_details(First_Name,Last_Name,Email_Id,Password,Mobile_Number,Aadhar_Number,Gender,Address,Date_Of_Birth,Account_Number,Amount) values(?,?,?,?,?,?,?,?,?,?,?)";
	
	public List<BankCustomerDetails> getAllBankCustomerDetails() {
	 
		List<BankCustomerDetails>listBankCustomerDetails = new ArrayList<BankCustomerDetails>();
		
	try {
		 connection=DriverManager.getConnection(url);
		PreparedStatement ps=connection.prepareStatement(select);
       ResultSet resultSet  =ps.executeQuery();
       
       
       if(resultSet.isBeforeFirst()) {
    	   while(resultSet.next()) {
    		   BankCustomerDetails bankCustomerDetails= new BankCustomerDetails();
    		   bankCustomerDetails.setAadharnumber(resultSet.getLong("Aadhar_Number"));
    		   bankCustomerDetails.setEmailid(resultSet.getString("Email_Id"));
    		   bankCustomerDetails.setPassword(resultSet.getString("Password"));
    		   bankCustomerDetails.setMobilenumber(resultSet.getLong("Mobile_Number"));
    		   listBankCustomerDetails.add(bankCustomerDetails);
    		   
    		   
    	   }
    	   return listBankCustomerDetails;
       }
       else {
    	   return null;
       }
	}
	catch(SQLException e ) {
		e.printStackTrace();
		return null;
	}
	}

	@Override
	public int insertBankCustomerDetails(BankCustomerDetails bankCustomerDetails) {
		
	 try {
		  connection=DriverManager.getConnection(url);
		 PreparedStatement preparedStatement=connection.prepareStatement(insert);
		 preparedStatement.setString(1, bankCustomerDetails.getFirstname());
		 preparedStatement.setString(2, bankCustomerDetails.getLastname());
		 preparedStatement.setString(3, bankCustomerDetails.getEmailid());
		 preparedStatement.setString(4, bankCustomerDetails.getPassword());
		 preparedStatement.setLong(5, bankCustomerDetails.getMobilenumber());
		 preparedStatement.setLong(6, bankCustomerDetails.getAadharnumber());
		 preparedStatement.setString(7, bankCustomerDetails.getGender());
		 preparedStatement.setString(8, bankCustomerDetails.getAddress());
		 LocalDate dateofbirth=bankCustomerDetails.getDateofbirth();
		 preparedStatement.setDate(9, Date.valueOf(dateofbirth));
		 preparedStatement.setLong(10, bankCustomerDetails.getAccountnumber());
		 preparedStatement.setDouble(11, bankCustomerDetails.getAmount());
		 
		 int result= preparedStatement.executeUpdate();
		 return 1;
	 }catch(SQLException e) {
		 e.printStackTrace();
		 return 0;
	 }
	
		
	}

	@Override
	public  BankCustomerDetails getUserDetailsByUsingEmailOrMobileNumberAndPassword(String emailidorphonenumber, String password) 
	{
		// TODO Auto-generated method stub
		String login="select * from bank_customer_details where (Email_Id=? or Mobile_Number=?) and password=?";
		try 
		{
			connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(login);
			preparedStatement.setString(1, emailidorphonenumber);
			preparedStatement.setString(2, emailidorphonenumber);
			preparedStatement.setString(3, password);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if (resultSet.next()) 
			{
				BankCustomerDetails bankCustomerDetails=new BankCustomerDetails();
				bankCustomerDetails.setFirstname(resultSet.getString("First_Name"));
				bankCustomerDetails.setLastname(resultSet.getString("Last_Name"));
				bankCustomerDetails.setGender(resultSet.getString("Gender"));
				bankCustomerDetails.setAmount(resultSet.getDouble("Amount"));
				bankCustomerDetails.setAccountnumber(resultSet.getLong("Account_Number"));
				

				return bankCustomerDetails;
			}
			else
			{
				return null;
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int updateAmountUsingAccounNumber(double amount,long accountnumber) {
		String update="update bank_customer_details set Amount=? where Account_Number=?";
		try {
			connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(update);
			preparedStatement.setDouble(1,amount);
			preparedStatement.setLong(2, accountnumber);
			return preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
}
	
 

