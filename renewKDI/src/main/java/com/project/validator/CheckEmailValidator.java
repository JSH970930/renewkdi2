package com.project.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.project.dto.MemberDto;
import com.project.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CheckEmailValidator extends AbstractValidator<MemberDto>{
	
private final MemberRepository memberRepository;
	
	@Override
	protected void doValidate(MemberDto memberdto, Errors errors) {
		
		if(memberRepository.existsByEmail(memberdto.toEntity().getEmail())) {
			errors.rejectValue("email", "이메일 중복 오류", "이미 사용중인 이메일입니다.");
		}
		
	}

}
