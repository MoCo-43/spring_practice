package com.example.demo.ex1;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/api")
@Controller
public class Ex1Controller {
  
  @GetMapping("/sample")
    public ModelAndView sample() {
	  ModelAndView mv = new ModelAndView("sample");  // mav(html이름)
	  mv.addObject("today", new Date());  // (변수명, 데이터타입)
	  return mv;
  } 
	
  @GetMapping("/main")  // templates/api/main.html 경로를 가르킴
  public void main() {}  // void의 경우 templates 경로를 가르킴
	
  // 커맨드객체(제일많이 쓰는 방식)  필드명 = 파라미터명 일치해야함
  // 같은값이 있다면 배열형태로도 보낼 수 있다.
  // log값 확인) UserVO(name=홍길동, age=20, wdate=Tue Sep 02 00:00:00 KST 2025, hobby=[게임, 독서, 드라이브])
  @GetMapping("/ex1")
// @ModelAttribute("user") == model.addAttribute("user", userVO)와 같은역할
  public String ex1(@ModelAttribute("user") UserVO userVO, Model model) {  
//	model.addAttribute("user", userVO);  // 값을 전달  // 없더라도 UserVO값이 전달 된다 => [[${userVO}]]출력하면 나옴
	log.info(userVO);
    return "sample";
  }
  
  // Index를 지정하여 배열객체로 받아옴
  // userList[0].name&userList[0].age
  @GetMapping("/ex2")
  public String ex2(UserListVO list) {
	log.info(list);
    return "sample";
  }

  // @RequestParam get 요청 
  // 파라미터이름이 다른경우 지정 value, 필수값 필요없을 경우 required, 기본값지정 defaultValue
  @GetMapping("/ex3")
  public String ex3(@RequestParam String name, @RequestParam(value = "userage", required = false, defaultValue = "20") Integer age) {
	log.info(name + ":" + age);
    return "sample";
  }
  
  // Map에 모든 파라미터를 받음
  // log확인) {name=people, age=20, wdate=2025-09-02 13:00, hobby=낮잠}
  @GetMapping("/ex4")
  public String ex4(@RequestParam Map<String, Object> map) {
	log.info(map);
    return "sample";
  }
  
  // @PathVariable
  // http://localhost/api/ex5/kim/29
  @GetMapping("/ex5/{name}/{age}")
  public String ex5(@PathVariable String name, @PathVariable int age) {
	log.info("path=" + name + ":" + age);
    return "sample";
  }
  
  // 파일업로드
  @PostMapping("/ex6")
  public String ex6(UserVO vo, MultipartFile pic) {  // @RequestPart("pic") 생략가능
	log.info(pic.getOriginalFilename());
	log.info(pic.getSize());
	log.info(vo);
    return "sample";
  }
  
  // 데이터 넘겨주기
  
}
