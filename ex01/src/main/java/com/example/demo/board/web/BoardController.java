package com.example.demo.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.board.mapper.BoardMapper;

@Controller
public class BoardController {
  @Autowired
  BoardMapper boardMapper;
  
  // 전체조회
  @GetMapping("boardlist")
  public String boardList(Model model) {
	  model.addAttribute("boardList", boardMapper.selectBoard());
	  return "boardList";
  }
  
  // 단건조회
  @GetMapping("board")
  public String board(Model model, @RequestParam("bno") Long bno) {
    model.addAttribute("board", boardMapper.selectBoardByBno(bno));
    return "board";
  }
  
  // Join을 이용한 단건조회
	@GetMapping("jboardlist")
	public String jboardlist(Model model) {
		model.addAttribute("jboardlist", boardMapper.selectBoard());
		return "jboardlist";
	}
  
  
  // Join을 이용한 단건조회
  @GetMapping("jboard")
  public String jboard(Model model, @RequestParam("bno") Long bno) {
    model.addAttribute("jboard", boardMapper.joinBoardByReplyBno(bno));
    return "jboard";
  }
}
