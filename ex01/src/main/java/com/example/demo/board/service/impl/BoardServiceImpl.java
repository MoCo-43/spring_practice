package com.example.demo.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardVO;
import com.example.demo.board.service.ReplyVO;
import com.example.demo.board.web.BoardService;

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
	public BoardVO selectBoardByBno(Long bno) {
		return boardMapper.selectBoardByBno(bno);
	}

	// 댓글 단건조회
	@Override
	public List<ReplyVO> selectReplyByBno(Long bno) {
		return boardMapper.selectReplyByBno(bno);
	}

}
