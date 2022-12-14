package com.example.demo.review.dto;

import com.example.demo.review.entity.Category;
import com.example.demo.review.entity.Review;
import lombok.*;

import java.util.List;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO { //화면에 보여줄 리뷰 정보
    private long reviewId;
    private String title;
    private String img;
    private String content;


    public ReviewDTO(Review review){
        this.reviewId = review.getReviewId();
        this.title = review.getTitle();
        this.img = review.getImg();
        this.content = review.getContent();
    }
}
