package com.lab4dx.inter_vehicle_communication_service.mapper;

import com.lab4dx.inter_vehicle_communication_service.InterVehicleCommunicationServiceApplication;
import com.lab4dx.inter_vehicle_communication_service.dto.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional

public class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    @Sql(scripts = "/test-data.sql") // SQL 스크립트 파일 경로
    void testFindById() {
        Member retrievedMember = memberMapper.findById("user123");
        assertNotNull(retrievedMember);
        assertEquals("user123", retrievedMember.getMember_id());
        assertEquals("Test User", retrievedMember.getUsername());
    }

    @Test
    @Sql(scripts = "/test-data.sql") // SQL 스크립트 파일 경로
    void testInsertMember() {
        Member member = new Member();
        member.setMember_id("user456");
        member.setPassword("password");
        member.setUsername("Another User");
        member.setPhone_number("0987654321");

        int result = memberMapper.insertMember(member);
        assertEquals(1, result); // 삽입 성공 시 1 반환

        Member retrievedMember = memberMapper.findById("user456");
        assertNotNull(retrievedMember);
        assertEquals("user456", retrievedMember.getMember_id());
        assertEquals("Another User", retrievedMember.getUsername());
    }
}



