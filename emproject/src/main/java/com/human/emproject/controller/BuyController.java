package com.human.emproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuyController {

    @GetMapping("/buyTicket")
    public String showTicketPage(Model model) {
        // 모델에 필요한 데이터 추가
        model.addAttribute("ticketTypes", new String[]{"standard", "premium"});
        model.addAttribute("ticketPrices", new int[]{10000, 30000});

        return "buyTicket";
    }

    // 필요한 경우 티켓 구매 양식 제출을 처리하는 메서드를 추가하세요.
}
