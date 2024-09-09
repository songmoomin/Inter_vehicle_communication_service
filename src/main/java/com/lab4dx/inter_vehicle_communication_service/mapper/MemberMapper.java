package com.lab4dx.inter_vehicle_communication_service.mapper;

import com.lab4dx.inter_vehicle_communication_service.dto.Member;

import java.util.List;

public interface MemberMapper {
    Member getMemberByIdAndPassword(String userId, String password);
    List<Member> getAllMembers();
    void insertMember(Member member);
    void updateMember(Member member);
    void deleteMember(int memberId);
}
