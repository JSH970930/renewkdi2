package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="image")
public class Image {
	
	@Id
	@GeneratedValue
	@Column(name="imageId")
	private Long id;
	
	@Column(nullable = false)
	private String origImageName;
	
	@Column(nullable = false)
	private String imageName;
	
	@Column(nullable = false)
	private String imagePath;
	
	@OneToOne(mappedBy = "image")
	@ToString.Exclude
	private Economy_Board economy_Board;
	
	@Builder
	public Image (Long id, String origImageName, String imageName, String imagePath) {
		this.id = id;
		this.origImageName = origImageName;
		this.imageName = imageName;
		this.imagePath = imagePath;
	}
	
}
