package com.example.demo;

import org.springframework.stereotype.Component;


public class Cat implements Animal {

	@Override
	public void sound() {
		  System.out.println("야옹@!");
	}

}
