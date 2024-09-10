package com.lab4dx.inter_vehicle_communication_service.mapper;

import com.lab4dx.inter_vehicle_communication_service.dto.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

public class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    void testFindById() {
        Member retrievedMember = memberMapper.findById("user123");
        assertNotNull(retrievedMember);
        assertEquals("user123", retrievedMember.getMember_id());
        assertEquals("Test User", retrievedMember.getUsername());
    }

    @Test
    void testInsertMember() {
        Member member = new Member();
        member.setMember_id("user456");
        member.setPassword("password");
        member.setUsername("User1");
        member.setPhone_number("09874321");

        memberMapper.insertMember(member);

    }
}



