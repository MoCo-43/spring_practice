package com.example.demo.ex2;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.ex1.UserVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "회원관리 API", description = "게임사이트 회원 가입")
@RequestMapping("/api")
@RestController  // @Controller + @ResponseBody
public class Ex2Controller {
	@Tag(name = "회원관리 API")
	@Operation(summary = "회원조회")
	// UserVO 단건조회
	@GetMapping("/rest1")
	public UserVO rest1() {
	 return new UserVO("홍길동", 20, new Date(), Arrays.asList("게임","등산"));
	}
	
	@Tag(name = "회원관리 API")
	@Operation(summary = "회원단건조회")
	// RequestBody없이 진행
	@GetMapping("/rest2") // json String은 get방식이 안됨  // query String : name=aaa&age=20
	public UserVO rest2(UserVO userVO) {
	 return userVO;
	}
	
	
	// Post방식 단건조회
	@PostMapping("/rest3") // json String => {"name":"aa" "age":50} VO json STring은 get 방식 X
	public UserVO rest3(@RequestBody UserVO userVO) {
	 return userVO;
	}
	
	// RestTemplate 사용
	// Only 동기처리
	@GetMapping("/rest4")
	public Map rest4() {
	  RestTemplate restTemplate = new RestTemplate();
	  String uri = "https://jsonplaceholder.typicode.com/todos/1";
	  return restTemplate.getForObject(uri, Map.class);
	}
	
	// WebClient 사용
	// .block() 동기처리
	@GetMapping("/rest5")
	public String getPost() {
		 WebClient webClient = WebClient.create();
		 String response = webClient.get()
		 .uri("https://jsonplaceholder.typicode.com/posts/1")
		 .retrieve()
		 .bodyToMono(String.class).block();
		return response.toString();
		}
}
