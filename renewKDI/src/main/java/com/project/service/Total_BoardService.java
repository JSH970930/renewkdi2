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

import com.project.dto.Notice_BoardRequestDto;
import com.project.dto.Notice_BoardResponseDto;
import com.project.dto.Policy_BoardResponseDto;

import com.project.dto.Total_BoardResponseDto;
import com.project.entity.Notice_Board;
import com.project.entity.Policy_Board;
import com.project.repository.Notice_BoardRepository;
import com.project.repository.Policy_BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Total_BoardService {
	
private final Policy_BoardRepository policyboardRepository;
private final Notice_BoardRepository noticeboardRepository;
	
	
	
	@Transactional(readOnly = true)
	public HashMap<String, Object> findAll(Integer page, Integer size) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").descending());
		
		Page<Policy_Board> policylist = policyboardRepository.findAll(pageRequest);
		resultMap.put("policylist", policylist.stream().map(Policy_BoardResponseDto::new).collect(Collectors.toList()));
		resultMap.put("policypaging", policylist.getPageable());
		resultMap.put("policytotalCnt", policylist.getTotalElements());
		resultMap.put("policytotalPage", policylist.getTotalPages());
	
		Page<Notice_Board> noticelist = noticeboardRepository.findAll(pageRequest);
		resultMap.put("list", noticelist.stream().map(Notice_BoardResponseDto::new).collect(Collectors.toList()));
		resultMap.put("paging", noticelist.getPageable());
		resultMap.put("totalCnt", noticelist.getTotalElements());
		resultMap.put("totalPage", noticelist.getTotalPages());
		
		return resultMap;
	}
	
	
	@Transactional
	public HashMap<String, Object> findByTitleContaining1(Integer page, Integer size, String searchKeyword) {
		// TODO Auto-generated method stub

		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
		
		Page<Policy_Board> policylist = policyboardRepository.findByTitleContaining(pageable, searchKeyword);
		resultMap.put("policylist", policylist.stream().map(Policy_BoardResponseDto::new).collect(Collectors.toList()));
		resultMap.put("policypaging", policylist.getPageable());
		resultMap.put("policytotalCnt", policylist.getTotalElements());
		resultMap.put("policytotalPage", policylist.getTotalPages());
		
		Page<Notice_Board> noticelist = noticeboardRepository.findByTitleContaining(pageable, searchKeyword);  
	     resultMap.put("list", noticelist.stream().map(Notice_BoardResponseDto::new).collect(Collectors.toList()));
	     resultMap.put("paging", noticelist.getPageable());
	     resultMap.put("totalCnt", noticelist.getTotalElements());
	     resultMap.put("totalPage", noticelist.getTotalPages());
	     
		return resultMap;
	}
	
	public Total_BoardResponseDto findById(Long id) {
		return new Total_BoardResponseDto(noticeboardRepository.findById(id).get());
	}
}
