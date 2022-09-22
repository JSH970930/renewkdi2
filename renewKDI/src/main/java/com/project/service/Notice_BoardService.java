package com.project.service;

import java.util.HashMap;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dto.Notice_BoardRequestDto;
import com.project.dto.Notice_BoardResponseDto;
import com.project.entity.Notice_Board;
import com.project.repository.Notice_BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Notice_BoardService {
	
private final Notice_BoardRepository boardRepository;
	
	@Transactional
	public Long save(Notice_BoardRequestDto boardSaveDto) {
		return boardRepository.save(boardSaveDto.toEntity()).getId();
	}
	
	@Transactional(readOnly = true)
	public HashMap<String, Object> findAll(Integer page, Integer size) {
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		Page<Notice_Board> list = boardRepository.findAll(PageRequest.of(page, size));
		resultMap.put("list", list.stream().map(Notice_BoardResponseDto::new).collect(Collectors.toList()));
		resultMap.put("paging", list.getPageable());
		resultMap.put("totalCnt", list.getTotalElements());
		resultMap.put("totalPage", list.getTotalPages());
		
		return resultMap;
	}
	
	@Transactional
	   public HashMap<String, Object> findByTitleContaining(Integer page, Integer size, String searchKeyword) {

	      HashMap<String, Object> resultMap = new HashMap<String, Object>();
	      Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
	      Page<Notice_Board> list = boardRepository.findByTitleContaining(pageable, searchKeyword);
	   
	      resultMap.put("list", list.stream().map(Notice_BoardResponseDto::new).collect(Collectors.toList()));
	      resultMap.put("paging", list.getPageable());
	      resultMap.put("totalCnt", list.getTotalElements());
	      resultMap.put("totalPage", list.getTotalPages());
	      
	      return resultMap;
	   }
	
	public Notice_BoardResponseDto findById(Long id) {
		return new Notice_BoardResponseDto(boardRepository.findById(id).get());
	}
	
	public int updateBoard(Notice_BoardRequestDto boardRequestDto) {
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
