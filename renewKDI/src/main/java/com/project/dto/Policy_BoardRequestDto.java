package com.project.dto;





import com.project.entity.Policy_Board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Policy_BoardRequestDto {
	private Long id;
	private String title;
	private String content;
	private Long fileId;
	private String registerId;
	private String fileName;
	
	public Policy_Board toEntity() {
		return Policy_Board.builder()
			.id(id)
			.title(title)
			.content(content)
			.fileId(fileId)
			.registerId(registerId)
			.fileName(fileName)
			.build();
	}
	
	  @Builder
	    public Policy_BoardRequestDto(Long id, String title, String content, Long fileId, String registerId, String fileName ) {
	        this.id = id;

	        this.title = title;
	        this.content = content;
	        this.fileId = fileId;
	        this.registerId = registerId;
	        this.fileName = fileName;

	    }


	@Override
	public String toString() {
		return "Policy_BoardRequestDto [id=" + id + ", title=" + title + ", content=" + content + ", registerId=" + registerId
				+ "]";
	}

	

}
