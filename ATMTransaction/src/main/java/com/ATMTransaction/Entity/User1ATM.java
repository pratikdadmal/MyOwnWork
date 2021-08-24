package com.ATMTransaction.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="User1ATM")
public class User1ATM {
	
	@Id
	@GeneratedValue
	private int uid;
	@Column
	private int uAccount;
	@Column
	private double uAmount;
	
	
	public User1ATM() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User1ATM(int uid, int uAccount, double uAmount) {
		super();
		this.uid = uid;
		this.uAccount = uAccount;
		this.uAmount = uAmount;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public int getuAccount() {
		return uAccount;
	}


	public void setuAccount(int uAccount) {
		this.uAccount = uAccount;
	}


	public double getuAmount() {
		return uAmount;
	}


	public void setuAmount(double uAmount) {
		this.uAmount = uAmount;
	}


	@Override
	public String toString() {
		return "User1ATM [uid=" + uid + ", uAccount=" + uAccount + ", uAmount=" + uAmount + "]";
	}

	
	
}
