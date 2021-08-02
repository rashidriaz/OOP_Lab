/*
 *   Copyright (c) 2020 
 *   All rights reserved.
 */



// Author: Rashid Riaz FA19_BSE_081

import java.util.Scanner;

public class Main {

	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {

		Account account1 = new Account("John Blue", 52.09);
		Account account2 = new Account("John Green", -789.0);

		Stream.clearScreens(0);

		System.out.println("Initial Value For Account : 1");

		showResults(account1.getName(), account1.getBalance());

		System.out.println("Press Enter to continue....");
		input.nextLine();

		Stream.clearScreens(0);

		System.out.println("Initial Value For Account : 2");

		showResults(account2.getName(), account2.getBalance());

		System.out.println("Press Enter to continue....");
		input.nextLine();

		Stream.clearScreens(0);
		boolean exit = false;
		do {
			switch (menu()) {
			case 1:
				switch (accountNumber()) {
				case 1:
					System.out.println("Modifying Account 1");
					account1.setName(inputName("First Account"));
					account1.setBalance(inputBalance("First Account"));
					Stream.clearScreens(1);
					showResults(account1.getName(), account1.getBalance());
					break;
				case 2:
					System.out.println("Modifying Account 2");
					account2.setName(inputName("Second Account"));
					account2.setBalance(inputBalance("Second Account"));
					Stream.clearScreens(1);
					showResults(account2.getName(), account2.getBalance());
					break;
				default:
					System.out.println("Invalid Account number");
					break;
				}
				break;
			case 2:
				switch (accountNumber()) {
				case 1:
					System.out.println("For Depositing Amount : ");
					account1.depositAmount(inputBalance("Deposit"));
					Stream.clearScreens(1);
					showResults(account1.getName(), account1.getBalance());
					break;
				case 2:
					System.out.println("For Depositing Amount : ");
					account2.depositAmount(inputBalance("Deposit"));
					Stream.clearScreens(1);
					showResults(account2.getName(), account2.getBalance());
					break;
				default:
					System.out.println("Invalid Account number");
					break;
				}
				break;
			case 3:
				boolean withdrawIsPossible;
				switch (accountNumber()) {
				case 1:
					System.out.println("For Withdrawing Amount : ");
					withdrawIsPossible = account1.withdraw(inputBalance("Withdraw"));
					if (withdrawIsPossible) {
						System.out.println("Withdrawal Successful!!");
					} else {
						System.out.println("Error : Withdrawal Amount Exceeded Account Balance");
					}
					Stream.clearScreens(1);
					showResults(account1.getName(), account1.getBalance());
					break;
				case 2:
					System.out.println("For Withdraw Amount : ");
					withdrawIsPossible = account2.withdraw(inputBalance("Withdraw"));
					if (withdrawIsPossible) {
						System.out.println("Withdrawal Successful!!");
					} else {
						System.out.println("Error : Withdrawal Amount Exceeded Account Balance");
					}
					Stream.clearScreens(1);
					showResults(account2.getName(), account2.getBalance());
					break;
				default:
					System.out.println("Invalid Account number");
					Stream.clearScreens(1);
					break;
				}
				break;
			case 4:
				Stream.clearScreens(0);

				System.out.println("Information For Account : 1");

				showResults(account1.getName(), account1.getBalance());

				System.out.println("Press Enter for Next Record....");
				input.nextLine();

				Stream.clearScreens(0);

				System.out.println("Information For Account : 2");

				showResults(account2.getName(), account2.getBalance());

				System.out.println("Press Enter to continue....");
				input.nextLine();
				Stream.clearScreens(0);
				break;
			case 5:
				exit = true;
				break;
			default:
				System.out.println("Invalid Choice!!");
				break;
			}
		} while (!exit);
	}

	public static String inputName(String account) throws InterruptedException {
		String name;
		System.out.print("\nEnter Name For " + account + " : ");
		name = input.nextLine();
		Stream.clearScreens(0);
		if (containsAlphabets(name)) {
			return name;
		} else {
			System.out.println("Invalid Name! Try Again!!");
			Stream.clearScreens(2);
			name = inputName(account);
			return name;
		}
	}

	public static double inputBalance(String account) throws InterruptedException {
		double balance = 0;
		System.out.print("\nEnter Amount to " + account + " : ");
		try {
			balance = Double.parseDouble(input.nextLine());
		} catch (NumberFormatException exception) {
			System.out.println("Entering special characters here is an error!!");
			balance = -1;
		}
		Stream.clearScreens(1);
		if (balance == -1) {
			balance = inputBalance(account);
		}
		return balance;
	}

	public static int menu() throws InterruptedException {
		int choice = 0;
		System.out.println("1. Modify Account Data");
		System.out.println("2. Deposit Amount");
		System.out.println("3. Withdraw Amount");
		System.out.println("4. Show Accounts Details");
		System.out.println("5. Exit!");
		choice = input.nextInt();
		input.nextLine();
		Stream.clearScreens(0);
		return choice;
	}

	public static int accountNumber() throws InterruptedException {
		int choice = 0;
		System.out.println("Enter Account No. You Want to Update");
		System.out.println("1. Account 1");
		System.out.println("2. Account 2");
		choice = input.nextInt();
		input.nextLine();
		Stream.clearScreens(0);
		return choice;
	}

	public static void showResults(String name, double balance) {
		System.out.println("\n___________________________________________\n\n");

		System.out.println("UserName = " + name);
		System.out.printf("\nBalance = %.2f\n", balance);

		System.out.println("\n___________________________________________\n");
	}

	public static boolean containsAlphabets(String string) {
		if (string.length() < 1) {
			return false;
		}
		for (int i = 0; i < string.length(); i++) {
			char character = string.charAt(i);
			boolean isUpperCase = (character >= 'A' && character <= 'Z');
			boolean isLowerCase = (character >= 'a' && character <= 'z');
			if (!(isUpperCase || isLowerCase) && !(character == ' ')) {
				return false;
			}
		}
		return true;
	}

}
