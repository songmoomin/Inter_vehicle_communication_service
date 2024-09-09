package com.lab4dx.inter_vehicle_communication_service.mapper;

import com.lab4dx.inter_vehicle_communication_service.dto.CustomizingSetting;

import java.util.List;

public interface CustomizingSettingMapper {

        CustomizingSetting getSettingByMemberAndEmoji(int memberId, int emojiId);
        List<CustomizingSetting> getAllSetting();
        void insertSetting(CustomizingSetting setting);
        void updateSetting(CustomizingSetting setting);
        void deleteSetting(int userId, int emojiId);

}
