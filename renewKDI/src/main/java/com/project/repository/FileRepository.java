package com.project.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.File;



public interface FileRepository extends JpaRepository<File, Long> {

}
