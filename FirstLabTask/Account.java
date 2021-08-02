/*
 *   Copyright (c) 2020 
 *   All rights reserved.
 */


public class Account{

	private String name;

	private double balance;

	public Account(){
	
	}
	
	public Account(String name, double balance){
	
		this.name = name;
		
		if(balance >= 0){

			this.balance = balance;
		}
	}

	public void setName(String name){

		this.name = name;
	}

	public String getName(){

		return this.name;
	}
	public void setBalance(double balance){

		if(balance >= 0){

			this.balance = balance;
		}
	}

	public double getBalance(){

		return this.balance;
	}

	public void depositAmount(double deposit){

		if(deposit >= 0){

			this.balance += deposit;
		}

	}

	public boolean withdraw(double withdraw){


		if(withdraw >= this.balance || withdraw < 0){

			return false;
		}
		
		this.balance -= withdraw;

		return true;

	}

}

