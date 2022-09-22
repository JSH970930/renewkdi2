package com.project.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.project.dto.MemberDto;
import com.project.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CheckUsernameValidator extends AbstractValidator<MemberDto>{
	
	private final MemberRepository memberRepository;
	
	@Override
	protected void doValidate(MemberDto memberdto, Errors errors) {
		
		if(memberRepository.existsByUsername(memberdto.toEntity().getUsername())) {
			errors.rejectValue("username", "아이디 중복 오류", "이미 사용중인 아이디입니다.");
		}
		
	}
		

}
