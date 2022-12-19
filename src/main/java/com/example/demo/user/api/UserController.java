package com.example.demo.user.api;

import com.example.demo.error.ErrorDTO;
import com.example.demo.user.dto.UserRequestDTO;
import com.example.demo.user.dto.UserResponseDTO;
import com.example.demo.user.entity.User;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Slf4j
@CrossOrigin
public class UserController {

    private final UserService userService;

    //회원가입 기능
    @PostMapping("/signup")
    public ResponseEntity<?> regist(@RequestBody UserRequestDTO reqDto){
        try {
            //userRequestDTO를 서비스에 전송
            //User 객체로 변환
            User userEntity = new User(reqDto);
            log.info("/auth/signup POST request - {}", userEntity);

            User user = userService.createServ(userEntity);

            return ResponseEntity.ok().body(new UserResponseDTO(user));
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //로그인 기능
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody UserRequestDTO reqDto){
        log.info("/auth/signin POST - login info: {}", reqDto);

        try {
            User user = userService.validateLogin(reqDto.getEmail(), reqDto.getPassword());

            UserResponseDTO responseDTO = new UserResponseDTO(user);

            return ResponseEntity.ok().body(responseDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new ErrorDTO(e.getMessage()));
        }
    }

    //이메일과 닉네임 중복 확인 기능
    // RequestBody나 PathVariable이 없으므로 /auth/check?email=abc@abc.com&nickname=홍홍홍
    @GetMapping("/check")
    public ResponseEntity<?> checkDuplicate(String email, String nickname){
        boolean emailFlag = userService.emailDuplicate(email);
        boolean nicknameFlag = userService.nicknameDuplicate(nickname);
        log.info("{} 중복여부 - {}", email, emailFlag);
        log.info("{} 중복여부 - {}", nickname, nicknameFlag);

        ArrayList<Boolean> flag = new ArrayList<>(Arrays.asList(emailFlag, nicknameFlag));

        return ResponseEntity.ok().body(flag);
    }
}
