package com.ds.member.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ds.member.dto.MemberDto;

@Repository
public interface MemberRepository extends JpaRepository<MemberDto, String> {
    // long 이 아니라 Long으로 작성. ex) int => Integer 같이 primitive형식 사용못함
    // findBy뒤에 컬럼명을 붙여주면 이를 이용한 검색이 가능하다
    public Optional<MemberDto> findByMemberId(String memberId);
    public Optional<MemberDto> save(String memberId);
}