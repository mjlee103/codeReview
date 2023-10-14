package com.ds.member.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.member.dto.MemberDto;
import com.ds.member.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	private final Logger log = LoggerFactory.getLogger(MemberService.class);

    public MemberDto login(MemberDto memberDto) {
    	log.info("$$$memberId"+memberDto.getMemberId());
        Optional<MemberDto> existMember = memberRepository.findByMemberId(memberDto.getMemberId());
        if (existMember.isPresent()) { // 조회결과가 있다면
        	MemberDto memberInf = existMember.get();
        	log.info("$$memberIn--->"+memberInf);
        	
        	// 비밀번호 일치 확인
        	if (memberInf.getMemberPasswd().equals(memberDto.getMemberPasswd())){
        		return memberInf;
        	}else {
        		return null;
        	}
        }else {
        	return null;
        }
    }
    
    public void registerMember(MemberDto memberDto) {
    	memberRepository.save(memberDto);
    	return;
    }

    public MemberDto getMemberInf(MemberDto memberDto) {
    	log.info("$$$memberId"+memberDto.getMemberId());
        Optional<MemberDto> memberInfo = memberRepository.findByMemberId(memberDto.getMemberId());
        MemberDto memberInf = memberInfo.get();
        return memberInf;
    }
    
    public void updateMemberInf(MemberDto memberDto) {
    	log.info("$$$memberId"+memberDto.getMemberId());
        Optional<MemberDto> memberInf = memberRepository.findByMemberId(memberDto.getMemberId());
        if (memberInf.isPresent()) {
        	MemberDto updateInf = memberInf.get();
        	
        	updateInf.setMemberPasswd(memberDto.getMemberId());
        	updateInf.setMemberName(memberDto.getMemberName());
        	updateInf.setMemberEmail(memberDto.getMemberEmail());
        	
        	memberRepository.save(updateInf);
        }
    
    }
    
    public void deleteMember(MemberDto memberDto) {
    	memberRepository.deleteById(memberDto.getMemberId());
    	return;
    }
}
