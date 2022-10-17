package com.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.service.Expert_BoardService;
import com.project.service.Notice_BoardService;
import com.project.service.Policy_BoardService;
import com.project.service.PubBook_BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

public class Total_BoardController {

	private final Notice_BoardService noticeboardService;
	private final Policy_BoardService policyboardService;
	private final PubBook_BoardService pubbookboardService;
	private final Expert_BoardService expertboardService;

	@GetMapping("/board/totalsearch")
	public String getBoardListPage(Model model,
			@RequestParam(value = "searchKeyword", required = false) String searchKeyword,
			@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(required = false, defaultValue = "5") Integer size) throws Exception {

		model.addAttribute("resultMap1", policyboardService.findByTitleIsContaining(page, size, searchKeyword));
		model.addAttribute("resultMap2", noticeboardService.findByTitleIsContaining(page, size, searchKeyword));
		model.addAttribute("BresultMap", pubbookboardService.FindByTitleContaining(page, size, searchKeyword));
		model.addAttribute("RresultMap", expertboardService.FindByTitleContaining(page, size, searchKeyword));
		model.addAttribute("searchKeyword", searchKeyword);

		return "/board/totalsearch";

	}

	@GetMapping("/board/detailsearch")
	public String getBoardListPage(Model model,
			@RequestParam(value = "searchKeyword", required = false) String searchKeyword, Pageable pageable,
			@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(required = false, defaultValue = "5") Integer size,
			@RequestParam(value = "chk", required = false) List<String> searchchk,
			@RequestParam(value = "chk2", required = false) List<String> searchchk2) throws Exception {

		pageable = PageRequest.of(page, size, Sort.by("id").descending());

		if (searchKeyword == null) {

			try {
				model.addAttribute("PresultMap", policyboardService.FindAll(pageable));
				model.addAttribute("BresultMap", pubbookboardService.FindAll(page, size));
				model.addAttribute("RresultMap", expertboardService.FindAll(page, size));

			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}

		} else if (type == "title") {
			model.addAttribute("resultMap1", policyboardService.findByTitleContaining(pageable, searchKeyword));
			model.addAttribute("BresultMap", pubbookboardService.FindByTitleContaining(page, size, searchKeyword));
			model.addAttribute("RresultMap", expertboardService.FindByTitleContaining(page, size, searchKeyword));

		} else {
			model.addAttribute("PresultMap", policyboardService.FindByContentContaining(pageable, searchKeyword));
			model.addAttribute("BresultMap", pubbookboardService.FindByContentContaining(pageable, searchKeyword));
			model.addAttribute("RresultMap", expertboardService.FindByContentContaining(pageable, searchKeyword));
			
		}

		model.addAttribute("resultMap2", noticeboardService.findByTitleIsContaining(page, size, searchKeyword));
		model.addAttribute("searchKeyword", searchKeyword);

		model.addAttribute("searchchk", searchchk);
		model.addAttribute("searchchk2", searchchk2);

		System.out.println(searchchk);

		return "/board/detailsearch";

	}

}