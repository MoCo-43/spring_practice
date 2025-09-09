package com.yedam.dept.service;

import java.util.List;
import com.yedam.dept.service.DebtDefaultVO;
import com.yedam.dept.service.DebtVO;

/**
 * @Class Name : DebtService.java
 * @Description : Debt Business class
 * @Modification Information
 *
 * @author MoCo
 * @since 2025-09-09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface DebtService {
	
	/**
	 * DEBT을 등록한다.
	 * @param vo - 등록할 정보가 담긴 DebtVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertDebt(DebtVO vo) throws Exception;
    
    /**
	 * DEBT을 수정한다.
	 * @param vo - 수정할 정보가 담긴 DebtVO
	 * @return void형
	 * @exception Exception
	 */
    void updateDebt(DebtVO vo) throws Exception;
    
    /**
	 * DEBT을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 DebtVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteDebt(DebtVO vo) throws Exception;
    
    /**
	 * DEBT을 조회한다.
	 * @param vo - 조회할 정보가 담긴 DebtVO
	 * @return 조회한 DEBT
	 * @exception Exception
	 */
    DebtVO selectDebt(DebtVO vo) throws Exception;
    
    /**
	 * DEBT 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return DEBT 목록
	 * @exception Exception
	 */
    List selectDebtList(DebtDefaultVO searchVO) throws Exception;
    
    /**
	 * DEBT 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return DEBT 총 갯수
	 * @exception
	 */
    int selectDebtListTotCnt(DebtDefaultVO searchVO);
    
}
