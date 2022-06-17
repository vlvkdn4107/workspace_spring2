package com.tencoblog_test.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User_1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, length = 20)
	private String userName;
	@Column(nullable = false, length = 20)
	private String password;
	@Column(nullable = false, length = 20)
	private String email;
	@Enumerated(EnumType.STRING)
	private RoleType role;
	@CreationTimestamp
	private Timestamp createDate;
	
}
