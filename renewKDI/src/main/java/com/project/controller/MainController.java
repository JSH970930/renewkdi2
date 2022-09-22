package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	
	@GetMapping("/main")
	public String mainPage() {
		return "/main/main";
	}
	
	//관리자 전용 페이지 확인용(추후 삭제함)
	@GetMapping("/admin/test")
	public String test() {
		return "/admin/test";
	}

}
