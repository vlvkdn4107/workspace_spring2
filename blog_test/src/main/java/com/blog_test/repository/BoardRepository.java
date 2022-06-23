package com.blog_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog_test.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

}
