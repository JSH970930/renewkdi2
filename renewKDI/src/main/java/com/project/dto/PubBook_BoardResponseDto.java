package com.project.dto;



import java.time.LocalDate;

import com.project.entity.PubBook_Board;

import lombok.Getter;

@Getter
public class PubBook_BoardResponseDto {
	private Long id;
	private String title;
	private String content;
	private Long readcnt;
	private Long fileid;
	private String filename;
	private String registerId;
	private LocalDate registerTime;
	private Long imageid;
	private String imageName;
	
	public PubBook_BoardResponseDto(PubBook_Board entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.readcnt = entity.getReadcnt();
		this.fileid = entity.getFileid();
		this.filename = entity.getFilename();
		this.registerId = entity.getRegisterId();
		this.registerTime = entity.getRegisterTime();
		this.imageid = entity.getImageid();
		this.imageName = entity.getImageName();
	}
	
	
	@Override
	public String toString() {
		return "PubBook_BoardResponseDto [id=" + id + ", title=" + title + ", content=" + content + ", readcnt=" + readcnt
						+ ", fileid=" + fileid 	+ ", filename=" +filename +", registerId=" + registerId+ ", registerTime=" + registerTime +
						", imageid" + imageid + ", imageName" + imageName + "]";
	}
}
