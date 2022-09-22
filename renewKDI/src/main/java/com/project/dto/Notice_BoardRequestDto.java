package com.project.dto;

import com.project.entity.Notice_Board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Notice_BoardRequestDto {
	private Long id;
	private String title;
	private String content;
	private String registerId;
	
	public Notice_Board toEntity() {
		return Notice_Board.builder()
			.title(title)
			.content(content)
			.registerId(registerId)
			.build();
	}

	@Override
	public String toString() {
		return "Notice_BoardRequestDto [id=" + id + ", title=" + title + ", content=" + content + ", registerId=" + registerId
				+ "]";
	}

	

}
