package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.service.ReplyVO;

@Mapper
public interface ReplyMapper {

	// 댓글삽입
	int insert(ReplyVO replyVO);
	
	// 업데이트
	int update(ReplyVO replyVO);
	
	// 삭제
	int delete(Long rno);

	// 단건조회
	ReplyVO read(Long rno);
	
	// 게시글 페이징
	List<ReplyVO> getList (ReplyVO replyVO);
	
	// 게시글 댓글카운트
	int getCountByBno (Long bno);
	
}
