/*
 *   Copyright (c) 2020 
 *   All rights reserved.
 */

import java.util.Scanner;

public class AccountTest {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Account account1 = new Account("Jane Green", 50.00);
        Account account2 = new Account("John Blue", -24.00);

        System.out.printf("%s balance  :$%.2f %n", account1.getName(), account1.getBalance());
        System.out.printf("%s balance  :$%.2f %n", account2.getName(), account2.getBalance());
        // For Deposit

        System.out.print("\nEnter Deposit amount for account1 : ");
        double depositAmount =input.nextDouble();
        
        System.out.printf("\n  **Adding %.2f in account1** \n", depositAmount);
        account1.deposit(depositAmount);
        
        
        
        
        System.out.print("\n Enter Deposit amount for account2 : ");
        depositAmount = input.nextDouble();
        
        System.out.printf("\n  **Adding %.2f from account2** \n", depositAmount);
        account2.deposit(depositAmount);
        
        System.out.printf("%s balance: $%.2f %n", account1.getName(),account1.getBalance());
        System.out.printf("%s balance: $%.2f %n", account2.getName(),account2.getBalance());
        
        // For Withdrawing
        System.out.print("\nEnter withdraw amount for account1 : ");
        double withdrawAmount = input.nextDouble();

        System.out.printf("\n  **deducting %.2f from account1** \n", withdrawAmount);
        account1.withdraw(withdrawAmount);

        System.out.print("\n Enter withdraw amount for account2 : ");
        withdrawAmount = input.nextDouble();

        System.out.printf("\n  **deducting %.2f from account2** \n", withdrawAmount);
        account2.withdraw(withdrawAmount);

        System.out.printf("%s balance: $%.2f %n", account1.getName(), account1.getBalance());
        System.out.printf("%s balance: $%.2f %n", account2.getName(), account2.getBalance());

        input.close();
    }
}
