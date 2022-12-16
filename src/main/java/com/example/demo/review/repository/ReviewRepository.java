package com.example.demo.review.repository;

import com.example.demo.review.entity.Review;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;


//장소 리뷰를 CRUD한다.
@Mapper
public interface ReviewRepository {

    //게시글 저장 기능
    boolean save(Review review);

    //게시글 리스트 조회 기능
    List<Review> findAll();

    //게시글 개별 조회 기능
    Review findOne(String reviewId);

    //게시글 삭제 기능
    boolean remove(String  reviewId);

    //게시글 수정
    boolean modify(Review review);
}
