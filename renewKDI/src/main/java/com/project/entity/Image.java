package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	private Long id;
	
	@Column(nullable = false)
	private String origImageName;
	
	@Column(nullable = false)
	private String imageName;
	
	@Column(nullable = false)
	private String imagePath;
	
	@Builder
	public Image (Long id, String origImageName, String imageName, String imagePath) {
		this.id = id;
		this.origImageName = origImageName;
		this.imageName = imageName;
		this.imagePath = imagePath;
	}
	
}
