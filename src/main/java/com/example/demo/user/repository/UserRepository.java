package com.example.demo.user.repository;

import com.example.demo.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    //이메일 주소를 통해 회원정보 조회하기
    User findUserByEmail(String email);

    //이메일 주소가 중복인지 조회하기
    boolean existByEmail(String email);

    //닉네임이 중복인지 조회하기
    boolean existByNickname(String nickname);

    //회원가입하기
    boolean register(User user);
}
