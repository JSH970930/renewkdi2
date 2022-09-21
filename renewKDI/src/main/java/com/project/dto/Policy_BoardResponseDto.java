package com.project.dto;



import java.time.LocalDate;

import com.project.entity.Policy_Board;

import lombok.Getter;

@Getter
public class Policy_BoardResponseDto {
	private Long id;
	private String title;
	private String content;
	private int readCnt;
	private Long fileId;
	private String fileName;
	private String registerId;
	private LocalDate registerTime;
	
	public Policy_BoardResponseDto(Policy_Board entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.readCnt = entity.getReadCnt();
		this.fileId = entity.getFileId();
		this.fileName = entity.getFileName();
		this.registerId = entity.getRegisterId();
		this.registerTime = entity.getRegisterTime();
	}
	
	
	@Override
	public String toString() {
		return "Policy_BoardResponseDto [id=" + id + ", title=" + title + ", content=" + content + ", readCnt=" + readCnt
						+ ", fileId=" + fileId 	+ ", registerId=" + registerId+ ", registerTime=" + registerTime + "]";
	}
}
