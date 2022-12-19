package com.example.demo.user.entity;

import com.example.demo.user.dto.UserRequestDTO;
import lombok.*;

import java.util.UUID;

@Setter @Getter @ToString
@AllArgsConstructor
public class User {
    private String uId;
    private String username;
    private String email;
    private String password;
    private String nickname;  //Post 객체의 userId 필드와 같은 값을 가진다. (두 테이블 중 하나의 필드명으로 통일시켜주기)

    public User(){
        this.uId = UUID.randomUUID().toString();
    }

    public User(UserRequestDTO dto){
        this();
    }
}
