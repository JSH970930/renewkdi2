package com.project.service;


import org.springframework.stereotype.Service;

import com.project.dto.FileDto;
import com.project.entity.File;
import com.project.repository.Economy_BoardRepository;
import com.project.repository.FileRepository;
import com.project.repository.ImageRepository;

import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class FileService {
	
    private final FileRepository fileRepository;


    @Transactional
    public Long saveFile(FileDto fileDto) {
        return fileRepository.save(fileDto.toEntity()).getId();
    }

    @Transactional
    public FileDto getFile(Long id) {
        File file = fileRepository.findById(id).get();

        FileDto fileDto = FileDto.builder()
                .id(id)
                .origFilename(file.getOrigFilename())
                .filename(file.getFilename())
                .filePath(file.getFilePath())
                .build();
        return fileDto;
    }
}