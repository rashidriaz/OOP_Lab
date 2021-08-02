/*
 *   Copyright (c) 2020 
 *   All rights reserved.
 */


public class Account {
    private String name;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;

        if (balance > 0.0) {
            this.balance = balance;
        }
    }

    public void withdraw(double withdraw) {
        if (withdraw <= balance && withdraw >= 0) {
            balance -= withdraw;
        } else {
            System.out.println("\n amount exceeded the Limit");
        }
    }

    public void deposit(double depositAmount) {
        if (depositAmount >= 0) {
            balance += depositAmount;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        if (balance > 0.0) {
            this.balance = balance;
        }
    }

    public double getBalance() {
        return balance;
    }
}
