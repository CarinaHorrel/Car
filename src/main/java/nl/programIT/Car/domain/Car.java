package nl.programIT.Car.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO) 
	
	private long id;
	
	private String brand;
	private int bouwjaar;
	
	public long getId() {
		return id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getBouwjaar() {
		return bouwjaar;
	}
	public void setBouwjaar(int bouwjaar) {
		this.bouwjaar = bouwjaar;
	}
}

 
