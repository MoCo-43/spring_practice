package com.example.demo.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardVO;
import com.example.demo.board.service.ReplyVO;
import com.example.demo.board.web.BoardService;
import com.example.demo.common.aop.PrintExecutionTime;

import lombok.RequiredArgsConstructor;

@Service  // = @Component
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	  
	final BoardMapper boardMapper;
    
	// 게시글 전체조회
	@Override
	public List<BoardVO> selectBoard() {
		return boardMapper.selectBoard();
	}

	// 게시글 단건조회
	@Override
	@PrintExecutionTime  // AOP를 사용한 Annotation을 넣음
	public BoardVO selectBoardByBno(Long bno) {
		return boardMapper.selectBoardByBno(bno);
	}

	// 댓글 단건조회
	@Override
	public List<ReplyVO> selectReplyByBno(Long bno) {
		return boardMapper.selectReplyByBno(bno);
	}

	// insert
	@Override
	public int insert(BoardVO boardVO) {
		return boardMapper.insert(boardVO);
	}

	// 댓글 삭제
	@Transactional
	@Override
	public int deleteBoard(Long bno) {
		// 댓글 삭제
		
		// 첨부파일 삭제(레코드 삭제) => 물리적인 파일 삭제
		
		// 게시글 삭제
		return 0;
	}
	
	
}
