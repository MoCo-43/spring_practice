package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  // node의 router와 같은 역할
public class HomeController {

	@Autowired
	Animal animal;
	
	@GetMapping("/")
	@ResponseBody  // json형태를 parsing해줌
	public String home() {
		animal.sound();
		return "hello";
	}
	
	@GetMapping("/main")
    public String main() {
		return "main";  //templates/main.html
	}
}
