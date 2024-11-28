package com.bank;

import java.util.Scanner;

import com.bank.service.BankService;
import com.bank.service.CustomerRelationAssociater;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc=new Scanner(System.in);
    	
    	
        BankService bankservice= CustomerRelationAssociater.customerService();
        bankservice.toSleep("(* ^ )WEL-COME TO BANK( ^ *)\n");
        while(true) 
        {
        	bankservice.toSleep("Enter \n 1.For Registration \n 2.For Login\n");
            display(bankservice,sc);
            System.out.println("Do you want to continue(yes/no)\n");
            String str=sc.next();
            if(str.equalsIgnoreCase("no")) 
            {
            	System.out.println("Thank you visit again");	
        	    break;
            }
            if(!str.equalsIgnoreCase("yes")) 
            {
            	System.out.println("invalid input");
        	    break;
            }
        }
    }
    private static void display(BankService bankService,Scanner sc) 
    {
        int choice = sc.nextInt();
        
        switch (choice) 
        {
            case 1:
                bankService.toSleep("Registration\n");
                bankService.userRegistration();
                break;
            case 2:
                bankService.toSleep("--Login--\n");
                bankService.userLogin();
                break;
            default:
                bankService.toSleep("Invalid Selection\n");
                break;
        }
    }
}
