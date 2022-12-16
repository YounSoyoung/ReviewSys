//package com.example.demo.review.repository;
//
//import ch.qos.logback.core.util.COWArrayList;
//import com.example.demo.review.entity.Category;
//import com.example.demo.review.entity.Review;
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//
//@Repository
//public class ReviewRepositoryImpl implements ReviewRepository{
//
//    private static final Map<Long, Category> categoryMap = new HashMap<>();
//    private static final Map<Long, Review> reviewMap = new HashMap<>();
//
//    static {
//        categoryMap.put(1L, new Category(1L, "서울", "마포구"));
//        List<Category> categoryList = new ArrayList<>(categoryMap.values());
//        reviewMap.put(1L, new Review(1L, "김철수", "이너모스트", "카페사진", "커피가 맛있다.", categoryList));
//    }
//
//    @Override
//    public boolean save(Review review) {
//        if(review == null) return false;
//
//        reviewMap.put(review.getReviewId(), review);
//        return true;
//    }
//
//    @Override
//    public List<Review> findAll() {
//        List<Review> reviewList = new ArrayList<>();
//
//        for(Long reviewId : reviewMap.keySet()){
//            Review review = reviewMap.get(reviewId);
//            reviewList.add(review);
//        }
//        return reviewList;
//    }
//
//    @Override
//    public Review findOne(long reviewId) {
//        return reviewMap.get(reviewId);
//    }
//
//    @Override
//    public boolean remove(long reviewId) {
//        Review review = reviewMap.remove(reviewId);
//        return review != null;
//    }
//
//    @Override
//    public boolean modify(Review review) {
//        if(review == null) return false;
//
//        reviewMap.put(review.getReviewId(), review);
//        return true;
//    }
//}
