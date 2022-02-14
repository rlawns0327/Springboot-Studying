package com.example.fisrtproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi") //접속할 Url이 입력 받았을 때 아래 메소드가 실행 greetings.mustache를 반환   //controller
    public String niceToMeetYou(Model model) {
        model.addAttribute("username","준");         // Model
        return "greetings"; // templates에 있는 greetings.mustache 찾아 있으면-> 전송
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickname","길동");
        return "goodbye";
    }

}
