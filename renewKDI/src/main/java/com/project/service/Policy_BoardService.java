package com.project.service;



import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dto.Policy_BoardRequestDto;
import com.project.dto.Policy_BoardResponseDto;
import com.project.entity.Policy_Board;
import com.project.repository.Policy_BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Policy_BoardService {
	
private final Policy_BoardRepository boardRepository;
	
	@Transactional
	public Long save(Policy_BoardRequestDto boardSaveDto) {
		return boardRepository.save(boardSaveDto.toEntity()).getId();
	}
	
	@Transactional(readOnly = true)
	public HashMap<String, Object> findAll(Pageable pageable) {
		
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		Page<Policy_Board> list = boardRepository.findAll(pageable);
		
		
		resultMap.put("list", list.stream().map(Policy_BoardResponseDto::new).collect(Collectors.toList()));
		resultMap.put("paging", list.getPageable());
		resultMap.put("First", list.isFirst());
		resultMap.put("Last", list.isLast());
		resultMap.put("totalCnt", list.getTotalElements());
		resultMap.put("totalPage", list.getTotalPages());
	
		
		
		return resultMap;
	}
	
	@Transactional(readOnly = true)
	public HashMap<String, Object> FindAll(Pageable pageable) {
		
		
		HashMap<String, Object> PresultMap = new HashMap<String, Object>();
		
		Page<Policy_Board> list = boardRepository.findAll(pageable);
		
		
		PresultMap.put("list", list.stream().map(Policy_BoardResponseDto::new).collect(Collectors.toList()));
		PresultMap.put("paging", list.getPageable());
		PresultMap.put("First", list.isFirst());
		PresultMap.put("Last", list.isLast());
		PresultMap.put("totalCnt", list.getTotalElements());
		PresultMap.put("totalPage", list.getTotalPages());
	
		
		
		return PresultMap;
	}
	
	@Transactional
	public HashMap<String, Object> findByTitleContaining(Pageable pageable, String searchKeyword) {
		// TODO Auto-generated method stub

		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		Page<Policy_Board> list = boardRepository.findByTitleContaining(pageable, searchKeyword);
	
		resultMap.put("list", list.stream().map(Policy_BoardResponseDto::new).collect(Collectors.toList()));
		resultMap.put("paging", list.getPageable());
		resultMap.put("totalCnt", list.getTotalElements());
		resultMap.put("totalPage", list.getTotalPages());
		
		return resultMap;
	}

	@Transactional
	public HashMap<String, Object> findByTitleIsContaining(Integer page, Integer size, String searchKeyword) {
		// TODO Auto-generated method stub

		HashMap<String, Object> resultMap1 = new HashMap<String, Object>();
		Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
		Page<Policy_Board> list = boardRepository.findByTitleContaining(pageable, searchKeyword);
			
		resultMap1.put("list", list.stream().map(Policy_BoardResponseDto::new).collect(Collectors.toList()));
		resultMap1.put("paging", list.getPageable());
		resultMap1.put("totalCnt", list.getTotalElements());
		resultMap1.put("totalPage", list.getTotalPages());
		return resultMap1;
	}
	
	@Transactional
	   public HashMap<String, Object> findByContentContaining(Pageable pageable, String searchKeyword) {
	      // TODO Auto-generated method stub

	      HashMap<String, Object> resultMap = new HashMap<String, Object>();
	     
	      Page<Policy_Board> list = boardRepository.findByContentContaining(pageable, searchKeyword);
	   
	      resultMap.put("list", list.stream().map(Policy_BoardResponseDto::new).collect(Collectors.toList()));
	      resultMap.put("paging", list.getPageable());
	      resultMap.put("totalCnt", list.getTotalElements());
	      resultMap.put("totalPage", list.getTotalPages());
	      
	      return resultMap;
	   }
	
	@Transactional
	   public HashMap<String, Object> FindByContentContaining(Pageable pageable, String searchKeyword) {
	      // TODO Auto-generated method stub

	      HashMap<String, Object> PresultMap = new HashMap<String, Object>();
	     
	      Page<Policy_Board> list = boardRepository.findByContentContaining(pageable, searchKeyword);
	   
	      PresultMap.put("list", list.stream().map(Policy_BoardResponseDto::new).collect(Collectors.toList()));
	      PresultMap.put("paging", list.getPageable());
	      PresultMap.put("totalCnt", list.getTotalElements());
	      PresultMap.put("totalPage", list.getTotalPages());
	      
	      return PresultMap;
	   }
	   
	
	@Transactional
	public Policy_BoardRequestDto getPost(Long id) {
		Policy_Board board = boardRepository.findById(id).get();

		Policy_BoardRequestDto boardRequestDto = Policy_BoardRequestDto.builder()
	            .id(board.getId())

	            .title(board.getTitle())
	            .content(board.getContent())
	            .fileId(board.getFileId())
	            .registerId(board.getRegisterId())
	            .fileName(board.getFileName())

	            .build();
	    return boardRequestDto;
	}
	
	
	
	
	public Policy_BoardResponseDto findById(Long id) {
		return new Policy_BoardResponseDto(boardRepository.findById(id).get());
	}
	
	public int updateBoard(Policy_BoardRequestDto boardRequestDto) {
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

