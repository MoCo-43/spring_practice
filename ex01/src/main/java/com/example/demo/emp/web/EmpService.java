package com.example.demo.emp.web;

import java.util.List;

import com.example.demo.emp.service.EmpVO;

//use case diagram
public interface EmpService {
	
	// 건수조회
	Long selectCount(EmpVO EmpVO);
	// 전체조회
	List<EmpVO> selectEmp(EmpVO EmpVO);
	// 단건조회
	EmpVO selectEmpById (Long employeeId);
	// 등록
	int insertEmp(EmpVO EmpVO);
	// 수정
	
	// 삭제 
	
	
  // 사원등록
  	
  // 사원수정
	
  // 삭제
	
  // 퇴사
	
  // 조회
	
  
}