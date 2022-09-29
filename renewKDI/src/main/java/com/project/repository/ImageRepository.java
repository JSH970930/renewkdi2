package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{
	
}
