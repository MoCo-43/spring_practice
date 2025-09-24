package com.example.demo.emp.web;

import java.io.InputStream;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.common.Paging;
import com.example.demo.emp.service.EmpVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RequestMapping("/emp")
@Controller // router바인딩
public class EmpController {
	@Autowired
//	EmpMapper empMapper; // 이전과 다르게 new를 사용할 필요 없음, 객체(빈)가 주입됨
	EmpService empService;

	@GetMapping("/list") // emp/list?page=2
	public String empList(Model model, EmpVO empVO, Paging paging) {
		paging.setTotalRecord(empService.selectCount(empVO));
		paging.setPageUnit(5);
		empVO.setFirst(paging.getFirst());
		empVO.setLast(paging.getLast());
		model.addAttribute("empList", empService.selectEmp(empVO));
		return "emp/empList"; // empList.html
	}

	@GetMapping("/emp") // localhost?emp?employeeId=100
	public String emp(Model model, @RequestParam("employeeId") Long employeeId) {
		model.addAttribute("emp", empService.selectEmpById(employeeId));
		return "emp"; // emp.html

	}

	// jasper report 보여주기

	@Autowired
	DataSource datasource;
	
	@RequestMapping("report")
	public void report(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		Connection conn = datasource.getConnection();
		// 소스 컴파일 jrxml -> jasper
		InputStream stream = getClass().getResourceAsStream("/reports/emp.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(stream); 
		
		// 파라미터 맵
		HashMap<String, Object> map = new HashMap<>();
		map.put("P_EMPNAME", "hong gildong");
		
		// 데이터 조회
		EmpVO vo = new EmpVO();
		vo.setFirst(1);
		vo.setLast(10);
		JRDataSource JRdataSource = new JRBeanCollectionDataSource(empService.selectEmp(vo));
		response.setContentType("application/pdf");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);
		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}

	// jasperreport pdf 다운
	@GetMapping("report2")
	public ModelAndView report2() {
		// view 지정
		JasperPdfView view = new JasperPdfView("reports/emp.jrxml");
		view.setContentType("application/octet-stream");
		//view.setContentType("application/pdf");
		ModelAndView mv = new ModelAndView(view);
		
		// 파라미터
		mv.addObject("P_EMPNAME", "hong gildong");
		
		// 데이터 조회
		EmpVO vo = new EmpVO();
		vo.setFirst(1);
		vo.setLast(10);
		mv.addObject("datas", empService.selectEmp(vo));
		

		return mv;
	}
}
