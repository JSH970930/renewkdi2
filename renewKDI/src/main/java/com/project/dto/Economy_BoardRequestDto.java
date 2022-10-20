package com.project.dto;





import com.project.entity.Economy_Board;
import com.project.entity.Image;
import com.project.entity.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Economy_BoardRequestDto {
	private Long id;
	private String title;
	private String content;
	private Long fileId;
	private String registerId;
	private String fileName;
	private String imageName;
	private Image image;
	
	public Economy_Board toEntity() {
		return Economy_Board.builder()
			.id(id)
			.title(title)
			.content(content)
			.fileId(fileId)
			.registerId(registerId)
			.fileName(fileName)
			.image(image)
			.build();
	}
	
	  @Builder
	    public Economy_BoardRequestDto(Long id, String title, String content, Long fileId, String registerId, String fileName,
	    		Long imageId, String imageName, Image image) {
	        this.id = id;
	        this.title = title;
	        this.content = content;
	        this.fileId = fileId;
	        this.registerId = registerId;
	        this.fileName = fileName;
	        this.image = image;

	    }


	@Override
	public String toString() {
		return "economy_BoardRequestDto [id=" + id + ", title=" + title + ", content=" + content + ", registerId=" + registerId + "]";
	}

	

}
