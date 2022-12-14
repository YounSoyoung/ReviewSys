package com.example.demo.review.repository;

import com.example.demo.review.entity.Category;
import com.example.demo.review.entity.Review;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewRepositoryImplTest {

    @Autowired
    ReviewRepository repository;

    @Test
    @DisplayName("저장소에서 목록을 조회했을 때 리뷰의 개수가 하나여야 한다")
    void findAllTest() {
        // given

        // when
        List<Review> reviewList = repository.findAll();

        // then
        assertEquals(1, reviewList.size());

    }

    @Test
    @DisplayName("아이디가 1번인 할일 데이터를 조회했을 때 그 작성자 이름이 김철수이어야 한다")
    void findOneTest() {
        // given
        long reviewId = 1L;

        // when
        Review review = repository.findOne(reviewId);

        // then
        assertEquals("김철수", review.getUserId());

    }

    @Test
    @DisplayName("2번 할 일을 등록했을 때 전체 목록의 개수가 2개여야 한다")
    void saveTest() {
        // given
        Category newCategory = new Category("서울", "노원구");
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(newCategory);
        Review newReview = new Review(2L, "박영희", "스타벅스", "커피사진", "카페가 넓다", categoryList);

        // when
        boolean flag = repository.save(newReview);
        List<Review> reviewList = repository.findAll();

        // then
        assertTrue(flag);
        assertEquals(2, reviewList.size());

    }

    @Test
    @DisplayName("1번 할일을 삭제한 후 다시 조회했을 때 null이 나와야 한다.")
    void removeTest() {
        // given
        long reviewId = 1L;

        // when
        boolean flag = repository.remove(reviewId);
        Review review = repository.findOne(reviewId);

        // then
        assertTrue(flag);
        assertNull(review);
        assertEquals(0, repository.findAll().size());

    }

    @Test
    @DisplayName("")
    void modifyTest() {
        // given
        Category newCategory = new Category("서울", "마포구");
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(newCategory);
        Review modifiedReview = new Review(1L, "박영희", "이너모스트", "카페사진과 커피 사진", "커피가 맛있고 분위기가 좋다.", categoryList);

        // when
        boolean flag = repository.modify(modifiedReview);
        List<Review> reviewList = repository.findAll();

        // then
        assertTrue(flag);
        assertEquals(1, reviewList.size());
    }

}