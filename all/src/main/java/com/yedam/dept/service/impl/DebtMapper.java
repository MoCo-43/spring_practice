package com.yedam.dept.service.impl;

import java.util.List;

import com.yedam.dept.service.DebtVO;
import com.yedam.dept.service.DebtDefaultVO;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : DebtMapper.java
 * @Description : Debt Mapper Class
 * @Modification Information
 *
 * @author MoCo
 * @since 2025-09-09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("debtMapper")
public interface DebtMapper {

	/**
	 * DEBT을 등록한다.
	 * @param vo - 등록할 정보가 담긴 DebtVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertDebt(DebtVO vo) throws Exception;

    /**
	 * DEBT을 수정한다.
	 * @param vo - 수정할 정보가 담긴 DebtVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateDebt(DebtVO vo) throws Exception;

    /**
	 * DEBT을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 DebtVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteDebt(DebtVO vo) throws Exception;

    /**
	 * DEBT을 조회한다.
	 * @param vo - 조회할 정보가 담긴 DebtVO
	 * @return 조회한 DEBT
	 * @exception Exception
	 */
    public DebtVO selectDebt(DebtVO vo) throws Exception;

    /**
	 * DEBT 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return DEBT 목록
	 * @exception Exception
	 */
    public List<?> selectDebtList(DebtDefaultVO searchVO) throws Exception;

    /**
	 * DEBT 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return DEBT 총 갯수
	 * @exception
	 */
    public int selectDebtListTotCnt(DebtDefaultVO searchVO);

}
