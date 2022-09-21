package com.project.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="policy_board")
public class Policy_Board extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String title;
	private String content;
	private int readCnt;
	private String registerId;
	private Long fileId;
	private String fileName;
	
	@Builder
	public Policy_Board(Long id, String title, String content, int readCnt, Long fileId, String registerId, String fileName) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.readCnt = readCnt;
		this.fileId = fileId;
		this.registerId = registerId;
		this.fileName = fileName;
	}
}
