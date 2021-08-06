package com.skillstorm.model;

public class Car {
	private int id;
	private String vin;
	private String model;
	private String make;
	private int mileage;
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(int id, String vin, String model, String make, int mileage) {
		super();
		this.id = id;
		this.vin = vin;
		this.model = model;
		this.make = make;
		this.mileage = mileage;
	}
	public Car(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", vin=" + vin + ", model=" + model + ", make=" + make + ", mileage=" + mileage + "]";
	}
	
	

}
