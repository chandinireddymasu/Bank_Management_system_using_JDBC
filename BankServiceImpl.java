package com.bank.service;

import java.util.Scanner;

import com.bank.DAO.BankDAO;
import com.bank.DAO.BankDAOImpl;
import com.bank.DAO.BankStatementDAO;
import com.bank.model.BankCustomerDetails;
import com.bank.model.BankStatementDetails;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


import com.bank.DAO.BankStatementDAO;


import com.bank.model.BankStatementDetails;

public class BankServiceImpl implements BankService
{
	
	BankDAO bankDAO=new BankDAOImpl();
    
	
	Scanner scanner=new Scanner(System.in);
	Random random=new Random();
	BankCustomerDetails loginpersondetails=new BankCustomerDetails();
	BankStatementDAO bankStatementDAO=new BankStatementDAOImpl();
	@Override
	public void toSleep(String name) 
	{
		for(int i=0;i<name.length();i++)  
		{
			System.out.print(name.charAt(i));
			try 
			{
				Thread.sleep(1 );
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}	
	}
	//Override
	public void userLogin()
	{
		System.out.println("enter your email or phone number");
		String emailOrMobileNumber=scanner.next();
		System.out.println("enter password");
		String password=scanner.next();
		loginpersondetails=bankDAO.getUserDetailsByUsingEmailOrMobileNumberAndPassword(emailOrMobileNumber, password);
		
		if(loginpersondetails != null)
		{
			int otp=random.nextInt(10000);
//			
			if(otp>1000 && otp<=9999) 
			{
				otp+=1000;
//				
				System.out.println("Your OTP:"+otp);
				
				System.out.println("Enter OTP To  Login");
				int cotp=scanner.nextInt();
				if(otp==cotp)
				{
					
					if(loginpersondetails.getGender().equalsIgnoreCase("male"))
					{
						System.out.println("😊😊 Heloo Mr: "+loginpersondetails.getFirstname()+ " " +loginpersondetails.getLastname());
						
					}
					else if(loginpersondetails.getGender().equalsIgnoreCase("female")) {
						System.out.println("😊😊 Heloo Miss: "+loginpersondetails.getFirstname()+" "+loginpersondetails.getLastname());	
					}
					else
					{
						System.out.println("😊😊 Heloo Dear: "+loginpersondetails.getFirstname()+" "+loginpersondetails.getLastname());
					}
					userFunctionalDetails();
					
				}
				else
				{
					System.out.println("Invalid OTP");
				}
			}
			
		}
		else
		{
			System.out.println("Invalid Credential");
		}
	}
	
	@Override
	public void userRegistration() 
	{
		BankDAOImpl bd=new BankDAOImpl();
		BankCustomerDetails bankCustomerDetails=new BankCustomerDetails();
		List<BankCustomerDetails> allbankcustomerdetails=bd.getAllBankCustomerDetails();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your First Name");
		String firstname=sc.next();
		
		bankCustomerDetails.setFirstname(firstname);
		System.out.println("Enter your Last Name");
		String lastname=sc.next();
		bankCustomerDetails.setLastname(lastname);
		
		
		System.out.println("Enter your Email Id");
		String emailid;
		while(true) 
		{
			emailid=sc.next();
		
		
		
		    if(validateEmailId(emailid)) 
		    {
		    	boolean checkemail=true;
			    for (BankCustomerDetails bankCustomerDetail : allbankcustomerdetails) 
			    {
			    	if(bankCustomerDetail.getEmailid().equals(emailid)) 
			    	{
			    		checkemail=false;
				    }
				
			    }
			    if(checkemail) 
			    {
			    	break;
			    }
			    else 
			    {
			    	System.out.println("email is already in use");
				
			    }
		    }
		    else 
		    {
		    	System.out.println("enter valid email id");
				

		    }
		}
		bankCustomerDetails.setEmailid(emailid);
		System.out.println("Enter your Password");
		String password;
		
		while(true) 
		{
		   password=sc.next();
			if(validatePassword(password))
			{
				 boolean checkpassword=true;
				for (BankCustomerDetails bcd : allbankcustomerdetails) 
				{
					if(bcd.getPassword().equalsIgnoreCase(password)) 
					{
						checkpassword=false;
					}
				}
			    if(checkpassword) 
			    {
			    	break;
			    }
			    else 
			    {
			    	System.out.println("password is already in use");
			    }
		    }
			else 
			{
				System.out.println("Password should contain 4 characters");
		    }
		}
	
		System.out.println("Enter your confirm password");
		while(true) 
		{
			String cpassword=sc.next();
		   if(validateConfirmPassword(cpassword, password))
		   {
			   break;
		   }
		   else 
		   {
			   System.out.println("Enter the valid password");
		   }
		}
		
		bankCustomerDetails.setPassword(password);
		System.out.println("Enter your mobilenumber");
		long mobilenumber;
		
		while(true) 
		{
			mobilenumber=sc.nextLong();
			if(validateMobileNumber(mobilenumber)) 
			{
				boolean checkmobnumber=true;
			    for (BankCustomerDetails bankCustomerDetail : allbankcustomerdetails) 
			    {
			    	if(bankCustomerDetail.getMobilenumber()==mobilenumber) 
			    	{
			    		checkmobnumber=false;
				    }
			    }
			    if(checkmobnumber) 
			    {
			    	break;
			    }
			    else 
			    {
			    	System.out.println("mobile number is already in use");
			    }
		    }
		    else 
		    {
		    	System.out.println("enter 10 digit mobile number and number starts with 9 or 8 or 7 or 6");
			
		    }
		}
		
		bankCustomerDetails.setMobilenumber(mobilenumber);
		System.out.println("Enter your Aadhar Number");
		long adharnumber;
		while(true) 
		{
			adharnumber=sc.nextLong();
			if(validateAdharNumber(adharnumber)) 
			{
				boolean checkaadharnumber=true;
				for (BankCustomerDetails bankCustomerDetail : allbankcustomerdetails) 
				{
					if(bankCustomerDetail.getAadharnumber()==adharnumber) 
					{
						checkaadharnumber=false;
					}
				}
				if(checkaadharnumber) 
				{
					break;
				}
				else 
				{
					System.out.println("aadhar number is already in use");
				}
			}
			else 
			{
				System.out.println("enter 12 digit aadhar number");
				
			}
		}
		bankCustomerDetails.setAadharnumber(adharnumber);
		System.out.println("Enter your Gender (male/female/others)");
		String gender;
		while(true)
		{
			gender=sc.next();
			if(validateGender(gender)) 
			{
				break;
			}
			else 
			{
				System.out.println("enter the valid gender");
				
			}
		}
		bankCustomerDetails.setGender(gender);
		System.out.println("Enter your Address");
		String address=sc.next();
		bankCustomerDetails.setAddress(address);
		
		System.out.println("Enter your date of birth (yyyy-mm-dd)");
		String  dateofbirth=sc.next();
		bankCustomerDetails.setDateofbirth(LocalDate.parse(dateofbirth));
		
		
		Random random=new Random();
		int accountnumber=random.nextInt(10000000);
		if(accountnumber<10000000) 
		{
			accountnumber+=10000000;
		}
		bankCustomerDetails.setAccountnumber(accountnumber);
		
		//int customerDetails=bankDAO.insertBankCustomerDetails(bankCustomerDetails);
		System.out.println("Enter Amount");
		double amount=sc.nextDouble();
		bankCustomerDetails.setAmount(amount);
		int customerDetails=bankDAO.insertBankCustomerDetails(bankCustomerDetails);
		if(customerDetails!=0)
		{
			
			if(gender.equalsIgnoreCase("male"))
			{
				System.out.println("😊😊 Heloo Mr: "+firstname+" "+lastname);
				System.out.println("Your account successfully opened in teca 62 bank");
				System.out.println("Your account number is: "+accountnumber);
				System.out.println("Registration is successfull");
			}
			else if(gender.equalsIgnoreCase("female")) 
			{
				System.out.println("😊😊 Heloo Miss: "+firstname+" "+lastname);
				System.out.println("Your account successfully opened in teca 62 bank");
				System.out.println("Your account number is: "+accountnumber);
				System.out.println("Registration is successfull");
				
			}
			else 
			{
				System.out.println("😊😊 Heloo Dear: "+firstname+" "+lastname);
				System.out.println("Your account successfully opened in teca 62 bank");
				System.out.println("Your account number is: "+accountnumber);
				System.out.println("Registration is successfull");
				
			}
		}
		else
		{
			System.out.println("Server Error 500");
		}
		
	}
	public static boolean validateEmailId(String emailid) 
	{
		int countDigit=0;
		for(int i=0;i<=emailid.length()-1;i++)
		{
			char ch=emailid.charAt(i);
			if(Character.isDigit(ch)) 
			{
				countDigit++;
			}
		}
		if(countDigit>1 && emailid.contains("@gmail.com") && emailid.charAt(0)>='a' && emailid.charAt(0)<='z')
		{ 
			return true;
			
		}
		return false;
	}
	
	
	public static boolean validatePassword(String password) 
	{
		if(password.length()==4)
		{
			return true;																																																
				
	    }
		return false;
	}
	
	
	
	public static boolean validateConfirmPassword(String cpassword,String password) 
	{
		if(password.equals(cpassword)) 
		{
			return true;
		}
		return false;
		
	}
	
	public static boolean validateMobileNumber(long mobilenumber) 
	{
		int count=0;
		long temp=mobilenumber;
		while(mobilenumber!=0) 
		{
			count++;
			mobilenumber=mobilenumber/10;
		}
		while(temp>=10)
		{
			temp=temp/10;
		}
		if(count==10 && temp==9 || temp==8 || temp==7 ) 
		{
			return true;
		}
		return false;
		
	} 
	
	
	public static boolean validateGender(String gender) 
	{
		if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("others"))
		{
			return true;
		}
		return false;
		
	}
	
	
	private boolean validateAdharNumber(long adharnumber) 
	{
		int count=0;
		while(adharnumber!=0) 
		{
			count++;
			adharnumber=adharnumber/10;
		}
		if(count==12) 
		{
			return true;
		}
		return false;
	}
	@Override
	public void userFunctionalDetails() 
	{
		boolean status=true;
		while(status)
		{
			System.out.println("Enter \n1.For Credit\n2.For Debit\n3.To Check Balance \n4.To Check Statements");
			
			switch (scanner.nextInt()) 
			{
			case 1:
				System.out.println("Credit");
				credit();
				break;
			case 2:
				System.out.println("Debit");
				debit();
				break;
			case 3:
				System.out.println("To Check Balance");
				break;
			case 4:
				System.out.println("Check Statement");
				break;
			default:
				System.out.println("Invalid Option");
				break;
			}
			System.out.println("Do You Want To Continue");
			if(scanner.next().equalsIgnoreCase("yes"))
			{
				status=true;
			}
			else
			{
				System.out.println("Thank You Visit Again....!!!");
				status=false;
				
			}
		}
		
	 }
	public void debit()
	{
		System.out.println("enter amount");
		double userenteramount=scanner.nextDouble();
		if(userenteramount>0)
		{
			double databaseamount=loginpersondetails.getAmount();
			if(databaseamount>=userenteramount)
			{
				System.out.println("ok");
				double sub=databaseamount-userenteramount;
				long accountnumber=loginpersondetails.getAccountnumber();
				if(bankDAO.updateAmountUsingAccounNumber(sub, accountnumber)!=0)
				{
					BankStatementDetails bankStatementDetails=new BankStatementDetails();
					bankStatementDetails.setAccountnumber(accountnumber);
					bankStatementDetails.setBalanceamount(sub);
					bankStatementDetails.setTransactionAmount(userenteramount);
					bankStatementDAO.insertBankStatement(bankStatementDetails);
					System.out.println("Amount debited successfully");
				}
				else
				{
					System.out.println("Server Error 500");
				}
				
			}
			else
			{
				System.out.println("Insuffient Balance");
			}
		}
		else
		{
			System.out.println("invalid amount");
		}
	}
	public void credit()
	{
		System.out.println("enter amount");
		double userenteramount=scanner.nextDouble();
		if(userenteramount>0)
		{
			double databaseamount=loginpersondetails.getAmount();
			if(databaseamount>=userenteramount)
			{
				System.out.println("ok");
				double add=databaseamount+userenteramount;
				long accountnumber=loginpersondetails.getAccountnumber();
				if(bankDAO.updateAmountUsingAccounNumber(add, accountnumber)!=0)
				{
					BankStatementDetails bankStatementDetails=new BankStatementDetails();
					bankStatementDetails.setAccountnumber(accountnumber);
					bankStatementDetails.setBalanceamount(add);
					bankStatementDetails.setTransactionAmount(userenteramount);
					bankStatementDAO.insertBankStatement(bankStatementDetails);
					System.out.println("Amount credited successfully");
				}
				else
				{
					System.out.println("Server Error 500");
				}
				
			}
			else
			{
				System.out.println("Enter valid amount");
			}
		}
	}
}