package com.lab4dx.inter_vehicle_communication_service.controller;

import com.lab4dx.inter_vehicle_communication_service.dto.Default_Text;
import com.lab4dx.inter_vehicle_communication_service.service.Default_TextServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class Default_SettingController {

    @Autowired
    private Default_TextServiceImp defaultTextService;

    // 사용자가 선택할 수 있는 감정을 보여줌
    @GetMapping("/selectEmotion")
    public String selectEmotion(@RequestParam String sentiment, Model model) {
        List<Default_Text> texts = defaultTextService.getTextsBySentiment(sentiment);
        model.addAttribute("texts", texts);
        model.addAttribute("sentiment", sentiment);
        return "selectEmotion"; // HTML 템플릿 파일 이름
    }

    // 사용자가 선택한 감정으로 설정을 업데이트
    @PostMapping("/updateEmotionSetting")
    public String updateEmotionSetting(@RequestParam String memberId, @RequestParam String textId, RedirectAttributes redirectAttributes) {
        boolean success = defaultTextService.updateMemberEmotionSetting(memberId, textId);
        if (success) {
            redirectAttributes.addFlashAttribute("msg", "감정 설정이 성공적으로 변경되었습니다!");
        } else {
            redirectAttributes.addFlashAttribute("msg", "감정 설정 변경에 실패했습니다.");
        }
        return "redirect:/"; // 성공 후 리디렉션할 URL
    }
}

