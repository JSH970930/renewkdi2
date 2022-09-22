package com.project.dto;

import java.time.LocalDate;

import com.project.entity.Notice_Board;

import lombok.Getter;

@Getter
public class Notice_BoardResponseDto {
	private Long id;
	private String title;
	private String content;
	private int readCnt;
	private String registerId;
	private LocalDate registerTime;
	
	public Notice_BoardResponseDto(Notice_Board entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.readCnt = entity.getReadCnt();
		this.registerId = entity.getRegisterId();
		this.registerTime = entity.getRegisterTime();
	}
	
	@Override
	public String toString() {
		return "Notice_BoardResponseDto [id=" + id + ", title=" + title + ", content=" + content + ", readCnt=" + readCnt
						+ ", registerId=" + registerId + ", registerTime=" + registerTime + "]";
	}
}
