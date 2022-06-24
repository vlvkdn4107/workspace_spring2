package com.blog_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog_test.dto.BoardSaveRequestDto;
import com.blog_test.model.Board;
import com.blog_test.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	
	
	@GetMapping({"", "/"})
	public String home(@PageableDefault(size = 5, sort = "id", direction = Direction.DESC)org.springframework.data.domain.Pageable pageable, Model model) {
	Page<Board>board = boardService.boardList(pageable);
	model.addAttribute("board", board);
		return "home";
	}
	
	@GetMapping("/boardSave_form")
	public String board() {
		return "board/boardSave_form";
	}
	
	// 글쓰기
	@PostMapping("/boardSave")
	@ResponseBody
	public String save(@RequestBody BoardSaveRequestDto dto) {
		boardService.writeBoard(dto);
		return "ok";
	}
	
	// 상세보기
	@GetMapping("/board/{id}")
	public String detail(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.boardDetail(id));
		return "/board/boardDetail_form";
	}
	
	// 삭제
	@DeleteMapping("/deleteBoard/{id}")
	@ResponseBody
	public boolean delete(@PathVariable int id) {
		System.out.println(boardService.deleteBoard(id) + " ??????");
		return boardService.deleteBoard(id) == 1 ? false : true; //true : false 했을때 왜 false이 나오지?
	}
	
	// 수정 페이지
	@GetMapping("/boardUpdate/{id}")
	public String updateform(@PathVariable int id, Model model) {
		System.out.println("dsadas");
		Board board = boardService.boardDetail(id);
		model.addAttribute("board", board);
		return "/board/boardUpdate_form";
		
	}
	
//	 게시글 수정하기
	@PutMapping("/updateOk/{id}")
	@ResponseBody
	public String updateBoard(@PathVariable int id, @RequestBody BoardSaveRequestDto dto) {
		System.out.println("수정했을때 들어오는 메서드@@@@@@@@@@@");
		boardService.updateBoard(id, dto);
		return "ok";
	}
	
	
	
	
	
}
