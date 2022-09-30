package com.project.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="economy_board")
public class Economy_Board extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="economy_id")
	private Long id;
	
	private String title;
	
	@Lob
	@Column(nullable = false)
	private String content;
	
	private int readCnt;
	private String registerId;
	private Long fileId;
	private String fileName;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="imageId")
	@ToString.Exclude
	private Image image;
	
	
	
	@Builder
	public Economy_Board(Long id, String title, String content, int readCnt, Long fileId, 
			String registerId, String fileName) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.readCnt = readCnt;
		this.fileId = fileId;
		this.registerId = registerId;
		this.fileName = fileName;
		
	}
}
