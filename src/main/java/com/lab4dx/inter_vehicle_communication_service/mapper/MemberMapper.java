package com.lab4dx.inter_vehicle_communication_service.mapper;

import com.lab4dx.inter_vehicle_communication_service.dto.Member;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {

    Member findById(String memberId);

    // 새로운 회원을 삽입
    int insertMember(Member member);
}

