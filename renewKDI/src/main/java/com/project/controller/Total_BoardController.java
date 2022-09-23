package com.project.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.dto.Notice_BoardRequestDto;
import com.project.dto.Policy_BoardRequestDto;

import com.project.dto.Total_BoardResponseDto;
import com.project.service.Total_BoardService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

	@Controller
	@RequiredArgsConstructor
	public class Total_BoardController {
		
		private final Total_BoardService totalboardService;
		
		
		 
		
		@GetMapping("/board/totalsearch")
		public String getBoardListPage(Model model, String searchKeyword, Pageable pageable 
				, @RequestParam(required = false, defaultValue = "0") Integer page
				, @RequestParam(required = false, defaultValue = "5") Integer size) throws Exception {
			
			 if(searchKeyword == null) {
			
				 try {
					 model.addAttribute("resultMap", totalboardService.findAll(page, size));
				 } catch (Exception e) {
					 throw new Exception(e.getMessage()); 
				 }
			
			}else {
				model.addAttribute("resultMap", totalboardService.findByTitleContaining1(page, size, searchKeyword));
			}
			 
			

			return "/board/totalsearch";
		}
		
	
		@GetMapping("/board/totalview")
		public String getBoardViewPage(Model model, Total_BoardResponseDto boardRequestDto) throws Exception {
			
			try {
				if(boardRequestDto.getId() != null) {
					model.addAttribute("info", totalboardService.findById(boardRequestDto.getId()));
				}
			} catch (Exception e) {
				throw new Exception(e.getMessage()); 
			}
			
			return "/board/notice/view";
		}

}
