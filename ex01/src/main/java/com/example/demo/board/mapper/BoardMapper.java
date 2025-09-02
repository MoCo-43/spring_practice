package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.service.BoardVO;
import com.example.demo.board.service.ReplyVO;

@Mapper
public interface BoardMapper {

	// 게시글 전체조회
	List<BoardVO> selectBoard();
	
	// 게시글 단건조회
	BoardVO selectBoardByBno(Long bno);
	
	// 댓글 단건조회
	List<ReplyVO> selectReplyByBno(Long bno);
	
	// 게시글 단건조회 JOIN사용
	List<BoardVO> joinBoardByReplyBno(Long bno);

}
