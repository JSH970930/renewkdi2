package com.project.controller;

import org.springframework.data.domain.Pageable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.dto.Notice_BoardRequestDto;
import com.project.dto.Notice_BoardResponseDto;
import com.project.service.Notice_BoardService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class Notice_BoardController {
	
	private final Notice_BoardService boardService;
	
	@GetMapping("/board/notice/list")
	public String getBoardListPage(Model model, String searchKeyword, Pageable pageable 
			, @RequestParam(required = false, defaultValue = "0") Integer page
			, @RequestParam(required = false, defaultValue = "5") Integer size) throws Exception {
		
		 if(searchKeyword == null) {
		
		try {
			model.addAttribute("resultMap", boardService.findAll(page, size));
		} catch (Exception e) {
			throw new Exception(e.getMessage()); 
		}
		
		} else {
			model.addAttribute("resultMap", boardService.findByTitleContaining(page, size, searchKeyword));
		}

		return "/board/notice/list";
	}
	
	@GetMapping("/board/notice/write")
	public String getBoardWritePage(Model model, Notice_BoardRequestDto boardRequestDto) {
		return "/board/notice/write";
		
	}
	
	@GetMapping("/board/notice/view")
	public String getBoardViewPage(Model model, Notice_BoardRequestDto boardRequestDto) throws Exception {
		
		try {
			if(boardRequestDto.getId() != null) {
				model.addAttribute("info", boardService.findById(boardRequestDto.getId()));
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage()); 
		}
		
		return "/board/notice/view";
	}
	
	@PostMapping("/board/notice/write/action")
	public String boardWriteAction(Model model, Notice_BoardRequestDto boardRequestDto) throws Exception {
		
		try {
			Long result = boardService.save(boardRequestDto);
			
			if (result < 0) {
				throw new Exception("#Exception boardWriteAction!");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage()); 
		}
		
		return "redirect:/board/notice/list";
	}
	
	@PostMapping("/board/notice/view/action")
	public String boardViewAction(Model model, Notice_BoardRequestDto boardRequestDto) throws Exception {
		
		try {
			int result = boardService.updateBoard(boardRequestDto);
			
			if (result < 1) {
				throw new Exception("#Exception boardViewAction!");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage()); 
		}
		
		return "redirect:/board/notice/list";
	}
	
	@PostMapping("/board/notice/view/delete")
	public String boardViewDeleteAction(Model model, @RequestParam() Long id) throws Exception {
		
		try {
			boardService.deleteById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage()); 
		}
		
		return "redirect:/board/notice/list";
	}
	
	@PostMapping("/board/notice/delete")
	public String boardDeleteAction(Model model, @RequestParam() Long[] deleteId) throws Exception {
		
		try {
			boardService.deleteAll(deleteId);
		} catch (Exception e) {
			throw new Exception(e.getMessage()); 
		}
		
		return "redirect:/board/notice/list";
	}
}

