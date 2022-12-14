package com.example.demo.review.dto;

import com.example.demo.review.entity.Review;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class FindAllDTO {
    private int count; //리뷰 목록 수

    private List<ReviewDTO> reviews; //userId가 빠진 리뷰 리스트

    public FindAllDTO(List<Review> reviewList){
        this.count = reviewList.size();
        this.convertDtoList(reviewList);
    }

    public void convertDtoList(List<Review> reviewList){
        List<ReviewDTO> dtos = new ArrayList<>();

        for(Review review : reviewList){
            dtos.add(new ReviewDTO(review));
        }
        this.reviews = dtos;
    }
}
