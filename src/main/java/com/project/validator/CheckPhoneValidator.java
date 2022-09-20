package com.project.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.project.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CheckPhoneValidator extends AbstractValidator<MemberDto>{
	
	@Override
	protected void doValidate(MemberDto memberdto, Errors errors) {
		
		if(memberdto.getPhoneHead()=="" || memberdto.getPhoneMid().length() !=4 || memberdto.getPhoneTail().length() !=4) {//휴대폰 번호가 완전하지 않을경우 출력
			errors.rejectValue("phone", "휴대폰 번호 입력 오류", "휴대폰 번호를 다시 확인해 주세요.");
		}
		
	}

}
