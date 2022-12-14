package com.example.demo.review.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter @ToString
@AllArgsConstructor
public class Review {

    private long reviewId; //리뷰들을 식별하는 아이디
    private String userId; // 리뷰를 등록한 회원 아이디
    private String title; //리뷰 게시글의 제목
    private String img; //회원이 선택한 장소 사진
    private String content; //리뷰 내용

    private String cID;

    private static long seq;
    public Review(){this.reviewId = ++seq;}

    public Review(String title, String img, String content, List<Category> category){
        this();
        this.userId = "noname";
        this.title = title;
        this.img = img;
        this.content = content;

    }


}


