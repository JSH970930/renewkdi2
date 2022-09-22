package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.project.dto.MemberDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="member")
@Getter @Setter
@ToString
@NoArgsConstructor
@SequenceGenerator(
		name = "MEMBER_SEQUENCE_GENERATOR",
		sequenceName = "MEMBER_SEQ",
		initialValue = 1,
		allocationSize = 1)
public class Member extends BaseTimeEntity{
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "MEMBER_SEQUENCE_GENERATOR")
	private Long id;
	
	private String password;
	
	private String username;
	
	private String name;
	
	private String birth;
	
	private String phone;
	
	private String email;
	
	private String job;
	
	private String fax;
	
	private String postcode;
	
	private String address;
	
	private String detailAddress;
	
	private String extraAddress;
	
	private String department;
	
	private String role;
	

	@Builder
	public Member(Long id, String password, String password_confirm, String username, String name, String birthYear,
			String birthMonth, String birthDay, String birth, String phone, String email, String job, String fax,
			String postcode, String address, String detailAddress, String extraAddress, String department,
			String role) {
		super();
		this.id = id;
		this.password = password;
		this.username = username;
		this.name = name;
		this.birth = birth;
		this.phone = phone;
		this.email = email;
		this.job = job;
		this.fax = fax;
		this.postcode = postcode;
		this.address = address;
		this.detailAddress = detailAddress;
		this.extraAddress = extraAddress;
		this.department = department;
		this.role = role;
	}
	
	public MemberDto toMemberDto(Member member) {
		MemberDto memberDto = new MemberDto();
		memberDto.setId(member.id);
		memberDto.setUsername(member.username);
		memberDto.setName(member.name);
		memberDto.setBirth(member.birth);
		memberDto.setPhone(member.phone);
		memberDto.setEmail(member.email);
		memberDto.setFax(member.fax);
		memberDto.setPostcode(member.postcode);
		memberDto.setAddress(member.address);
		memberDto.setDetailAddress(member.detailAddress);
		memberDto.setExtraAddress(member.extraAddress);
		memberDto.setDepartment(member.department);
		memberDto.setRole(member.role);
		
		return memberDto;
		
		
	}
	
	

}
