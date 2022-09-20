package com.project.controller;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.dto.MemberDto;
import com.project.service.MemberService;
import com.project.validator.CheckEmailValidator;
import com.project.validator.CheckPasswordValidator;
import com.project.validator.CheckPhoneValidator;
import com.project.validator.CheckUsernameValidator;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(MemberController.class.getName());
	
	private final MemberService memberService;
	private final CheckUsernameValidator checkUsernameValidator;
	private final CheckEmailValidator checkEmailValidator;
	private final CheckPasswordValidator checkPasswordValidator;
	private final CheckPhoneValidator checkPhoneValidator;
	
	@InitBinder
	public void validatorBinder(WebDataBinder binder) {
		binder.addValidators(checkUsernameValidator);//아이디 유효성 검사
		binder.addValidators(checkEmailValidator);//이메일 유효성 검사
		binder.addValidators(checkPasswordValidator);//패스워드 유효성 검사
		binder.addValidators(checkPhoneValidator);//핸드폰 번호 유효성 검사
		
		
	}
	
	//회원가입 페이지
	@GetMapping("/register")
	public String createMemberForm(Model model) {
		model.addAttribute("memberDto", new MemberDto());//Dto객체를 새로 만들어 새로 가입하는 사용자의 정보를 담음
		return "member/login/register";
	}
	
	//회원가입 페이지에서 가입버튼 눌렀을 시
	@PostMapping("/register")
	public String createMember(@Valid MemberDto memberDto, Errors errors, Model model) {
		if(errors.hasErrors()) {//회원가입 도중 문제가 생겼을 시
			model.addAttribute("memberdto",memberDto);
			Map<String,String> validatorResult = memberService.validateHandling(errors);
			for (String key : validatorResult.keySet()) {
				model.addAttribute(key,validatorResult.get(key));//문제가 되는 부분을 model 객체에 담음
				LOGGER.error(key);
				LOGGER.error(validatorResult.get(key));
			}
			return "member/login/register";
		}
		
		memberService.createUser(memberDto);
		LOGGER.info("회원가입 완료");
		return "redirect:/main";
	}
	
	@GetMapping("/login")
	public String loginMember() {
		return "member/login/loginForm";
	}
	
	@GetMapping("/login/error")
	public String loginError(Model model) {
		model.addAttribute("errorMsg","아이디 또는 비밀번호를 다시 확인해 주세요.");
		return "member/login/loginForm";
	}
	@GetMapping("/findMember")
	public String findMember() {
		return "member/findMember";
	}
	
	@GetMapping("/updateMember")
	public String updateMemberForm(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String username = ((UserDetails) principal).getUsername();
		MemberDto memberDto = memberService.MemberRecord(username);
		model.addAttribute("memberDto",memberDto);
		return "member/updateMemberForm";
	}
	
	@PostMapping("/updateMember")
	public String updateMember(MemberDto memberDto, Model model) {
		String Password = memberDto.getPassword();
		if(!(Password).equals(memberDto.getPassword_confirm())
				|| Password.length()<8 || Password.length()>20) {
			model.addAttribute("memberdto",memberDto);
			model.addAttribute("valid_password", "비밀번호를 다시 확인해주세요.");
			return "member/updateMemberForm";
		}
		
		memberService.updateMember(memberDto);
		LOGGER.info("회원 정보 수정 완료");
		return "/main";
	}

}
