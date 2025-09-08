package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
public class Customer {

	public Customer() { }

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 20, nullable = false)
	private String name; 	// VARCHAR(20)
	
	@Column(length = 20, nullable = false, unique = true)
	private String phone;

	@OneToOne
	@JoinColumn(name = "address_id")
	Address address;
	
	
	@Builder
	public Customer(String name, String phone, Address address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	public Customer(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
}