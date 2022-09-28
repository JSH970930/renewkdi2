package com.project.dto;



import java.time.LocalDate;

import com.project.entity.Economy_Board;

import lombok.Getter;

@Getter
public class Economy_BoardResponseDto {
	private Long id;
	private String title;
	private String content;
	private int readCnt;
	private Long fileId;
	private String fileName;
	private String registerId;
	private LocalDate registerTime;
	private Long imageId;
	private String imageName;
	
	public Economy_BoardResponseDto(Economy_Board entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.readCnt = entity.getReadCnt();
		this.fileId = entity.getFileId();
		this.fileName = entity.getFileName();
		this.registerId = entity.getRegisterId();
		this.registerTime = entity.getRegisterTime();
		this.imageId = entity.getImageId();
		this.imageName = entity.getImageName();
	}
	
	
	@Override
	public String toString() {
		return "Economy_BoardResponseDto [id=" + id + ", title=" + title + ", content=" + content + ", readCnt=" + readCnt
						+ ", fileId=" + fileId 	+ ", registerId=" + registerId+ ", registerTime=" + registerTime +
						", imageId" + imageId + ", imageName" + imageName + "]";
	}
}
