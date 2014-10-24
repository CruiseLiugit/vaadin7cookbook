package com.example.vaadin7cookbook.chapter7;

public class Product {
	
	private int code;
	private String name = "";
	private double price;
	//private boolean salable;

	public Product(int code) {
		this.code = code;
	};

	public Product(int code, String name, double price) {		
		this.code = code;
		this.name = name;
		this.price = price;
	}	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}	
	
//	public boolean isSalable() {
//		return salable;
//	}
//
//	public void setSalable(boolean salable) {
//		this.salable = salable;
//	}

	@Override
	public String toString() {		
		return "[" + code + ", " + name + ", " + price + "]";
	}

}
