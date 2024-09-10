package com.lab4dx.inter_vehicle_communication_service.mapper;

import com.lab4dx.inter_vehicle_communication_service.dto.Default_Setting;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Default_SettingMapper {


    Default_Setting findByMemberId(String memberId);

    int updateMemberEmotionSetting(String textId, String memberId);
}

