package com.example.demo.review.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Setter @Getter @ToString
@AllArgsConstructor
public class Review {

    private String postId; //리뷰들을 식별하는 아이디
    private String userId; // 리뷰를 등록한 회원 아이디
    private String title; //리뷰 게시글의 제목
    private String image; //회원이 선택한 장소 사진
    private String content; //리뷰 내용

    private Date regDate;

    private String cID;


    public Review(){this.postId = UUID.randomUUID().toString();}

    public Review(String title, String image, String content, String cID){
        this();
        this.userId = "noname";
        this.title = title;
        this.image = image;
        this.content = content;
        this.cID = cID;
    }


}


