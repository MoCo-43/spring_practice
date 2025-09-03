package com.example.demo.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.common.Paging;
import com.example.demo.emp.service.EmpVO;

@Controller // router바인딩
public class EmpController {
	@Autowired
//	EmpMapper empMapper; // 이전과 다르게 new를 사용할 필요 없음, 객체(빈)가 주입됨
	EmpService empService;

	@GetMapping("emplist") // empList?page=2
	public String empList(Model model, EmpVO empVO, Paging paging) {
		paging.setTotalRecord(empService.selectCount(empVO));
		paging.setPageUnit(5);
		empVO.setFirst(paging.getFirst());
		empVO.setLast(paging.getLast());
		model.addAttribute("empList", empService.selectEmp(empVO));
		return "empList"; // empList.html
	}

	@GetMapping("emp") // localhost?emp?employeeId=100
	public String emp(Model model, @RequestParam("employeeId") Long employeeId) {
		model.addAttribute("emp", empService.selectEmpById(employeeId));
		return "emp"; // emp.html

	}
}
