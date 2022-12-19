package com.example.demo.review.dto;

import com.example.demo.review.entity.Category;
import com.example.demo.review.entity.Review;
import lombok.*;

import java.util.List;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private String postId; //useId로 나중에 바꿔주기
    private String title;
    private String image;
    private String content;
    private String cID;

    public ReviewDTO(Review review){
        this.postId = review.getPostId();
        this.title = review.getTitle();
        this.image = review.getImage();
        this.content = review.getContent();
        this.cID = review.getCID();
    }
}
