package com.example.demo.user.service;

import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

//    private final PasswordEncoder encoder;

    //회원가입 기능
    public User createServ(final User userEntity) throws RuntimeException{
        if(userEntity == null || userEntity.getEmail() == null){
            throw new RuntimeException("Invalid args!");
        }

        //register 하기 전에 패스워드를 인코딩해야한다
//        String rawPw = userEntity.getPassword();
//        userEntity.setPassword(encoder.encode(rawPw));
        boolean flag = userRepository.register(userEntity);

        return flag ? getByCredential(userEntity.getEmail()) : null;
    }

    //이메일로 가입되어있는 유저를 찾는 기능
    public User getByCredential(String email){
        return userRepository.findUserByEmail(email);
    }

    //로그인 검증 기능
    public User validateLogin(final String email, final String password){
        //회원가입을 했는가
        User user = getByCredential(email);

        if(user == null) throw new RuntimeException("가입된 회원이 아닙니다");

//        패스워드가 일치하는가
//        if(!encoder.matches(password, user.getPassword())){
//            throw new RuntimeException("비밀번호가 틀렸습니다");
//        }

        return user; //로그인 성공시 회원정보 리턴

    }

    //이메일 중복체크(회원가입할 때)
    public boolean emailDuplicate(String email){ return userRepository.existByEmail(email);}

    //닉네임 중복체크(회원가입할 때)
    public boolean nicknameDuplicate(String nickname){ return userRepository.existByNickname(nickname);}
}
