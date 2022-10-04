package com.project.dto;





import com.project.entity.Economy_Board;
import com.project.entity.Expert_Board;
import com.project.entity.Image;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ImageDto {
    private Long id;
    private String origImageName;
    private String imageName;
    private String imagePath;
    private Economy_Board economy_Board;
    private Expert_Board expert_Board;
    

    public Image toEntity() {
        Image build = Image.builder()
                .id(id)
                .origImageName(origImageName)
                .imageName(imageName)
                .imagePath(imagePath)
                .economy_Boards(economy_Board)
                .expert_Boards(expert_Board)
                .build();
        return build;
    }
    
    

    @Builder
    public ImageDto(Long id, String origImageName, String imageName, String imagePath, Economy_Board economy_Board, Expert_Board expert_Board) {
        this.id = id;
        this.origImageName = origImageName;
        this.imageName = imageName;
        this.imagePath = imagePath;
        this.economy_Board = economy_Board;
        this.expert_Board = expert_Board;
    }
    
    
}