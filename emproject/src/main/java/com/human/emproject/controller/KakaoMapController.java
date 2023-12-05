// KakaoMapController.java

package com.human.emproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KakaoMapController {

	@GetMapping("/kakaomap")
    public String showKakaoMap(Model model) {
        // 여기서 필요한 모델 데이터를 추가할 수 있습니다.
        return "map/kakaomap";
    }
}
