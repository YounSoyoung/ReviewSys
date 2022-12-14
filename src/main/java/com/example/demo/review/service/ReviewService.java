package com.example.demo.review.service;

import com.example.demo.review.dto.FindAllDTO;
import com.example.demo.review.dto.ReviewDTO;
import com.example.demo.review.entity.Category;
import com.example.demo.review.entity.Review;
import com.example.demo.review.repository.CategoryRepository;
import com.example.demo.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository repository;
    private final CategoryService categoryService;

//    리뷰 목록 조회 중간처리
    public FindAllDTO findAllServ(){
       return new FindAllDTO(repository.findAll());
    }

    public FindAllDTO createServ(final Review newReview, String address) { //createServ(final Review newReview, Category category)
        Category category = categoryService.findCategoryServ(address);
        String categoryId = category.getCID();
        newReview.setCID(categoryId);

        if(newReview == null){
            log.warn("newReview cannot be null");
            throw new RuntimeException("newReview cannot be null!");
        }

        boolean flag = repository.save(newReview); //repository.save(newReview, c)

        if(flag) log.info("새로운 할일 [Id: {}]이 저장되었습니다.", newReview.getPostId());

        return flag ? findAllServ() : null; //새로운 리뷰를 삽입한 후 전체 리뷰 목록을 반환
    }

    //////////////카테고리에 해당하는 리뷰 리스트 반환
    public FindAllDTO searchReviewsServ(String address){
        Category category = categoryService.findCategoryServ(address);
        String categoryId = category.getCID();

        return new FindAllDTO(repository.findReviews(categoryId));
    }


    public ReviewDTO findOneServ(String postId) {
        Review review = repository.findOne(postId);
        log.info("findOneServ return data - {}", review);

        return review != null ? new ReviewDTO(review) : null;
    }

    public FindAllDTO deleteServ(String reviewId) {
        boolean flag = repository.remove(reviewId);

        if (!flag){
            log.warn("delete fail! not found id [{}]", reviewId);
            throw new RuntimeException("delete fail!");
        }
        return findAllServ();
    }

    public FindAllDTO update(Review review) {
        boolean flag = repository.modify(review);
        return flag ? findAllServ() : new FindAllDTO();
    }
}
