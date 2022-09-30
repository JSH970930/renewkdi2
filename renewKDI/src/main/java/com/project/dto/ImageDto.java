package com.project.dto;





import com.project.entity.Image;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ImageDto {
    private Long imageId;
    private String origImageName;
    private String imageName;
    private String imagePath;
    

    public Image toEntity() {
        Image build = Image.builder()
                .imageId(imageId)
                .origImageName(origImageName)
                .imageName(imageName)
                .imagePath(imagePath)
                .build();
        return build;
    }

    @Builder
    public ImageDto(Long imageId, String origImageName, String imageName, String imagePath) {
        this.imageId = imageId;
        this.origImageName = origImageName;
        this.imageName = imageName;
        this.imagePath = imagePath;
    }
}