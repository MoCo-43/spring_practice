package com.yedam.dept.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import com.yedam.dept.service.DebtService;
import com.yedam.dept.service.DebtDefaultVO;
import com.yedam.dept.service.DebtVO;
import com.yedam.dept.service.impl.DebtDAO;
import com.yedam.dept.service.impl.DebtMapper;
/**
 * @Class Name : DebtServiceImpl.java
 * @Description : Debt Business Implement class
 * @Modification Information
 *
 * @author MoCo
 * @since 2025-09-09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("debtService")
public class DebtServiceImpl extends EgovAbstractServiceImpl implements
        DebtService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(DebtServiceImpl.class);

    @Resource(name="debtMapper")
    private DebtMapper debtDAO;
    
    //@Resource(name="debtDAO")
    //private DebtDAO debtDAO;
    
    /** ID Generation */
    //@Resource(name="{egovDebtIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * DEBT을 등록한다.
	 * @param vo - 등록할 정보가 담긴 DebtVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertDebt(DebtVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	debtDAO.insertDebt(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * DEBT을 수정한다.
	 * @param vo - 수정할 정보가 담긴 DebtVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateDebt(DebtVO vo) throws Exception {
        debtDAO.updateDebt(vo);
    }

    /**
	 * DEBT을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 DebtVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteDebt(DebtVO vo) throws Exception {
        debtDAO.deleteDebt(vo);
    }

    /**
	 * DEBT을 조회한다.
	 * @param vo - 조회할 정보가 담긴 DebtVO
	 * @return 조회한 DEBT
	 * @exception Exception
	 */
    public DebtVO selectDebt(DebtVO vo) throws Exception {
        DebtVO resultVO = debtDAO.selectDebt(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * DEBT 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return DEBT 목록
	 * @exception Exception
	 */
    public List<?> selectDebtList(DebtDefaultVO searchVO) throws Exception {
        return debtDAO.selectDebtList(searchVO);
    }

    /**
	 * DEBT 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return DEBT 총 갯수
	 * @exception
	 */
    public int selectDebtListTotCnt(DebtDefaultVO searchVO) {
		return debtDAO.selectDebtListTotCnt(searchVO);
	}
    
}
