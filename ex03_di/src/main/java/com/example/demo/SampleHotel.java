package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class SampleHotel {
	//1. 필드(@Autowired)
	//2. 생성자(@RequiredArgsConsturctor + final)
	//3. setter(@Setter(onMethod_={@Autowired})
	@Autowired
	Chef chef;
}
