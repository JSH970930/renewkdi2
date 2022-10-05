package com.project.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="image")
@SequenceGenerator(
		  name = "IMAGE_SEQ_GENERATOR", 
		  sequenceName = "IMAGE_BOARD_SEQ",
		  initialValue = 1,
		  allocationSize = 1)
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "IMAGE_SEQ_GENERATOR")
	@Column(name="imageId")
	private Long id;
	
	@Column(nullable = false)
	private String origImageName;
	
	@Column(nullable = false)
	private String imageName;
	
	@Column(nullable = false)
	private String imagePath;
	
	private String imageUrl;
	
	@ToString.Exclude
	@OneToOne(mappedBy = "image")
	private Economy_Board economy_Boards;
	
	@ToString.Exclude
	@OneToOne(mappedBy = "image")
	private PubBook_Board pubbook_Boards;
	
	@ToString.Exclude
	@OneToOne(mappedBy = "image")
	private Expert_Board expert_Boards;
	
	@Builder
	public Image (Long id, String origImageName, String imageName, String imagePath, String imageUrl,Economy_Board economy_Boards,Expert_Board expert_Boards, PubBook_Board pubbook_Board) {
		this.id = id;
		this.origImageName = origImageName;
		this.imageName = imageName;
		this.imagePath = imagePath;
		this.economy_Boards =economy_Boards;
		this.expert_Boards =expert_Boards;
		this.pubbook_Boards = pubbook_Board;
		this.imageUrl = imageUrl;
	}
	
}
