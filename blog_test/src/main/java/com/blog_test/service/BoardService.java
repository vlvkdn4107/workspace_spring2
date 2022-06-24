package com.blog_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog_test.dto.BoardSaveRequestDto;
import com.blog_test.model.Board;
import com.blog_test.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	// 글쓰기
	@Transactional
	public void writeBoard(BoardSaveRequestDto dto) {
		Board boardEntity = BoardSaveRequestDto.toEntity(dto);
		boardRepository.save(boardEntity);
	}
	// home 화면에서 게시글 list 뿌리기
	@Transactional
	public Page<Board> boardList(Pageable pageable) {
		return boardRepository.findAll(pageable);
		
	}
	//상세보기
	@Transactional
	public Board boardDetail(int id) {
		Board board = boardRepository.mFindById(id).orElseThrow(() ->{
			System.out.println("서비스 디테일");
			return new RuntimeException("id값이 없습니다.");
		});
		board.setCount(board.getCount() + 1);
		return board;
	}
	// 삭제
	@Transactional
	public int deleteBoard(int id) {
		return boardRepository.mDeleteById(id);	
//		boardRepository.deleteById(id);
		
	}
	@Transactional
	public void updateBoard(int id, BoardSaveRequestDto dto) {
		Board boardEntity = boardRepository.findById(id).orElseThrow(() ->{
			return new RuntimeException("해당 게시글은 없는 게시글입니다.");
		});
		boardEntity.setTitle(dto.getTitle());
		boardEntity.setContent(dto.getContent());
	}
	
	
}
