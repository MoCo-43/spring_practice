package com.yedam.dept.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import com.yedam.dept.service.DebtService;
import com.yedam.dept.service.DebtDefaultVO;
import com.yedam.dept.service.DebtVO;

/**
 * @Class Name : DebtController.java
 * @Description : Debt Controller class
 * @Modification Information
 *
 * @author MoCo
 * @since 2025-09-09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=DebtVO.class)
public class DebtController {

    @Resource(name = "debtService")
    private DebtService debtService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * DEBT 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 DebtDefaultVO
	 * @return "/debt/DebtList"
	 * @exception Exception
	 */
    @RequestMapping(value="/debt/DebtList.do")
    public String selectDebtList(@ModelAttribute("searchVO") DebtDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> debtList = debtService.selectDebtList(searchVO);
        model.addAttribute("resultList", debtList);
        
        int totCnt = debtService.selectDebtListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/debt/DebtList";
    } 
    
    @RequestMapping("/debt/addDebtView.do")
    public String addDebtView(
            @ModelAttribute("searchVO") DebtDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("debtVO", new DebtVO());
        return "/debt/DebtRegister";
    }
    
    @RequestMapping("/debt/addDebt.do")
    public String addDebt(
            DebtVO debtVO,
            @ModelAttribute("searchVO") DebtDefaultVO searchVO, SessionStatus status)
            throws Exception {
        debtService.insertDebt(debtVO);
        status.setComplete();
        return "forward:/debt/DebtList.do";
    }
    
    @RequestMapping("/debt/updateDebtView.do")
    public String updateDebtView(
            @RequestParam("id") java.math.BigDecimal id ,
            @ModelAttribute("searchVO") DebtDefaultVO searchVO, Model model)
            throws Exception {
        DebtVO debtVO = new DebtVO();
        debtVO.setId(id);        
        // 변수명은 CoC 에 따라 debtVO
        model.addAttribute(selectDebt(debtVO, searchVO));
        return "/debt/DebtRegister";
    }

    @RequestMapping("/debt/selectDebt.do")
    public @ModelAttribute("debtVO")
    DebtVO selectDebt(
            DebtVO debtVO,
            @ModelAttribute("searchVO") DebtDefaultVO searchVO) throws Exception {
        return debtService.selectDebt(debtVO);
    }

    @RequestMapping("/debt/updateDebt.do")
    public String updateDebt(
            DebtVO debtVO,
            @ModelAttribute("searchVO") DebtDefaultVO searchVO, SessionStatus status)
            throws Exception {
        debtService.updateDebt(debtVO);
        status.setComplete();
        return "forward:/debt/DebtList.do";
    }
    
    @RequestMapping("/debt/deleteDebt.do")
    public String deleteDebt(
            DebtVO debtVO,
            @ModelAttribute("searchVO") DebtDefaultVO searchVO, SessionStatus status)
            throws Exception {
        debtService.deleteDebt(debtVO);
        status.setComplete();
        return "forward:/debt/DebtList.do";
    }

}
