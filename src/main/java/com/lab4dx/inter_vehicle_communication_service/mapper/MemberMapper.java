package com.lab4dx.inter_vehicle_communication_service.mapper;

import com.lab4dx.inter_vehicle_communication_service.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {

    // 사용자 ID로 회원 정보를 조회
    @Select("SELECT * FROM C##LAB4DX.Member WHERE member_id = #{memberId}")
    Member findById(String memberId);

    // 새로운 회원을 삽입
    @Insert("INSERT INTO C##LAB4DX.Member (member_id, password, username, phone_number) VALUES (#{memberId}, #{password}, #{username}, #{phone})")
    int insertMember(Member member);
}

