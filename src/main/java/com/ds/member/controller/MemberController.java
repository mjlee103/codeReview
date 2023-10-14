package com.ds.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ds.member.dto.MemberDto;
import com.ds.member.service.MemberService;

@RestController
@RequestMapping("/main")
public class MemberController {
	// 기본형
	private final Logger log = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	// 회원번호로 한명의 회원 조회
	@PostMapping(value = "/login")
	public ResponseEntity<MemberDto> isMemberExist(@RequestBody MemberDto memberDto) {
		log.info("isMemberExist"+memberDto);
		MemberDto member = memberService.login(memberDto);
		return new ResponseEntity<MemberDto>(member, HttpStatus.OK);

	}

	@PostMapping(value = "/register")
	public ResponseEntity<MemberDto> registerMember(@RequestBody MemberDto memberDto) {
		log.info("registerMember" + memberDto);
		memberService.registerMember(memberDto);
		return new ResponseEntity<MemberDto>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/getMemberInf")
	public ResponseEntity<MemberDto> getMemberInf(@RequestBody MemberDto memberDto) {
		log.info("registerMember" + memberDto);
		MemberDto memberInfo=  memberService.getMemberInf(memberDto);
		return new ResponseEntity<MemberDto>(memberInfo, HttpStatus.OK);
	}
	
	@PostMapping(value = "/updateInf")
	public ResponseEntity<MemberDto> updateMemberInf(@RequestBody MemberDto memberDto) {
		log.info("updateMemberInf" + memberDto);
		memberService.updateMemberInf(memberDto);
		return new ResponseEntity<MemberDto>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/deleteMember")
	public ResponseEntity<MemberDto> deleteMember(@RequestBody MemberDto memberDto) {
		log.info("deleteMember" + memberDto);
		memberService.deleteMember(memberDto);
		return new ResponseEntity<MemberDto>(HttpStatus.OK);
	}
}
