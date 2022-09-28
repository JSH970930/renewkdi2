package com.project.dto;





import com.project.entity.Economy_Board;

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
	private Long imageId;
	private String imageName;
	
	public Economy_Board toEntity() {
		return Economy_Board.builder()
			.id(id)
			.title(title)
			.content(content)
			.fileId(fileId)
			.registerId(registerId)
			.fileName(fileName)
			.imageId(imageId)
			.imageName(imageName)
			.build();
	}
	
	  @Builder
	    public Economy_BoardRequestDto(Long id, String title, String content, Long fileId, String registerId, String fileName,
	    		Long imageId, String imageName) {
	        this.id = id;
	        this.title = title;
	        this.content = content;
	        this.fileId = fileId;
	        this.registerId = registerId;
	        this.fileName = fileName;
	        this.imageId = imageId;
	        this.imageName = imageName;

	    }


	@Override
	public String toString() {
		return "Policy_BoardRequestDto [id=" + id + ", title=" + title + ", content=" + content + ", registerId=" + registerId
				+ ", imageId" + imageId + ", imageName" + imageName +"]";
	}

	

}
