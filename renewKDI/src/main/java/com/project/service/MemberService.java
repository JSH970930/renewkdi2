package com.project.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.project.controller.MemberController;
import com.project.dto.MemberDto;
import com.project.entity.Member;
import com.project.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService implements UserDetailsService{

	private final MemberRepository memberRepository;
	
	private final Logger LOGGER = LoggerFactory.getLogger(MemberController.class.getName());
	
	@Transactional
	public Long createUser(MemberDto memberdto) {
		Member member = memberdto.toEntity();
		memberRepository.save(member);
		return member.getId();
		
	}
	//오류 발생시 실행
	@Transactional
	public Map<String,String> validateHandling(Errors errors){
		Map<String,String> validateResult = new HashMap<>();
		
		for(FieldError error : errors.getFieldErrors()) {
			String ValidKeyName = String.format("valid_%s", error.getField());//오류 메세지를 valid_""에 담음
			validateResult.put(ValidKeyName, error.getDefaultMessage());
		}
		
		return validateResult;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Member member = memberRepository.findByUsername(username);
	if(member == null){
	throw new UsernameNotFoundException(username);
	}
	return User.builder()
	.username(member.getUsername())
	.password(member.getPassword())
	.roles(member.getRole())
	.build();
	}
	
	@Transactional
	public MemberDto MemberRecord(String username) {
		Member member = memberRepository.findByUsername(username);
		MemberDto memberDto = member.toMemberDto(member);
		return memberDto;
	}
	
	@Transactional
	public Long updateMember(MemberDto memberDto) {
		Member member = memberDto.toEntity();
		memberRepository.save(member);
		return member.getId();
	}
	
	

}
