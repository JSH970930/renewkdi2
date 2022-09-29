package com.project.dto;





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
	private Long readcnt;
	private Long fileid;
	private String registerId;
	private String filename;
	private Long imageid;
	private String imageName;
	
	public PubBook_Board toEntity() {
		return PubBook_Board.builder()
			.id(id)
			.title(title)
			.content(content)
			.readcnt(readcnt)
			.fileid(fileid)
			.registerId(registerId)
			.filename(filename)
			.imageid(imageid)
			.imageName(imageName)
			.build();
	}
	 @Builder
	    public PubBook_BoardRequestDto(Long id, String title, String content,Long readcnt,Long fileid, String registerId, String filename,
	    		Long imageid, String imageName) {
	        this.id = id;
	        this.title = title;
	        this.content = content;
	        this.readcnt = readcnt;
	        this.fileid = fileid;
	        this.registerId = registerId;
	        this.filename = filename;
	        this.imageid = imageid;
	        this.imageName = imageName;

	    }


	@Override
	public String toString() {
		return "PubBook_BoardRequestDto [id=" + id + ", title=" + title + ", content=" + content + ",readcnt=" + readcnt +", fileid=" + fileid +", registerId=" + registerId
				+ ", imageid" + imageid + ", imageName" + imageName +"]";
	}


	

}