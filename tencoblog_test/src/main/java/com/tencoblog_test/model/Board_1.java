package com.tencoblog_test.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board_1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, length = 100)
	private String title;
	@Lob
	private String content;
	@ColumnDefault("0")
	private int count;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User_1 userId;
	
	@OneToMany(mappedBy = "board_1", fetch = FetchType.EAGER) // mappedBy는 연관관계인 쪽에서 Board_1 의 변수명을 적어야한다.
	private List<Reply_1> reply_1;
	
	
	@CreationTimestamp
	private Timestamp createDate;
}
