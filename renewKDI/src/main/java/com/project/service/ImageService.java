package com.project.service;


import org.springframework.stereotype.Service;

import com.project.dto.ImageDto;
import com.project.entity.Image;
import com.project.repository.ImageRepository;

import javax.transaction.Transactional;

@Service
public class ImageService {
    private ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Transactional
    public Long saveFile(ImageDto imageDto) {
        return imageRepository.save(imageDto.toEntity()).getId();
    }

    @Transactional
    public ImageDto getFile(Long id) {
        Image image = imageRepository.findById(id).get();

        ImageDto imageDto = ImageDto.builder()
                .id(id)
                .origImageName(image.getOrigImageName())
                .imageName(image.getImageName())
                .imagePath(image.getImagePath())
                .build();
        return imageDto;
    }
}