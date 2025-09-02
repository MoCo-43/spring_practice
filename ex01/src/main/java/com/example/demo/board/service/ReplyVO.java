package com.example.demo.board.service;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReplyVO {
	private int rno;
	private int bno;
	private String reply;
	private String replyer;
	private Date replydate;
	private Date updatedate;
}
