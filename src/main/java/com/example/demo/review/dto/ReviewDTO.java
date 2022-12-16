package com.example.demo.review.dto;

import com.example.demo.review.entity.Category;
import com.example.demo.review.entity.Review;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO { //화면에 보여줄 리뷰 정보
    private String postId;
    private String title;
    private String image;
    private String content;

    private Date regDate;

    private String cID; //cID는 화면에 안보이도록 바꿔줘야 한다.


    public ReviewDTO(Review review){
        this.postId = review.getPostId();
        this.title = review.getTitle();
        this.image = review.getImage();
        this.content = review.getContent();
        this.regDate = review.getRegDate();
        this.cID = review.getCID();
    }
}
