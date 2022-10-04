package com.project.service;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.dto.ImageDto;
import com.project.entity.Image;
import com.project.repository.ImageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageService {
    
	private final ImageRepository imageRepository;

    @Transactional
    public Long saveFile(Image image) {
        return imageRepository.save(image).getId();
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