package com.project.dto;





import com.project.entity.Image;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ImageDto {
    private Long id;
    private String origImageName;
    private String imageName;
    private String imagePath;
    

    public Image toEntity() {
        Image build = Image.builder()
                .id(id)
                .origImageName(origImageName)
                .imageName(imageName)
                .imagePath(imagePath)
                .build();
        return build;
    }

    @Builder
    public ImageDto(Long id, String origImageName, String imageName, String imagePath) {
        this.id = id;
        this.origImageName = origImageName;
        this.imageName = imageName;
        this.imagePath = imagePath;
    }
}