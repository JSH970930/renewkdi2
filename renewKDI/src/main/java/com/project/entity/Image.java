package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image {
	
	@Id
	@GeneratedValue
	private Long imageId;
	
	@Column(nullable = false)
	private String origImageName;
	
	@Column(nullable = false)
	private String imageName;
	
	@Column(nullable = false)
	private String imagePath;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="economy_id")
	private Economy_Board economy_board;
	
	@Builder
	public Image (Long imageId, String origImageName, String imageName, String imagePath) {
		this.imageId = imageId;
		this.origImageName = origImageName;
		this.imageName = imageName;
		this.imagePath = imagePath;
	}
	
}
