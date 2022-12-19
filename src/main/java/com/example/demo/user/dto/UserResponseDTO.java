package com.example.demo.user.dto;

import com.example.demo.user.entity.User;
import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private String email;
    private String nickname;
    private String token;

    public UserResponseDTO(User user){
        this.email = user.getEmail();
        this.nickname = user.getNickname();
    }
}
