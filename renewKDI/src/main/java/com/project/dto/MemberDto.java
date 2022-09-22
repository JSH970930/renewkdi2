package com.project.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.entity.Member;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {
	
	
	private Long id;
	
	@NotEmpty
	@Length(min=8, max=20, message = "비밀번호는 8자 이상, 20자 이하로 입력해주세요")
	private String password;
	
	private String password_confirm;
	
	@NotBlank(message = "아이디는 필수 입력 값입니다.")
	private String username;
	
	@NotBlank(message = "이름은 필수 입력 값입니다.")
	private String name;
	
	private String birthYear;
	
	private String birthMonth;
	
	private String birthDay;
	
	private String birth;
	
	private String phoneHead;
	
	private String phoneMid;
	
	private String phoneTail;
	
	private String phone;
	
	@Email
	@NotBlank(message = "이메일은 필수 입력 값입니다.")
	private String email;
	
	private String job;
	
	private String fax;
	
	private String postcode;
	
	@NotBlank(message = "주소는 필수 입력 값입니다.")
	private String address;
	
	private String detailAddress;
	
	private String extraAddress;
	
	private String department;
	
	private String role;

	@Builder
	public MemberDto(Long id, String password, String password_confirm, String username, String name, String birthYear,
			String birthMonth, String birthDay, String birth, String phoneHead, String phoneMid, String phoneTail, String phone, String email, String job,
			String fax, String postcode, String address, String detailAddress, String extraAddress, String department) {
		super();
		this.id = id;
		this.password = password;
		this.password_confirm = password;
		this.username = username;
		this.name = name;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
		this.birth = birth;
		this.phoneHead = phoneHead;
		this.phoneMid = phoneMid;
		this.phoneTail = phoneTail;
		this.phone = phone;
		this.email = email;
		this.job = job;
		this.fax = fax;
		this.postcode = postcode;
		this.address = address;
		this.detailAddress = detailAddress;
		this.extraAddress = extraAddress;
		this.department = department;
		
	}

	public Member toEntity() {
		this.role = "USER";//관리자 계정 생성을 원하면 USER 대신 ADMIN으로 변경한 후 회원가입
		if(birth == null) {
			if(birthMonth.length()==1) {
				birthMonth = "0"+birthMonth;
			}
			if(birthDay.length()==1) {
				birthDay = "0"+birthDay;
			}
			this.birth = birthYear + "." + birthMonth + "." + birthDay;
		}//생년월일을 YYYY.MM.DD형식으로 저장
		if(phoneMid==null) {
			phoneMid="";
		}
		if(phoneTail==null) {
			phoneTail="";
		}//NullPointerException 방지를 위해 ""으로 변경함
		if(phone == null) {
			this.phone = phoneHead+phoneMid.toString()+phoneTail.toString();
		}
			//휴대폰번호를 3,4,4자로 받은걸 11자리로 합치는 작업
		return Member.builder()
				.id(id)
				.password(new BCryptPasswordEncoder().encode(password))
				.username(username)
				.name(name)
				.birth(birth)
				.phone(phone)
				.email(email)
				.job(job)
				.fax(fax)
				.postcode(postcode)
				.address(address)
				.detailAddress(detailAddress)
				.extraAddress(extraAddress)
				.department(department)
				.role(role)
				.build();
	}
	
	
	

}
