package com.example.demo.emp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.emp.mapper.EmpMapper;
import com.example.demo.emp.service.EmpVO;
import com.example.demo.emp.web.EmpService;

import lombok.RequiredArgsConstructor;

@Service  //=@Component
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService{

	final EmpMapper empMapper;
	@Override
	public Long selectCount(EmpVO EmpVO) {
	  return empMapper.selectCount(EmpVO);
	}

	@Override
	public List<EmpVO> selectEmp(EmpVO EmpVO) {
		return empMapper.selectEmp(EmpVO);
	}

	@Override
	public EmpVO selectEmpById(Long employeeId) {
		return empMapper.selectEmpById(employeeId);
	}

	@Override
	public int insertEmp(EmpVO EmpVO) {
		return empMapper.insertEmp(EmpVO);
	}

}
