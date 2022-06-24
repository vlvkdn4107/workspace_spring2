package com.blog_test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.blog_test.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	
	@Query(value = "SELECT * FROM board WHERE id = :id", nativeQuery = true)
	Optional<Board> mFindById(int id);
	
	@Modifying
	@Query(value = "DELETE FROM board WHERE id = :id" , nativeQuery = true)
	int mDeleteById(int id);
	
}
