package com.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.service.Notice_BoardService;
import com.project.service.Policy_BoardService;


import lombok.RequiredArgsConstructor;

	@Controller
	@RequiredArgsConstructor
	
	public class Total_BoardController {
		
		private final Notice_BoardService noticeboardService;
		private final Policy_BoardService policyboardService;
		 
		
		@GetMapping("/board/totalsearch")
		public String getBoardListPage(Model model,@RequestParam(value="searchKeyword", required = false) String searchKeyword
				, @RequestParam(required = false, defaultValue = "0") Integer page
				, @RequestParam(required = false, defaultValue = "5") Integer size) throws Exception {
			
			model.addAttribute("resultMap1", policyboardService.findByTitleIsContaining(page, size,searchKeyword));
			model.addAttribute("resultMap2", noticeboardService.findByTitleIsContaining(page, size,searchKeyword));
			model.addAttribute("searchKeyword", searchKeyword);
			
			
			return "/board/totalsearch";
			
			
}
		
		
		
}