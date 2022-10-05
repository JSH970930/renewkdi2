package com.project.dto;





import com.project.entity.Image;
import com.project.entity.PubBook_Board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PubBook_BoardRequestDto {
	private Long id;
	private String title;
	private String content;
	private Long fileId;
	private String registerId;
	private String fileName;
	private String imageName;
	private Image image;
	
	public PubBook_Board toEntity() {
		return PubBook_Board.builder()
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
	    public PubBook_BoardRequestDto(Long id, String title, String content, Long fileId, String registerId, String fileName,
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
		return "pubbook_BoardRequestDto [id=" + id + ", title=" + title + ", content=" + content + ", registerId=" + registerId + "]";
	}

	

}