package com.project.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.project.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CheckPasswordValidator extends AbstractValidator<MemberDto>{
	
	
	@Override
	protected void doValidate(MemberDto memberDto, Errors errors) {
		
		if(!(memberDto.getPassword()).equals(memberDto.getPassword_confirm())) {
			errors.rejectValue("password", "비밀번호 확인 오류", "비밀번호를 다시 확인해 주세요.");
		}
		
	}

}
