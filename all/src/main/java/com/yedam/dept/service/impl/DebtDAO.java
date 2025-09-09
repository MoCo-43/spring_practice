package com.yedam.dept.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import com.yedam.dept.service.DebtVO;
import com.yedam.dept.service.DebtDefaultVO;

/**
 * @Class Name : DebtDAO.java
 * @Description : Debt DAO Class
 * @Modification Information
 *
 * @author MoCo
 * @since 2025-09-09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("debtDAO")
public class DebtDAO extends EgovAbstractMapper {

	/**
	 * DEBT을 등록한다.
	 * @param vo - 등록할 정보가 담긴 DebtVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertDebt(DebtVO vo) throws Exception {
        insert("debtDAO.insertDebt", vo);
    }

    /**
	 * DEBT을 수정한다.
	 * @param vo - 수정할 정보가 담긴 DebtVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateDebt(DebtVO vo) throws Exception {
        update("debtDAO.updateDebt", vo);
    }

    /**
	 * DEBT을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 DebtVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteDebt(DebtVO vo) throws Exception {
        delete("debtDAO.deleteDebt", vo);
    }

    /**
	 * DEBT을 조회한다.
	 * @param vo - 조회할 정보가 담긴 DebtVO
	 * @return 조회한 DEBT
	 * @exception Exception
	 */
    public DebtVO selectDebt(DebtVO vo) throws Exception {
        return (DebtVO) selectOne("debtDAO.selectDebt", vo);
    }

    /**
	 * DEBT 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 List<DebtDefaultVO>
	 * @return DEBT 목록
	 * @exception Exception
	 */
    public List<DebtDefaultVO> selectDebtList(DebtDefaultVO searchVO) throws Exception {
        return selectList("debtDAO.selectDebtList", searchVO);
    }

    /**
	 * DEBT 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return DEBT 총 갯수
	 * @exception
	 */
    public int selectDebtListTotCnt(DebtDefaultVO searchVO) {
        return (Integer)selectOne("debtDAO.selectDebtListTotCnt", searchVO);
    }

}
