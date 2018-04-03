package com.ljz.test.advice;

import lombok.Setter;

@Setter
public class CustomerService {
	private String name;
	private String url;

	public void printName() {
		System.out.println("Customer name : " + this.name);
	}

	public void printURL() {
		System.out.println("Customer website : " + this.url);
	}

	public void printThrowException() {
		throw new IllegalArgumentException();
	}

}