package com.bloom.pium.controller;

import com.bloom.pium.data.dto.UserInfoDto;
import com.bloom.pium.data.dto.UserinfoResponseDto;
import com.bloom.pium.data.entity.UserInfo;
import com.bloom.pium.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserInfoController {
    private UserInfoService userInfoService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserInfoController(UserInfoService userInfoService, PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        this.userInfoService=userInfoService;
    }

    @GetMapping("")
    public String signupForm() {
//        UserInfoDto userInfoDto = new UserInfoDto(); // Create a new UserInfoDto Model model
//        model.addAttribute("userInfoDto", userInfoDto); // Add it to the model
        return "SignupPage";
    }


    @PostMapping("/signup")
    @ApiOperation(value = "회원가입")
    public String signup(@ModelAttribute UserInfoDto userInfoDto, Model model){

        if (!userInfoService.isUsernameUnique(userInfoDto.getUsername())) {
            model.addAttribute("error", "이미 사용 중인 아이디입니다.");
            return "SignupPage"; // 중복 아이디인 경우 회원가입 폼으로 다시 이동
        }else{
            userInfoService.join(userInfoDto);
            return "redirect:/user/login"; // 회원가입 후 로그인 페이지로 리다이렉트
        }
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // 로그인 페이지로 이동
    }

    @GetMapping("/mainPage")
    public String goToMain(){
        return "mainPage";
    }
    @PostMapping("/login")
    @ApiOperation(value = "로그인")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // 로그인 처리 로직을 여기에 추가
        UserinfoResponseDto checkUserDto = userInfoService.findUsername(username);

        // 입력값과 데이터베이스에서 조회한 엔티티 비교
        if (username != null && checkUserDto.getUsername().equals(username)) {
            // 값이 일치하는 경우
            if(password != null && passwordEncoder.matches(password,checkUserDto.getPassword())){

                return "redirect:/user/mainPage";
            } else {
                model.addAttribute("error", "비밀번호를 확인해주세요.");
            }
        }

        // 값이 불일치하는 경우
        model.addAttribute("error", "회원가입을 진행해주세요");
        return "redirect:/SignupPage";
    }

//    @GetMapping("/user/{username}")
//    public UserInfo getUserInfoByUsername(@PathVariable String username) {
//        return userInfoService.getUserInfoByUsername(username);
//    }

    //유저 정보 조회
    @GetMapping("/{username}")
    public String getUserInfoPage(@PathVariable String username, Model model) {
        UserInfo userInfo = userInfoService.getUserInfoByUsername(username);
        model.addAttribute("userInfo", userInfo);
        return "userinfo"; // 템플릿 파일의 이름 (user_info.html)

    }
    @GetMapping("/userinfo/{userId}")
    @ApiOperation(value = "마이 페이지")
    public String getUserInfo(@PathVariable Long userId, Model model) {
        UserInfo userInfo = userInfoService.getUserInfoByUserId(userId);

        if (userInfo != null) {
            model.addAttribute("userInfo", userInfo);
            return "myInfo"; // myInfo.html로 이동
        } else {
            // 유저 정보가 없을 경우 예외 처리
            return "error"; // 에러 페이지로 이동 또는 다른 처리 방법을 선택
        }
    }

}