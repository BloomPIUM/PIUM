package com.bloom.pium.controller;

import com.bloom.pium.data.dto.UserInfoDto;
import com.bloom.pium.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class UserInfoController {
    private UserInfoService userInfoService;

    @Autowired
    public UserInfoController(UserInfoService userInfoService){
        this.userInfoService=userInfoService;
    }

    @GetMapping()
    public String joinTest(){
        return "SignupPage";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute UserInfoDto userInfoDto, Model model){

        if (!userInfoService.isUsernameUnique(userInfoDto.getUsername())) {
            model.addAttribute("error", "이미 사용 중인 아이디입니다.");
            return "SignupPage"; // 중복 아이디인 경우 회원가입 폼으로 다시 이동
        }else{
            userInfoService.join(userInfoDto);
            return "redirect:/login"; // 회원가입 후 로그인 페이지로 리다이렉트
        }

    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // 로그인 페이지로 이동
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // 로그인 처리 로직을 여기에 추가
        UserInfoDto checkUserDto = userInfoService.findUsername(username);
        // 입력값과 데이터베이스에서 조회한 엔티티 비교
        if (username != null && checkUserDto.getUsername().equals(username)) {
            // 값이 일치하는 경우
            if(password != null && checkUserDto.getPassword().equals(password)){
                return "BoardForm";
            }else{
                model.addAttribute("error", "비밀번호를 확인해주세요.");
            }
        } else {
            // 값이 불일치하는 경우
            model.addAttribute("error", "회원가입을 진행해주세요");
            return "redirect:/SignupPage";
        }

        return "redirect:/home"; // 로그인 성공 후 이동할 페이지
    }

}
