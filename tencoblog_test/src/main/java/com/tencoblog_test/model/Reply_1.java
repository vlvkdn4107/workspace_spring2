package com.tencoblog_test.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Reply_1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, length = 200)
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "boardId")
	private Board_1 board_1; // 여기 board_1이 Board_1클래스에 mappedBy에 들어간다.
	@ManyToOne
	@JoinColumn(name = "userId")
	private User_1 user_1;
	
	@CreationTimestamp
	private Timestamp createDate;
}
