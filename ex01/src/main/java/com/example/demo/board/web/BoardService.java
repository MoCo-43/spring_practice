package com.example.demo.board.web;

import java.util.List;

import com.example.demo.board.service.BoardVO;
import com.example.demo.board.service.ReplyVO;

public interface BoardService {

	// 게시글 전체조회
	List<BoardVO> selectBoard();
	
	// 게시글 단건조회
	BoardVO selectBoardByBno(Long bno);
	
	// 댓글 단건조회
	List<ReplyVO> selectReplyByBno(Long bno);

	// 게시글insert
	int insert(BoardVO boardVO);
	
	// 삭제
	int deleteBoard(Long bno);
	
}
