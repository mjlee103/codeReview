package com.ds.member.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 무분별한 객체 생성을 한번더 체크 함
@Data
@Entity(name="member")
public class MemberDto {
	@Id
    private String memberId;
    private String memberPasswd;
    private String memberName;
    private String memberEmail;

}