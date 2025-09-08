package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyVO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@SpringBootTest
public class ReplyMapperTest {

	@Autowired ReplyMapper replyMapper;
	
	// 게시글의 댓글 목록 조회
	@Test
	public void getList() {
		ReplyVO rvo = new ReplyVO();
		rvo.setBno(1L);
		rvo.setLast(10);
		rvo.setFirst(0);
		List<ReplyVO> list = replyMapper.getList(rvo);
		list.forEach(System.out::println); // = list.forEach(reply -> System.out.println(reply));
	}
	
	// 댓글삽입
	@JsonIgnore
	@Test
	public void insert() {
		ReplyVO reply = new ReplyVO();
		reply.setBno(1L);
		reply.setReplyer("lee");
		reply.setReply("king of lee");
		// when
		int result = replyMapper.insert(reply);
		// then
		assertEquals(result, 1);
	}
}
