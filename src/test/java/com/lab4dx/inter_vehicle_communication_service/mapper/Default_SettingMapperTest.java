package com.lab4dx.inter_vehicle_communication_service.mapper;

import com.lab4dx.inter_vehicle_communication_service.dto.Default_Setting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Default_SettingMapperTest {

    @Autowired
    private Default_SettingMapper defaultSettingMapper;

    @Test
    void testFindByMemberId() {
        String memberId = "user123";
        defaultSettingMapper.findByMemberId(memberId);
        Default_Setting setting = defaultSettingMapper.findByMemberId(memberId);
        assertNotNull(setting);
        assertEquals(memberId, setting.getMember_id());
    }

    @Test
    void testUpdateMemberEmotionSetting() {
        String memberId = "user123";
        String textId = "text001";
        defaultSettingMapper.updateMemberEmotionSetting(textId, memberId);
        int result = defaultSettingMapper.updateMemberEmotionSetting(textId, memberId);
        assertEquals(1, result); // 업데이트가 성공했을 때 1 반환
    }
}

