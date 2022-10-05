package com.project.service;



import java.util.HashMap;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dto.Economy_BoardRequestDto;
import com.project.dto.Economy_BoardResponseDto;
import com.project.dto.PubBook_BoardRequestDto;
import com.project.dto.PubBook_BoardResponseDto;
import com.project.entity.Economy_Board;
import com.project.entity.Image;
import com.project.entity.PubBook_Board;
import com.project.repository.ImageRepository;
import com.project.repository.PubBook_BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PubBook_BoardService {
	
	private final PubBook_BoardRepository boardRepository;
	private final ImageRepository imageRepository;
	
	@Autowired
	EntityManager em;
	
	@Transactional
	public Long save(PubBook_BoardRequestDto boardSaveDto, Long id) {
		Image image = imageRepository.getById(id);
		em.persist(image);
		boardSaveDto.setImage(image);
		return boardRepository.save(boardSaveDto.toEntity()).getId();
	}
	
	@Transactional(readOnly = true)
	public HashMap<String, Object> findAll(Integer page, Integer size) {
		
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").descending());
		Page<PubBook_Board> list = boardRepository.findAll(pageRequest);
		
		resultMap.put("list", list.stream().map(PubBook_BoardResponseDto::new).collect(Collectors.toList()));
		resultMap.put("paging", list.getPageable());
		resultMap.put("totalCnt", list.getTotalElements());
		resultMap.put("totalPage", list.getTotalPages());
		
		return resultMap;
	}
	@Transactional
	public HashMap<String, Object> findByTitleContaining(Integer page, Integer size, String searchKeyword) {
		// TODO Auto-generated method stub

		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
		Page<PubBook_Board> list = boardRepository.findByTitleContaining(pageable, searchKeyword);
	
		resultMap.put("list", list.stream().map(PubBook_BoardResponseDto::new).collect(Collectors.toList()));
		resultMap.put("paging", list.getPageable());
		resultMap.put("totalCnt", list.getTotalElements());
		resultMap.put("totalPage", list.getTotalPages());
		
		return resultMap;
	}
	
	@Transactional
	public PubBook_BoardRequestDto getPost(Long id) {
		PubBook_Board board = boardRepository.findById(id).get();

		PubBook_BoardRequestDto boardRequestDto = PubBook_BoardRequestDto.builder()
	            .id(board.getId())
	            .title(board.getTitle())
	            .content(board.getContent())
	            .fileId(board.getFileId())
	            .registerId(board.getRegisterId())
	            .fileName(board.getFileName())
	            

	            .build();
	    return boardRequestDto;
	}
	
	
	
	
	public PubBook_BoardResponseDto findById(Long id) {
		return new PubBook_BoardResponseDto(boardRepository.findById(id).get());
	}
	
	public int updateBoard(PubBook_BoardRequestDto boardRequestDto) {
		return boardRepository.updateBoard(boardRequestDto);
	}
	
	public int updateBoardReadCntInc(Long id) {
		return boardRepository.updateBoardReadCntInc(id);
	}
	
	public void deleteById(Long id) {
		boardRepository.deleteById(id);
	}
	
	public void deleteAll(Long[] deleteId) {
		boardRepository.deleteBoard(deleteId);
	}


	
}

