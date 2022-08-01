package Apllication;

import java.util.Locale;
import java.util.Scanner;

import modes.entites.Account;
import modes.exceptions.DomainException;

public class Program {
	public static Scanner sc = null;
	public static void main(String[] args) {
		
		
		Locale.setDefault(Locale.US);
		sc = new Scanner(System.in);
		System.out.println("Enter the acount data: ");
		System.out.print("Number: ");
		int number = sc.nextInt();			
		sc.nextLine();
		System.out.print("Holder: ");
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw Limit: ");
		double withdrawLimit = sc.nextDouble();
		
		System.out.print("Enter the amount for withdraw: ");
		double amount =sc.nextDouble();
		
		try {
			Account account = new Account(number, holder, balance, withdrawLimit); 
			account.withdraw(amount);
			
			System.out.println(account);
			
		}catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}finally{
			sc.close();
		}
				

	}

}
