package com.project.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
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
@Table(name="expert_board")
@SequenceGenerator(
		  name = "EXPERT_BOARD_SEQ_GENERATOR", 
		  sequenceName = "EXPERT_BOARD_SEQ",
		  initialValue = 1,
		  allocationSize = 1)
public class Expert_Board extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "EXPERT_BOARD_SEQ_GENERATOR")
	@Column(name="expert_id")
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
	public Expert_Board(Long id, String title, String content, int readCnt, Long fileId, 
			String registerId, String fileName, Image image) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.readCnt = readCnt;
		this.fileId = fileId;
		this.registerId = registerId;
		this.fileName = fileName;
		this.image = image;
		
	}
}